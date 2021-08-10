package com.infy.etService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.etService.entity.EmployeeTraining;

public interface ETRepository extends JpaRepository<EmployeeTraining, String> {

}
