package com.infy.employeeService.integrations;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.infy.employeeService.dto.EmployeeTrainingDTO;

@Component
@Transactional
public class ServiceIntegrationImpl implements ServiceIntegration {

	@Autowired
	private RestTemplate restTemplate;
	
	private final String rootURL = "http://localhost:3334/et-service/trainees";

	@Override
	public List<EmployeeTrainingDTO> getAllTraineesDetails() {
		EmployeeTrainingDTO[] details = restTemplate.getForObject(rootURL, EmployeeTrainingDTO[].class);
		return Arrays.asList(details);
	}

	@Override
	public EmployeeTrainingDTO getTraineeDetails(String emailId) {
		return restTemplate.getForObject(rootURL+"/"+emailId, EmployeeTrainingDTO.class);
	}

	@Override
	public void updateTraineeDetails(EmployeeTrainingDTO traineeDTO) {
		restTemplate.put(rootURL, traineeDTO);
	}

	@Override
	public void deleteTraineeDetails(String emailId) {
		restTemplate.delete(rootURL+"/"+emailId);
	}

	@Override
	public void addTraineeDetails(EmployeeTrainingDTO traineeDTO) {
		restTemplate.postForObject(rootURL, traineeDTO, String.class);
	}
	
}
