package org.diverproject.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDto implements Serializable
{
	private static final long serialVersionUID = -5896345121902377037L;

	private HttpStatus httpStatus;
	private String message;
	private String exception;
	private ErrorTraceDto trace;
	private ResponseErrorDto cause;
}
