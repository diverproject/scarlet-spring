package org.diverproject.spring.module.schema;

import java.util.List;
import java.util.Optional;

public interface SchemaService<S extends Schema>
{
	Optional<S> getSchema(String name);
	List<S> getSchemas();
}
