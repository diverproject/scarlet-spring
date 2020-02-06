package org.diverproject.spring.module.database;

import java.util.Optional;

public class DatabaseUtils
{
	private DatabaseUtils() { }

	public static Optional<Database> ofDatabaseName(String databaseName)
	{
		for (Database database : Database.values())
			if (database.getName().equalsIgnoreCase(databaseName))
				return Optional.of(database);

		return Optional.empty();
	}
}
