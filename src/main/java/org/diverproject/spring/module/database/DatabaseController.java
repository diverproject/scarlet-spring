package org.diverproject.spring.module.database;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.diverproject.spring.module.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/database")
@Api(value = "Database", tags = { "Database" })
public class DatabaseController
{
	@Autowired
	private DatabaseService databaseService;

	@ApiOperation(value = "Change database by name", notes = "Change all database layout generator by database name informed")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = String.class),
		@ApiResponse(code = 404, message = "Database name not found or not supported")
	})
	@PostMapping("/")
	public ResponseEntity<String> onChangeDatabase(@RequestBody String databaseName)
	{
		return ResponseEntity.ok(this.databaseService.setDatabase(databaseName));
	}

	@ApiOperation(value = "Get database by name", notes = "Get current database layout used on all generate modules")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Operation performed successfully", response = String.class),
		@ApiResponse(code = 404, message = "Database layout not defined yet")
	})
	@GetMapping("/")
	public ResponseEntity<String> onRequestDatabase()
	{
		return ResponseEntity.ok(Optional.ofNullable(this.databaseService.getDatabase()).orElseThrow(NotFoundException::new).getName());
	}
}
