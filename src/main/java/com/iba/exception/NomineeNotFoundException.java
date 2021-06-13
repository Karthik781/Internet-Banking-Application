package com.iba.exception;

public class NomineeNotFoundException extends RuntimeException {
	String msg;
	public  NomineeNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
