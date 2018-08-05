package com.bank.customerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.customerservice.response.ErrorResponse;

@RestControllerAdvice
public class ExcptionHandler {

	
	@ExceptionHandler (value = {RestException.class})
	public ResponseEntity<ErrorResponse> handleRestException (RestException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorMessage(exception.getMessage());
		response.setErrorCode(999);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
