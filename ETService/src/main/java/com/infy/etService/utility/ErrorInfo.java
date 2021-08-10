package com.infy.etService.utility;

import java.time.LocalDateTime;

public class ErrorInfo {
	private Integer errorCode;
	private String errorMessage;
	private LocalDateTime timestamp;

	public ErrorInfo() { }

	public ErrorInfo(Integer errorCode, String errorMessage, LocalDateTime timestamp) {
		setErrorCode(errorCode);
		setErrorMessage(errorMessage);
		setTimestamp(timestamp);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ERROR-" + errorCode + " : " + errorMessage + "\n TIME : " + timestamp + "\n";
	}

}
