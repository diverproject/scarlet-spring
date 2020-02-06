package org.diverproject.spring.module.database;

import org.diverproject.spring.module.column.ColumnService;
import org.diverproject.spring.module.schema.SchemaService;
import org.diverproject.spring.module.table.TableService;

public interface DatabaseServiceFactory
{
	SchemaService<?> getSchemaService();
	TableService<?> getTableService();
	ColumnService<?> getColumnService();
}
