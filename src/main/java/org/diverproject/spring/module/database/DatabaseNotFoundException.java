package org.diverproject.spring.module.database;

public class DatabaseNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -8286034292896331798L;

	private String databaseName;

	public DatabaseNotFoundException(String databaseName)
	{
		this.databaseName = databaseName;
	}

	public String getDatabaseName()
	{
		return databaseName;
	}
}
