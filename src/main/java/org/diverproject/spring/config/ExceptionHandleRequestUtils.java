package org.diverproject.spring.config;

import org.diverproject.spring.dto.ErrorTraceDto;
import org.diverproject.spring.dto.ResponseErrorDto;
import org.springframework.http.HttpStatus;

public class ExceptionHandleRequestUtils
{
	private ExceptionHandleRequestUtils() { }

	public static ResponseErrorDto responseErrorOf(Exception e)
	{
		return responseErrorOf(e, HttpStatus.BAD_REQUEST);
	}

	public static ResponseErrorDto responseErrorOf(Exception e, HttpStatus httpStatus)
	{
		ResponseErrorDto responseError = new ResponseErrorDto()
			.setHttpStatus(httpStatus)
			.setMessage(e.getMessage())
			.setTrace(traceOf(e.getStackTrace()[0]))
			.setException(e.getClass().getSimpleName());

		if (e.getCause() != null)
			responseError.setCause(responseErrorOf(e.getCause()));

		return responseError;
	}

	public static ResponseErrorDto responseErrorOf(Throwable e)
	{
		return new ResponseErrorDto()
			.setHttpStatus(HttpStatus.BAD_REQUEST)
			.setMessage(e.getMessage())
			.setTrace(traceOf(e.getStackTrace()[0]))
			.setException(e.getClass().getSimpleName());
	}

	private static ErrorTraceDto traceOf(StackTraceElement stackTraceElement)
	{
		return new ErrorTraceDto()
			.setClassName(stackTraceElement.getClassName())
			.setMethodName(stackTraceElement.getMethodName())
			.setLineNumber(stackTraceElement.getLineNumber());
	}
}
