package org.diverproject.spring.module.mysql.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.diverproject.spring.module.schema.Schema;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "information_schema", name = "schemata")
@Immutable
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MysqlSchema implements Schema
{
	private static final long serialVersionUID = 5660238459947802556L;

	@Id
	@Column(name = "schema_name")
	private String name;
	private String defaultCharacterSetName;
	private String defaultCollationName;
	private String sqlPath;
	@Enumerated(EnumType.STRING)
	private SchemaEncryption defaultEncryption;
}
