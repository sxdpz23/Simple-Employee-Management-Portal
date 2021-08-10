package com.infy.etService.service;

import java.util.List;

import com.infy.etService.dto.EmployeeTrainingDTO;
import com.infy.etService.exception.ETException;

public interface ETService {

	public String addNewTraineeDetails(EmployeeTrainingDTO employeeDTO) throws ETException;

	public void updateTraineeDetails(EmployeeTrainingDTO employeeDTO) throws ETException;

	public void removeTraineeDetails(String emailId) throws ETException;

	public EmployeeTrainingDTO getTraineeDetails(String emailId) throws ETException;

	public List<EmployeeTrainingDTO> getAllTraineeDetails() throws ETException;

}
