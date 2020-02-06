package org.diverproject.spring.config;

import static java.lang.String.format;

import org.diverproject.spring.dto.ResponseErrorDto;
import org.diverproject.spring.module.NotFoundException;
import org.diverproject.spring.module.database.DatabaseNotFoundException;
import org.diverproject.spring.module.schema.SchemaNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandleRequest extends ResponseEntityExceptionHandler
{
	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<ResponseErrorDto> handleException(Exception e)
	{
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(ExceptionHandleRequestUtils.responseErrorOf(e, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@ExceptionHandler({ NullPointerException.class })
	protected ResponseEntity<ResponseErrorDto> handleException(NullPointerException e)
	{
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(ExceptionHandleRequestUtils.responseErrorOf(e, HttpStatus.INTERNAL_SERVER_ERROR).setMessage("A noob implementation found"));
	}

	@ExceptionHandler({ NotFoundException.class })
	protected ResponseEntity<?> handleNotFound(NotFoundException e)
	{
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler({ DatabaseNotFoundException.class })
	protected ResponseEntity<?> handleNotFound(DatabaseNotFoundException e)
	{
		return ResponseEntity
			.badRequest()
			.body(
				ExceptionHandleRequestUtils.responseErrorOf(e)
					.setMessage(format("database not found (db: %s)", e.getDatabaseName()))
			);
	}

	@ExceptionHandler({ SchemaNotFound.class })
	protected ResponseEntity<?> handleNotFound(SchemaNotFound e)
	{
		return ResponseEntity
			.badRequest()
			.body(
				ExceptionHandleRequestUtils.responseErrorOf(e)
					.setMessage(format("schema not found (schema: %s)", e.getSchemaName()))
			);
	}
}
