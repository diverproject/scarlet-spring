package org.diverproject.spring.module.column;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ColumnDto implements Serializable
{
	private static final long serialVersionUID = -6646750686863997008L;

	private String schemaName;
	private String tableName;
	private String columnName;
	private String dataType;
	private boolean nullable;
}
