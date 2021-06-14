package com.iba.exception;

public class NoBalanceException extends RuntimeException {
	String msg;
	public  NoBalanceException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
