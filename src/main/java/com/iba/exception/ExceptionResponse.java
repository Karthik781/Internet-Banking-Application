package com.iba.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private String msg;
	private LocalDateTime dateTime;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	

	
}
