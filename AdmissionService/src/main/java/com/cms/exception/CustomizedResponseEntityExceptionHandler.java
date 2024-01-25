package com.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AdmissionInvalidException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(AdmissionInvalidException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}	

}


