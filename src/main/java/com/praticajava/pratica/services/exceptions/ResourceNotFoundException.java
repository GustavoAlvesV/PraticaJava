package com.praticajava.pratica.services.exceptions;


//RuntimeException => Exceção que o compilador não te obriga a tratar.
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resouce not found. Id: " + id);
	}
	
	
	

}
