package com.enigma.bootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enigma.bootcamp.helper.response.CommonResponse;

@ControllerAdvice
public class UserExceptionHandler {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=UserException.class)
	public ResponseEntity<CommonResponse> resp(UserException e) {
		return new ResponseEntity<CommonResponse>(new CommonResponse(e.getCode(), e.getDescription()), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=EntityNotFoundException.class)
	public ResponseEntity<CommonResponse> catchEntityNotFound(EntityNotFoundException e) {
		return new ResponseEntity<CommonResponse>(new CommonResponse(e.getCode(), e.getDescription()), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<CommonResponse> catchEntityNotFound(Exception e) {
		return new ResponseEntity<CommonResponse>(new CommonResponse(50 , e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value=HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<CommonResponse> catchEntityNotFound(HttpRequestMethodNotSupportedException e) {
		return new ResponseEntity<CommonResponse>(new CommonResponse(45, e.getMessage()), HttpStatus.OK);
	}
}
