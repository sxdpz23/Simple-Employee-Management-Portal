package com.infy.employeeService.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDTO {

	private Integer employeeId;
	
	@NotNull(message = "{name.absent}")
    @Pattern(regexp="([A-Z][a-z]+)( [A-Z][a-z]+){0,2}", message="{name.format.invalid}")
	private String name;
	
	@NotNull(message = "{location.absent}")
	@Pattern(regexp="[A-Za-z]+", message="{location.format.invalid}")
	private String location;
	
	@NotNull(message = "{phoneone.absent}")
	@Pattern(regexp="(9|8|7|6)[0-9]{9}", message="{phone.format.invalid}")
	private String phone1;
	
	@NotNull(message = "{phonetwo.absent}")
	@Pattern(regexp="(9|8|7|6)[0-9]{9}", message="{phone.format.invalid}")
	private String phone2;

	@NotNull(message = "{email.absent}")
	@Pattern(regexp="[a-z]{3,}(\\.[a-z]{3,})?([0-9]{2})?@(ad\\.)?infosys\\.com", message="{email.format.invalid}")
    @Email(message = "{email.invalid}")
	private String email;

	public EmployeeDTO() { }

	public EmployeeDTO(Integer employeeId, String name, String location, String phone1, String phone2, String email) {
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
