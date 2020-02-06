package org.diverproject.spring.module.mysql.table;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MysqlTableRepository extends JpaRepository<MysqlTable, MysqlTableId>
{
	List<MysqlTable> findBySchemaName(String schemaName);
}
