package com.infy.employeeService.integrations;

import java.util.List;

import com.infy.employeeService.dto.EmployeeTrainingDTO;

public interface ServiceIntegration {
	
	List<EmployeeTrainingDTO> getAllTraineesDetails();
	
	EmployeeTrainingDTO getTraineeDetails(String emailId);
	
	void updateTraineeDetails(EmployeeTrainingDTO traineeDTO);
	
	void deleteTraineeDetails(String emailId);
	
	void addTraineeDetails(EmployeeTrainingDTO traineeDTO);

}
