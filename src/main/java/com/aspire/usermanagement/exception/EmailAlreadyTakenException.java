package com.aspire.usermanagement.exception;

import org.hibernate.boot.internal.Extends;

public class EmailAlreadyTakenException extends RuntimeException{
	public EmailAlreadyTakenException(){
		super();
		}
	public EmailAlreadyTakenException(String message) {
		super(message);
	}
		public EmailAlreadyTakenException(String message,Throwable cause) {
			super(message,cause);
			
	}
}


