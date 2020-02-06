package org.diverproject.spring.module.mysql.schema;

import org.diverproject.spring.module.schema.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MysqlSchemaService implements SchemaService<MysqlSchema>
{
	@Autowired
	private MysqlSchemaRepository mysqlSchemaRepository;

	@Override
	public Optional<MysqlSchema> getSchema(String name)
	{
		return mysqlSchemaRepository.findById(name);
	}

	@Override
	public List<MysqlSchema> getSchemas()
	{
		return this.mysqlSchemaRepository.findAll();
	}
}
