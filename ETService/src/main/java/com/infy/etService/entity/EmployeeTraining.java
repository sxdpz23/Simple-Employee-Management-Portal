package com.infy.etService.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.etService.dto.ETStatus;

@Entity
@Table(name = "et_service")
public class EmployeeTraining {

	@Id
	private String emailId;
	private String courseName;
	private String courseCode;
	private String score;
	private Integer hoursSpent;
	private LocalDate dateCompleted;

	@Enumerated(EnumType.STRING)
	private ETStatus status;

	public EmployeeTraining() {	}

	public EmployeeTraining(String emailId, String courseName, String courseCode, String score, Integer hoursSpent,
			LocalDate dateCompleted, ETStatus status) {
		setEmailId(emailId);
		setCourseName(courseName);
		setCourseCode(courseCode);
		setScore(score);
		setHoursSpent(hoursSpent);
		setDateCompleted(dateCompleted);
		setStatus(status);
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Integer getHoursSpent() {
		return hoursSpent;
	}

	public void setHoursSpent(Integer hoursSpent) {
		this.hoursSpent = hoursSpent;
	}

	public LocalDate getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public ETStatus getStatus() {
		return status;
	}

	public void setStatus(ETStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Training Details : \n----------------------\nEmail : " + emailId + " \nCourse Name: " + courseName
				+ " \nCourse Code: " + courseCode + " \nScore: " + score + " \nHours Spent: " + hoursSpent
				+ " \nDate Completed: " + dateCompleted + " \nStatus: " + status + " \n";
	}

}
