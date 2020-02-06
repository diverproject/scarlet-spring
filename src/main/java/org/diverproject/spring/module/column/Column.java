package org.diverproject.spring.module.column;

import java.io.Serializable;

public interface Column extends Serializable
{
	String getSchemaName();
	String getTableName();
	String getColumnName();
	String getDataType();
	boolean isNullable();
}
