package org.diverproject.spring.module;

import static org.diverproject.scarlet.util.ScarletUtils.nameOf;
import static org.diverproject.spring.module.ModuleLanguage.PATCH_GET_FIELD_BY_NAME;

import org.diverproject.spring.dto.PatchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ResponseEntityUtils
{
	private static final String PATCH_REPLACED = "replaced";

	private ResponseEntityUtils() { }

	public static <D extends Serializable> ResponseEntity<D> get(D dto)
	{
		return ResponseEntity.ok(dto);
	}

	public static <M extends Serializable, D extends Serializable> ResponseEntity<List<D>> get(List<M> models, Class<D> dtoClass)
	{
		return ResponseEntity.ok(ObjectMapperUtils.mapAll(models, dtoClass));
	}

	public static <M extends Serializable, D extends Serializable> ResponseEntity<D> get(Optional<M> model, Class<D> dtoClass)
	{
		return ResponseEntity.ok(ObjectMapperUtils.map(model.orElseThrow(NotFoundException::new), dtoClass));
	}

	public static <M extends Serializable, D extends Serializable> ResponseEntity<D> get(M model, Class<D> dtoClass)
	{
		return ResponseEntity.ok(ObjectMapperUtils.map(model, dtoClass));
	}

	public static <M extends Serializable, D extends Id> ResponseEntity<?> post(M model, Class<D> dtoClass)
	{
		return created(ObjectMapperUtils.map(model, dtoClass), "/{id}");
	}

	public static <M extends Serializable, D extends Id> ResponseEntity<?> put(M model, Class<D> dtoClass)
	{
		return notContent(ObjectMapperUtils.map(model, dtoClass), "/{id}");
	}

	public static <M extends Serializable> ResponseEntity<List<PatchDto<?>>> patchAll(M model)
	{
		List<PatchDto<?>> patches = new ArrayList<>();

		for (Field field : model.getClass().getDeclaredFields())
			patches.add(patchDtoOf(field, model));

		return ResponseEntity.ok(patches);
	}

	public static <M extends Serializable> ResponseEntity<List<PatchDto<?>>> patch(M model, String name)
	{
		List<PatchDto<?>> patches = new ArrayList<>();

		try {

			Field field = model.getClass().getDeclaredField(name);
			patches.add(patchDtoOf(field, model));

		} catch (NoSuchFieldException e) {
			throw new ModuleException(e, PATCH_GET_FIELD_BY_NAME, nameOf(model), name);
		}

		return ResponseEntity.ok(patches);
	}

	private static <M extends Serializable> PatchDto<?> patchDtoOf(Field field, M model)
	{
		try {

			field.setAccessible(true);
			PatchDto<?> patchDto = new PatchDto<>()
				.setOperation(PATCH_REPLACED)
				.setPatch(ServletUriComponentsBuilder.fromCurrentRequest().toUriString())
				.setValue(field.get(model));
			field.setAccessible(false);

			return patchDto;

		} catch (IllegalAccessException e) {
			throw new ModuleException(e, PATCH_GET_FIELD_BY_NAME, nameOf(model), field.getName());
		}
	}

	public static <D extends Id> ResponseEntity<?> created(D dto, String path)
	{
		if (dto == null || dto.getId() == 0)
			return ResponseEntity.badRequest().body(dto);

		return ResponseEntity.created(uriOf(dto, path)).build();
	}

	public static <D extends Id> ResponseEntity<?> notContent(D dto, String path)
	{
		if (dto == null || dto.getId() == 0)
			return ResponseEntity.badRequest().body(dto);

		return ResponseEntity.created(uriOf(dto, path)).build();
	}

	private static <D extends Id> URI uriOf(D dto, String path)
	{
		return ServletUriComponentsBuilder.fromCurrentRequest()
			.path(path)
			.buildAndExpand(map("id", dto.getId()))
			.toUri();
	}

	private static Map<String, String> map(Object... parameters)
	{
		Map<String, String> map = new TreeMap<>();

		for (int i = 0; i + 1 < parameters.length; i += 2)
			map.put(parameters[i].toString(), parameters[i + 1].toString());

		return map;
	}

	public static <T> ResponseEntity<?> delete()
	{
		return ResponseEntity.noContent().build();
	}
}
