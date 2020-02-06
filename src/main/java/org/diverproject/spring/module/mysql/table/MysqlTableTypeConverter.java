package org.diverproject.spring.module.mysql.table;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MysqlTableTypeConverter implements AttributeConverter<MysqlTableType, String>
{
	@Override
	public String convertToDatabaseColumn(MysqlTableType mysqlTableType)
	{
		return mysqlTableType.value();
	}

	@Override
	public MysqlTableType convertToEntityAttribute(String s)
	{
		return MysqlTableTypeUtils.parse(s);
	}
}
