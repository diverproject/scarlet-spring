package org.diverproject.spring.module.mysql.table;

import org.diverproject.spring.module.schema.Schema;
import org.diverproject.spring.module.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MysqlTableService implements TableService<MysqlTable>
{
	@Autowired
	private MysqlTableRepository mysqlTableRepository;

	@Override
	public Optional<MysqlTable> getTable(Schema schema, String name)
	{
		return this.mysqlTableRepository.findById(new MysqlTableId(schema.getName(), name));
	}

	@Override
	public List<MysqlTable> getTables(Schema schema)
	{
		return this.mysqlTableRepository.findBySchemaName(schema.getName());
	}
}
