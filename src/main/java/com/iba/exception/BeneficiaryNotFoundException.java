package com.iba.exception;

public class BeneficiaryNotFoundException extends RuntimeException {

	String msg;
	public  BeneficiaryNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
