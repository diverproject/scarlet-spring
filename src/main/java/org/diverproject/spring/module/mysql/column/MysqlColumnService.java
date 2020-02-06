package org.diverproject.spring.module.mysql.column;

import org.diverproject.spring.module.column.ColumnService;
import org.diverproject.spring.module.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MysqlColumnService implements ColumnService<MysqlColumn>
{
	@Autowired
	private MysqlColumnRepository mysqlColumnRepository;

	@Override
	public Optional<MysqlColumn> getColumn(Table table, String columnName)
	{
		return this.mysqlColumnRepository.findById(new MysqlColumnId(table.getSchemaName(), table.getTableName(), columnName));
	}

	@Override
	public List<MysqlColumn> getColumns(Table table)
	{
		return this.mysqlColumnRepository.findBySchemaNameAndTableName(table.getSchemaName(), table.getTableName());
	}
}
