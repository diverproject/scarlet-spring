package org.diverproject.spring.module.mysql;

import org.diverproject.spring.module.database.DatabaseServiceFactory;
import org.diverproject.spring.module.mysql.column.MysqlColumnService;
import org.diverproject.spring.module.mysql.schema.MysqlSchemaService;
import org.diverproject.spring.module.mysql.table.MysqlTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mysqlDatabaseServiceFactory")
public class MysqlDatabaseServiceFactory implements DatabaseServiceFactory
{
	@Autowired
	private MysqlSchemaService mysqlSchemaService;

	@Autowired
	private MysqlTableService mysqlTableService;

	@Autowired
	private MysqlColumnService mysqlColumnService;

	@Override
	public MysqlSchemaService getSchemaService()
	{
		return this.mysqlSchemaService;
	}

	@Override
	public MysqlTableService getTableService()
	{
		return this.mysqlTableService;
	}

	@Override
	public MysqlColumnService getColumnService()
	{
		return this.mysqlColumnService;
	}
}
