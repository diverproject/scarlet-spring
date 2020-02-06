package org.diverproject.spring.module.mysql.column;

public enum MysqlColumnKey
{
	NONE            (""),
	PRIMARY_KEY     ("PRI"),
	UNIQUE_KEY      ("UNI"),
	MULTIPLE_KEY    ("MUL"),

	;

	private final String value;

	private MysqlColumnKey(String value)
	{
		this.value = value;
	}

	public String value()
	{
		return value;
	}
}
