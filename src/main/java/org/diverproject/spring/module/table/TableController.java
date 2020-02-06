package org.diverproject.spring.module.table;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.diverproject.spring.module.ResponseEntityUtils;
import org.diverproject.spring.module.database.DatabaseService;
import org.diverproject.spring.module.database.DatabaseServiceFactory;
import org.diverproject.spring.module.schema.Schema;
import org.diverproject.spring.module.schema.SchemaNotFound;
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
@RequestMapping("/schema/{schemaName}")
@Api(value = "Table", tags = { "Table" })
public class TableController
{
	@Autowired
	private DatabaseService databaseService;

	@ApiOperation(value = "List tables", notes = "Get a list of all tables available on schema")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = TableDto[].class),
		@ApiResponse(code = 404, message = "Schema not found")
	})
	@GetMapping("/tables")
	public ResponseEntity<List<TableDto>> onListSchemas(@PathVariable("schemaName") String schemaName)
	{
		return ResponseEntityUtils.get(
			this.getDatabaseServiceFactory().getTableService().getTables(
				schemaOf(schemaName)
			),
			TableDto.class
		);
	}

	@ApiOperation(value = "Get table", notes = "Get one table on schema by table name")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = TableDto.class),
		@ApiResponse(code = 404, message = "Schema not found by name")
	})
	@GetMapping("/{tableName}")
	public ResponseEntity<TableDto> onGetByName(@PathVariable("schemaName") String schemaName, @PathVariable("tableName") String tableName)
	{
		return ResponseEntityUtils.get(
			this.getDatabaseServiceFactory().getTableService().getTable(
				schemaOf(schemaName),
				tableName
			),
			TableDto.class
		);
	}

	private Schema schemaOf(String name)
	{
		return this.getDatabaseServiceFactory().getSchemaService().getSchema(name).orElseThrow(
			() -> new SchemaNotFound(name)
		);
	}

	private DatabaseServiceFactory getDatabaseServiceFactory()
	{
		return this.databaseService.getDatabaseServiceFactory();
	}
}
