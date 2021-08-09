package com.infy.employeeService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "e_service")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeeId;
	private String name;
	private String location;

	@Column(name = "phone_one")
	private String phone1;

	@Column(name = "phone_two")
	private String phone2;
	private String email;

	public Employee() {	}

	public Employee(Integer employeeId, String name, String location, String phone1, String phone2, String email) {
		setEmployeeId(employeeId);
		setName(name);
		setLocation(location);
		setPhone1(phone1);
		setPhone2(phone2);
		setEmail(email);
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee Details \n==================================== \nId: " + employeeId + " \nName: " + name
				+ " \nLocation: " + location + " \nPrimary Phone: " + phone1 + " \nSecondary Phone: " + phone2
				+ " \nEmail: " + email + " \n";
	}
	
}
