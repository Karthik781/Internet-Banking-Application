package com.iba.exception;

public class AuthenticationFailedException extends RuntimeException {
	String msg;
	public  AuthenticationFailedException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
