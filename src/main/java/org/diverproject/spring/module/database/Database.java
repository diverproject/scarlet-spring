package org.diverproject.spring.module.database;

public enum Database
{
	MYSQL("mysql"),
	ORACLE("oracle"),

	;

	private String name;

	private Database(String databaseName)
	{
		this.name = databaseName;
	}

	public String getName()
	{
		return this.name;
	}
}
