package org.diverproject.spring.module.table;

import java.io.Serializable;

public interface Table extends Serializable
{
	String getSchemaName();
	String getTableName();
}
