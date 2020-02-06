package org.diverproject.spring.module.mysql.column;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MysqlColumnKeyConverter implements AttributeConverter<MysqlColumnKey, String>
{
	@Override
	public String convertToDatabaseColumn(MysqlColumnKey columnKey)
	{
		return columnKey.value();
	}

	@Override
	public MysqlColumnKey convertToEntityAttribute(String s)
	{
		return MysqlColumnKeyUtils.parse(s);
	}
}
