package com.infy.etService.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.etService.exception.ETException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@Autowired
	private Environment env;

	private HttpStatus errorStatus;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<ErrorInfo>(
				new ErrorInfo(errorStatus.value(), env.getProperty("General.EXCEPTION_MESSAGE"), LocalDateTime.now()),
				errorStatus);
	}

	@ExceptionHandler(ETException.class)
	public ResponseEntity<ErrorInfo> employeeExceptionHandler(ETException exception) {
		errorStatus = HttpStatus.NOT_FOUND;
		return new ResponseEntity<ErrorInfo>(
				new ErrorInfo(errorStatus.value(), env.getProperty(exception.getMessage()), LocalDateTime.now()),
				errorStatus);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {
		errorStatus = HttpStatus.BAD_REQUEST;
		String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(", "));
		return new ResponseEntity<>(new ErrorInfo(errorStatus.value(), errorMsg, LocalDateTime.now()), errorStatus);
	}

}
