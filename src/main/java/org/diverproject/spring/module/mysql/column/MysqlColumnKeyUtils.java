package org.diverproject.spring.module.mysql.column;

public class MysqlColumnKeyUtils
{
	public static MysqlColumnKey parse(String value)
	{
		for (MysqlColumnKey mysqlColumnKey : MysqlColumnKey.values())
			if (mysqlColumnKey.value().equalsIgnoreCase(value))
				return mysqlColumnKey;

		return null;
	}
}
