package org.diverproject.spring.module.mysql.table;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(catalog = "information_schema", name = "tables")
@IdClass(MysqlTableId.class)
@Immutable
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MysqlTable implements org.diverproject.spring.module.table.Table
{
	private static final long serialVersionUID = 7861247320681327336L;

	@Id
	@Column(name = "table_schema")
	private String schemaName;

	@Id
	@Column(name = "table_name")
	private String tableName;

	@NotNull
	@Convert(converter = MysqlTableTypeConverter.class)
	private MysqlTableType tableType;
	private String engine;
	private Integer version;

	@Enumerated(EnumType.STRING)
	private MysqlTableRowFormat rowFormat;
	private Long tableRows;

	@Column(name = "avg_row_length")
	private Long averageRowLength;
	private Long dataLength;
	private Long maxDataLength;
	private Long indexLength;
	private Long dataFree;
	private Long autoIncrement;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	private Date updateTime;
	private Date checkTime;
	private String tableCollation;
	private Long checksum;
	private String createOptions;
	private String tableComment;
}
