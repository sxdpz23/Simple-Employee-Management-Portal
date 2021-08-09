package com.infy.employeeService.service;

import java.util.List;

import com.infy.employeeService.dto.EmployeeDTO;
import com.infy.employeeService.exception.EException;

public interface EService {

	public Integer registerNewEmployee(EmployeeDTO employeeDTO) throws EException;

	public void updateProfile(EmployeeDTO employeeDTO) throws EException;

	public void removeEmployee(Integer employeeId) throws EException;

	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws EException;

	public List<EmployeeDTO> getAllEmployees() throws EException;

}
