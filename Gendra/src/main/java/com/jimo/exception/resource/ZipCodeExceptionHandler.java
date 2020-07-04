package com.jimo.exception.resource;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ZipCodeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> resourceNotFoundHandling(ZipCodeNotFoundException exception, WebRequest request) {
		ExceptionsDetails errorDetails = new ExceptionsDetails(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
