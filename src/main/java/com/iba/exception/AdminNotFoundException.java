package com.iba.exception;

public class AdminNotFoundException extends RuntimeException{
	
	String msg;
	public  AdminNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
