package org.diverproject.spring.module.table;

import org.diverproject.spring.module.schema.Schema;

import java.util.List;
import java.util.Optional;

public interface TableService<S extends Table>
{
	Optional<S> getTable(Schema schema, String name);
	List<S> getTables(Schema schema);
}
