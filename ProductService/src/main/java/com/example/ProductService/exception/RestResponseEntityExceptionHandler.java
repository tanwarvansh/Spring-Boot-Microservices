package com.example.ProductService.exception;

import com.example.ProductService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleException(ProductServiceCustomException exception){
		return new ResponseEntity<>(new ErrorResponse().builder()
				.errorCode(exception.getErrorCode())
				.errorMessage(exception.getMessage())
				.build(),HttpStatus.NOT_FOUND);
	}
	
}