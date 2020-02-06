package org.diverproject.spring.module;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtils
{
	private static final ModelMapper modelMapper;

	static
	{
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	private ObjectMapperUtils() { }

	public static <D extends Serializable> D map(final Serializable object, Class<D> targetClass)
	{
		return modelMapper.map(object, targetClass);
	}

	public static <D extends Serializable> D map(final Serializable object, D target)
	{
		modelMapper.map(object, target);

		return target;
	}

	public static <D extends Serializable, O extends Serializable> List<D> mapAll(final Collection<O> objects, Class<D> targetClass)
	{
		return objects.stream()
			.map(object -> map(object, targetClass))
			.collect(Collectors.toList());
	}
}
