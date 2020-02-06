package org.diverproject.spring.module.column;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.diverproject.spring.module.ResponseEntityUtils;
import org.diverproject.spring.module.database.DatabaseService;
import org.diverproject.spring.module.database.DatabaseServiceFactory;
import org.diverproject.spring.module.schema.SchemaNotFound;
import org.diverproject.spring.module.table.Table;
import org.diverproject.spring.module.table.TableNotFound;
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
@RequestMapping("/schema/{schemaName}/{tableName}")
@Api(value = "Column", tags = { "Column" })
public class ColumnController
{
	@Autowired
	private DatabaseService databaseService;

	@ApiOperation(value = "List columns", notes = "Get a list of all columns available on table")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = ColumnDto[].class),
		@ApiResponse(code = 404, message = "Schema not found")
	})
	@GetMapping("/columns")
	public ResponseEntity<List<ColumnDto>> onListColumns(@PathVariable("schemaName") String schemaName, @PathVariable("tableName") String tableName)
	{
		return ResponseEntityUtils.get(
			this.getDatabaseServiceFactory().getColumnService().getColumns(
				tableOf(schemaName, tableName)
			),
			ColumnDto.class
		);
	}

	@ApiOperation(value = "Get column", notes = "Get one column on table by column name")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = ColumnDto.class),
		@ApiResponse(code = 404, message = "Column not found by name")
	})
	@GetMapping("/{columnName}")
	public ResponseEntity<ColumnDto> onGetByName(@PathVariable("schemaName") String schemaName, @PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName)
	{
		return ResponseEntityUtils.get(
			this.getDatabaseServiceFactory().getColumnService().getColumn(
				tableOf(schemaName, tableName),
				columnName
			),
			ColumnDto.class
		);
	}

	private Table tableOf(String schemaName, String tableName)
	{
		return this.getDatabaseServiceFactory().getTableService().getTable(
			this.getDatabaseServiceFactory().getSchemaService().getSchema(schemaName).orElseThrow(
				() -> new SchemaNotFound(schemaName)
			),
			tableName
		).orElseThrow(
			() -> new TableNotFound(tableName)
		);
	}

	private DatabaseServiceFactory getDatabaseServiceFactory()
	{
		return this.databaseService.getDatabaseServiceFactory();
	}
}
