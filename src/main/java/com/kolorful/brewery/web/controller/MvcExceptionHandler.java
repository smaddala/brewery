package com.kolorful.brewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<List> validationErrorHandler(MethodArgumentNotValidException e) {
	 
	 
	        List<String> errors = new ArrayList<>();
	 
	        List<FieldError> fieldErrors = e.getBindingResult().getAllErrors().stream()
	                                                                          .map(FieldError.class::cast)
	                                                                           .collect(Collectors.toList());
	 
	        fieldErrors.forEach(fieldError -> {
	 
	                    errors.add( String.format("Bad Request %s : %s : Rejected value : ---> %s"
	                                                                                       ,fieldError.getField()
	                                                                                       ,fieldError.getDefaultMessage()
	                                                                                       ,fieldError.getRejectedValue()));
	         });
	 
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 @ExceptionHandler(BindException.class)
	 public ResponseEntity<List> handleBindException(BindException ex){
		 
		 return new ResponseEntity<>(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
		 
	 }

}
