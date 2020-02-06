package org.diverproject.spring.module.mysql.column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MysqlColumnId implements Serializable
{
	private static final long serialVersionUID = 3958232832832220857L;

	@Column(name = "table_schema")
	private String schemaName;
	private String tableName;
	private String columnName;
}
