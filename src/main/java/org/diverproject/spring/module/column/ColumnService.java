package org.diverproject.spring.module.column;

import org.diverproject.spring.module.table.Table;

import java.util.List;
import java.util.Optional;

public interface ColumnService<C extends Column>
{
	Optional<C> getColumn(Table table, String columnName);
	List<C> getColumns(Table table);
}
