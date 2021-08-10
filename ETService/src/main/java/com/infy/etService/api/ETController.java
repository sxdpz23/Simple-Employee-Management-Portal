package com.infy.etService.api;

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

import com.infy.etService.dto.EmployeeTrainingDTO;
import com.infy.etService.exception.ETException;
import com.infy.etService.service.ETService;

@CrossOrigin
@RestController
@RequestMapping(value = "/trainees")
@Validated
public class ETController {

	@Autowired
	private ETService service;

	@Autowired
	private Environment env;

	/// ----------------------Fetching all trainee details
	@GetMapping(value = "")
	public ResponseEntity<List<EmployeeTrainingDTO>> getAllTraineesDetails() throws ETException {
		return new ResponseEntity<List<EmployeeTrainingDTO>>(service.getAllTraineeDetails(), HttpStatus.OK);
	}

	/// ----------------------Fetching only the trainee details whose email matches
	@GetMapping(value = "/{emailId}")
	public ResponseEntity<EmployeeTrainingDTO> getTraineeDetails(@PathVariable("emailId") String emailId)
			throws ETException {
		return new ResponseEntity<EmployeeTrainingDTO>(service.getTraineeDetails(emailId), HttpStatus.OK);
	}

	/// ----------------------Changing the details of trainee whose email matches
	@PutMapping(value = "")
	public ResponseEntity<String> updateTraineeDetails(@Valid @RequestBody EmployeeTrainingDTO traineeDTO)
			throws ETException {
		service.updateTraineeDetails(traineeDTO);
		return new ResponseEntity<String>(env.getProperty("API.UPDATE_SUCCESS"), HttpStatus.ACCEPTED);
	}

	/// ----------------------Removing an trainee details record completely
	@DeleteMapping(value = "/{emailId}")
	public ResponseEntity<String> deleteTraineeDetails(@PathVariable("emailId") String emailId) throws ETException {
		service.removeTraineeDetails(emailId);
		return new ResponseEntity<String>(env.getProperty("API.DELETE_SUCCESS"), HttpStatus.FOUND);
	}

	/// ----------------------Adding a new trainee's details
	@PostMapping(value = "")
	public ResponseEntity<String> addTraineeDetails(@Valid @RequestBody EmployeeTrainingDTO traineeDTO)
			throws ETException {
		return new ResponseEntity<String>(
				env.getProperty("API.ADD_SUCCESS") + service.addNewTraineeDetails(traineeDTO) + ".",
				HttpStatus.CREATED);
	}

}
