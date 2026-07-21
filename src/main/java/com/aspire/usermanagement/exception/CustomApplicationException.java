package com.aspire.usermanagement.exception;

public class CustomApplicationException extends RuntimeException {
	public CustomApplicationException() {
		super();
	}
	public CustomApplicationException(String message) {
		super(message);
	}
	public CustomApplicationException(String message, Throwable cause) {
		super(message,cause);
		
	}
	

}
