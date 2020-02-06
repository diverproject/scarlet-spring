package org.diverproject.spring.module.mysql.schema;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MysqlSchemaRepository extends JpaRepository<MysqlSchema, String>
{
}
