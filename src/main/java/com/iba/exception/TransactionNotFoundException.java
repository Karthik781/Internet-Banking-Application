package com.iba.exception;

public class TransactionNotFoundException  extends RuntimeException {
	String msg;
	public  TransactionNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
