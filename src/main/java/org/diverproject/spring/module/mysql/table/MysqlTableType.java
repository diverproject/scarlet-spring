package org.diverproject.spring.module.mysql.table;

public enum MysqlTableType
{
	BASE_TABLE      ("BASE TABLE"),
	VIEW            ("VIEW"),
	SYSTEM_VIEW     ("SYSTEM VIEW"),

	;

	private final String value;

	MysqlTableType(String value)
	{
		this.value = value;
	}

	public String value()
	{
		return this.value;
	}
}
