package com.praticajava.pratica.services.exceptions;


//RuntimeException => Exceção para quando deletar algum usuário que ainda tem alguma pedido pendente.
public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super(msg);
	}

}
