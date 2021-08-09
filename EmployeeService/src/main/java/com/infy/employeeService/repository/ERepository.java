package com.infy.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.employeeService.entity.Employee;

public interface ERepository extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);

}
