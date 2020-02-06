package org.diverproject.spring.module.schema;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.diverproject.spring.module.ResponseEntityUtils;
import org.diverproject.spring.module.database.DatabaseService;
import org.diverproject.spring.module.database.DatabaseServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/schema")
@Api(value = "Schema", tags = { "Schema" })
public class SchemaController
{
	@Autowired
	private DatabaseService databaseService;

	@ApiOperation(value = "List schemas", notes = "Get a list of all schemas available on database")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = SchemaDto[].class),
		@ApiResponse(code = 404, message = "Schema not found")
	})
	@GetMapping("/schemas")
	public ResponseEntity<List<SchemaDto>> onListSchemas()
	{
		return ResponseEntityUtils.get(this.getDatabaseServiceFactory().getSchemaService().getSchemas(), SchemaDto.class);
	}

	@ApiOperation(value = "Get schema", notes = "Get one schema on database by schema name")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = SchemaDto.class),
		@ApiResponse(code = 404, message = "Schema not found by name")
	})
	@GetMapping("/{name}")
	public ResponseEntity<SchemaDto> onGetByName(@PathVariable String name)
	{
		return ResponseEntityUtils.get(this.getDatabaseServiceFactory().getSchemaService().getSchema(name), SchemaDto.class);
	}

	private DatabaseServiceFactory getDatabaseServiceFactory()
	{
		return this.databaseService.getDatabaseServiceFactory();
	}
}
