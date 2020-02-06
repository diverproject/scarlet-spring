package org.diverproject.spring.module.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TableDto implements Serializable
{
	private static final long serialVersionUID = 5924192555669097556L;

	private String schemaName;
	private String tableName;
}
