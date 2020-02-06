package org.diverproject.spring.module.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SchemaDto implements Serializable
{
	private static final long serialVersionUID = 5924192555669097556L;

	private String name;
}
