package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		return new ResponseEntity<Object>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	@ExceptionHandler(RecordeNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(Exception ex, WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		return new ResponseEntity<Object>("Record Not Found Exception ", HttpStatus.NOT_FOUND);
	}
}