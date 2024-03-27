package com.example.OrderService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.OrderService.external.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleException(CustomException exception){
		return new ResponseEntity<>(new ErrorResponse().builder()
				.errorCode(exception.getErrorCode())
				.errorMessage(exception.getMessage())
				.build(),HttpStatus.valueOf(exception.getStatus()));
	}
	
}
