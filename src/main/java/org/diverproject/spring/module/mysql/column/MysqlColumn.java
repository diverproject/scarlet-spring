package org.diverproject.spring.module.mysql.column;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(catalog = "information_schema", name = "columns")
@IdClass(MysqlColumnId.class)
@Immutable
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MysqlColumn implements org.diverproject.spring.module.column.Column
{
	private static final long serialVersionUID = -8769277903119812259L;

	@Id
	@Column(name = "table_schema")
	private String schemaName;

	@Id
	private String tableName;

	@Id
	private String columnName;
	private long ordinalPosition;
	private String columnDefault;

	@NotNull
	@Enumerated(EnumType.STRING)
	private MysqlColumnNullable isNullable;

	private String dataType;
	private Long characterMaximumLength;
	private Long characterOctetLength;
	private Long numericPrecision;
	private Long numericScale;
	private Long datetimePrecision;
	private String characterSetName;
	private String collationName;

	@NotNull
	private String columnType;

	@NotNull
	@Convert(converter = MysqlColumnKeyConverter.class)
	private MysqlColumnKey columnKey;

	private String extra;
	private String privileges;

	@NotNull
	private String columnComment;

	@NotNull
	private String generationExpression;
	private Long srsId;

	@Override
	public boolean isNullable()
	{
		return MysqlColumnNullable.YES.equals(this.getIsNullable());
	}
}
