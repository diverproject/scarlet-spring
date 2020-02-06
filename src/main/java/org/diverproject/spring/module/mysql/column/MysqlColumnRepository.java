package org.diverproject.spring.module.mysql.column;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MysqlColumnRepository extends JpaRepository<MysqlColumn, MysqlColumnId>
{
	List<MysqlColumn> findBySchemaNameAndTableName(String schemaName, String tableName);
}
