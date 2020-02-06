package org.diverproject.spring.module.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class SchemaNotFound extends RuntimeException
{
	private static final long serialVersionUID = -5301163871990235780L;

	private String schemaName;
}
