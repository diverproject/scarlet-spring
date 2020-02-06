package org.diverproject.spring.module.database;

import org.diverproject.spring.module.spring.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService
{
	private SpringService springService;

	private Database database;
	private DatabaseServiceFactory databaseServiceFactory;

	@Autowired
	public DatabaseService(SpringService springService)
	{
		this.springService = springService;
		this.database = Database.MYSQL;
		this.databaseServiceFactory = springService.getBeanByDatabase(DatabaseServiceFactory.class, this.database);
	}

	public String setDatabase(String databaseName)
	{
		this.database = DatabaseUtils.ofDatabaseName(databaseName).orElseThrow(
			() -> new DatabaseNotFoundException(databaseName)
		);
		this.databaseServiceFactory = this.springService.getBeanByDatabase(DatabaseServiceFactory.class, this.database);

		return databaseName;
	}

	public Database getDatabase()
	{
		return database;
	}

	public DatabaseServiceFactory getDatabaseServiceFactory()
	{
		return databaseServiceFactory;
	}
}
