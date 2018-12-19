package com.hateoas.app.exceptions.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hateoas.app.exceptions.ResourceNotFoundException;
import com.hateoas.app.models.errors.ErrorDetail;
import com.hateoas.app.models.errors.ErrorResponse;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(
				HttpStatus.NOT_FOUND,
				"4040",
				"Resource not found",
				ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(errorDetail);
		return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
		
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorDetail> errors = new ArrayList<ErrorDetail>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	    	ErrorDetail errorDetail = new ErrorDetail();
	    	errorDetail.setStatus(HttpStatus.BAD_REQUEST);
	    	errorDetail.setCode("4000");
	    	errorDetail.setTitle("Invalid argument");
	    	errorDetail.setDetail(error.getField() + ": " + error.getDefaultMessage());
	        errors.add(errorDetail);
	    }
	    return new ResponseEntity<Object>(errors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"5000",
				"Unexpect server error",
				ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(errorDetail);
		return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

