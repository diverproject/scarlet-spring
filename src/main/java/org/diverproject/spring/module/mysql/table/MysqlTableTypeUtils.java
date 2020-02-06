package org.diverproject.spring.module.mysql.table;

public class MysqlTableTypeUtils
{
	public static MysqlTableType parse(String s)
	{
		for (MysqlTableType mysqlTableType : MysqlTableType.values())
			if (mysqlTableType.value().equals(s))
				return mysqlTableType;

		return null;
	}
}
