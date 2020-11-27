package com.praticajava.pratica.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.praticajava.pratica.services.exceptions.DatabaseException;
import com.praticajava.pratica.services.exceptions.ResourceNotFoundException;

//Classe que vamos dar o tratamento manual dos erros.
//@ControllerAdvice => Vai interceptar as exceções quando acontecerem, 
//para que essa classe possa fazer um possível tratamento.

@ControllerAdvice
public class ResourceExceptionHandler {
	
	//@ExceptionHandler => Interceptar exceção do tipo  (ResourceNotFoundException.class)
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resouce not found.";
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);	
	}	
	
	
	
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		
		String error = "Database ERROR.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

		
		return ResponseEntity.status(status).body(err);	
	}	
}
