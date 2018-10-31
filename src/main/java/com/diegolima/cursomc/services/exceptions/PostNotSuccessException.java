package com.diegolima.cursomc.services.exceptions;

public class PostNotSuccessException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public PostNotSuccessException(String msg) {
		super(msg);
	}
	
	public PostNotSuccessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
