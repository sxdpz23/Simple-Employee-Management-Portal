package com.infy.etService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.etService.dto.EmployeeTrainingDTO;
import com.infy.etService.entity.EmployeeTraining;
import com.infy.etService.exception.ETException;
import com.infy.etService.repository.ETRepository;

@Service(value = "etService")
@Transactional
public class ETServiceImpl implements ETService {

	@Autowired
	private ETRepository repo;

	@Override
	public String addNewTraineeDetails(EmployeeTrainingDTO traineeDTO) throws ETException {
		Optional<EmployeeTraining> optionalTrainee = repo.findById(traineeDTO.getEmailId());
		EmployeeTraining trainee = optionalTrainee.orElse(null);
		if (trainee == null) {
			trainee = repo.save(new EmployeeTraining(traineeDTO.getEmailId(), traineeDTO.getCourseName(),
					traineeDTO.getCourseCode(), traineeDTO.getScore(), traineeDTO.getHoursSpent(),
					traineeDTO.getDateCompleted(), traineeDTO.getStatus()));
			return trainee.getEmailId();
		}
		throw new ETException("Service.ALREADY_ADDED");
	}

	@Override
	public void updateTraineeDetails(EmployeeTrainingDTO traineeDTO) throws ETException {
		Optional<EmployeeTraining> optionalTrainee = repo.findById(traineeDTO.getEmailId());
		EmployeeTraining trainee = optionalTrainee.orElseThrow(() -> new ETException("Service.NO_SUCH_TD"));
		trainee.setCourseName(traineeDTO.getCourseName());
		trainee.setCourseCode(traineeDTO.getCourseCode());
		trainee.setHoursSpent(traineeDTO.getHoursSpent());
		trainee.setDateCompleted(traineeDTO.getDateCompleted());
		trainee.setScore(traineeDTO.getScore());
		trainee.setStatus(traineeDTO.getStatus());
	}

	@Override
	public void removeTraineeDetails(String emailId) throws ETException {
		Optional<EmployeeTraining> optionalTrainee = repo.findById(emailId);
		EmployeeTraining trainee = optionalTrainee.orElseThrow(() -> new ETException("Service.NO_SUCH_TD"));
		repo.delete(trainee);
	}

	@Override
	public EmployeeTrainingDTO getTraineeDetails(String emailId) throws ETException {
		Optional<EmployeeTraining> optionalTrainee = repo.findById(emailId);
		EmployeeTraining trainee = optionalTrainee.orElseThrow(() -> new ETException("Service.NO_SUCH_TD"));
		return new EmployeeTrainingDTO(trainee.getEmailId(), trainee.getCourseName(), trainee.getCourseCode(),
				trainee.getScore(), trainee.getHoursSpent(), trainee.getDateCompleted(), trainee.getStatus());
	}

	@Override
	public List<EmployeeTrainingDTO> getAllTraineeDetails() throws ETException {
		List<EmployeeTraining> employees = repo.findAll();
		if (employees.isEmpty())
			throw new ETException("Service.NO_TDS");
		else {
			List<EmployeeTrainingDTO> result = new ArrayList<EmployeeTrainingDTO>();
			employees.stream()
					.forEach(trainee -> result.add(new EmployeeTrainingDTO(trainee.getEmailId(),
							trainee.getCourseName(), trainee.getCourseCode(), trainee.getScore(),
							trainee.getHoursSpent(), trainee.getDateCompleted(), trainee.getStatus())));
			return result;
		}
	}

}
