package com.infy.employeeService.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeeService.dto.EmployeeDTO;
import com.infy.employeeService.exception.EException;
import com.infy.employeeService.service.EService;

@CrossOrigin
@RestController
@RequestMapping(value = "/employees")
@Validated
public class EController {

	@Autowired
	private EService service;

	@Autowired
	private Environment env;

	/// ----------------------Fetching all employees records
	@GetMapping(value = "")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws EException {
		return new ResponseEntity<List<EmployeeDTO>>(service.getAllEmployees(), HttpStatus.OK);
	}

	/// ----------------------Fetching only the employee record whose id matches
	@GetMapping(value = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployees(@PathVariable("employeeId") Integer employeeId) throws EException {
		return new ResponseEntity<EmployeeDTO>(service.getEmployeeDetails(employeeId), HttpStatus.OK);
	}

	/// ----------------------Changing the record details of employee whose id matches
	@PutMapping(value = "")
	public ResponseEntity<String> updateEmployeeDetails(@Valid @RequestBody EmployeeDTO employeeDTO) throws EException {
		service.updateProfile(employeeDTO);
		return new ResponseEntity<String>(env.getProperty("API.UPDATE_SUCCESS"), HttpStatus.ACCEPTED);
	}

	/// ----------------------Removing an employee record completely
	@DeleteMapping(value = "/{employeeId}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable("employeeId") Integer employeeId)
			throws EException {
		service.removeEmployee(employeeId);
		return new ResponseEntity<String>(env.getProperty("API.DELETE_SUCCESS"), HttpStatus.FOUND);
	}

	/// ----------------------Adding a new employee record
	@PostMapping(value = "")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws EException {
		return new ResponseEntity<String>(
				env.getProperty("API.ADD_SUCCESS") + service.registerNewEmployee(employeeDTO) + ".",
				HttpStatus.CREATED);
	}

}
