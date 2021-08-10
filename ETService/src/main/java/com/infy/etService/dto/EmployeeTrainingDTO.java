package com.infy.etService.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class EmployeeTrainingDTO {

	private String emailId;

	@NotNull(message = "{course.name.absent}")
	private String courseName;

	@NotNull(message = "{course.code.absent}")
    @Pattern(regexp="[0-9]+", message="{course.code.invalid}")
	private String courseCode;

	@NotNull(message = "{score.absent}")
    @Pattern(regexp="[A-Z](\\+|-)?", message="{score.invalid}")
	private String score;

	@NotNull(message = "{duration.absent}")
	@Min(value = 2L, message = "{duration.invalid}")
	private Integer hoursSpent;
	
	@PastOrPresent(message = "{date.invalid}")
	private LocalDate dateCompleted;
	
	@NotNull(message = "{status.absent}")
	private ETStatus status;

	public EmployeeTrainingDTO() { }

	public EmployeeTrainingDTO(String emailId, String courseName, String courseCode, String score, Integer hoursSpent,
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
