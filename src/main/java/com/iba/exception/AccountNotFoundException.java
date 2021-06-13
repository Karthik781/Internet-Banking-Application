package com.iba.exception;

public class AccountNotFoundException extends RuntimeException {


	String msg;
	public  AccountNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
