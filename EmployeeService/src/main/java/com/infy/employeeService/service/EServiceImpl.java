package com.infy.employeeService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.employeeService.dto.EmployeeDTO;
import com.infy.employeeService.entity.Employee;
import com.infy.employeeService.exception.EException;
import com.infy.employeeService.repository.ERepository;

@Service(value = "eService")
@Transactional
public class EServiceImpl implements EService {

	@Autowired
	private ERepository repo;

	@Override
	public Integer registerNewEmployee(EmployeeDTO employeeDTO) throws EException {
		Employee employee = repo.findByEmail(employeeDTO.getEmail());
		if (employee == null) {
			employee = repo.save(new Employee(null, employeeDTO.getName(), employeeDTO.getLocation(),
					employeeDTO.getPhone1(), employeeDTO.getPhone2(), employeeDTO.getEmail()));
			return employee.getEmployeeId();
		}
		throw new EException("Service.ALREADY_REGISTERED");
	}

	@Override
	public void updateProfile(EmployeeDTO employeeDTO) throws EException {
		Optional<Employee> optionalEmployee = repo.findById(employeeDTO.getEmployeeId());
		Employee employee = optionalEmployee.orElseThrow(() -> new EException("Service.NO_SUCH_EMP"));
		employee.setName(employeeDTO.getName());
		employee.setLocation(employeeDTO.getLocation());
		employee.setPhone1(employeeDTO.getPhone1());
		employee.setPhone2(employeeDTO.getPhone2());
		employee.setEmail(employeeDTO.getEmail());
	}

	@Override
	public void removeEmployee(Integer employeeId) throws EException {
		Optional<Employee> optionalEmployee = repo.findById(employeeId);
		Employee employee = optionalEmployee.orElseThrow(() -> new EException("Service.NO_SUCH_EMP"));
		repo.delete(employee);
	}

	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws EException {
		Optional<Employee> optionalEmployee = repo.findById(employeeId);
		Employee employee = optionalEmployee.orElseThrow(() -> new EException("Service.NO_SUCH_EMP"));
		return new EmployeeDTO(employee.getEmployeeId(), employee.getName(), employee.getLocation(),
				employee.getPhone1(), employee.getPhone2(), employee.getEmail());
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() throws EException {
		List<Employee> employees = repo.findAll();
		if (employees.isEmpty())
			throw new EException("Service.NO_EMP");
		else {
			List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
			employees.stream()
					.forEach(employee -> result.add(new EmployeeDTO(employee.getEmployeeId(), employee.getName(),
							employee.getLocation(), employee.getPhone1(), employee.getPhone2(), employee.getEmail())));
			return result;
		}
	}

}
