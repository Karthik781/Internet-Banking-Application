package com.iba.pojo;

import javax.validation.constraints.NotBlank;

public class UserPojo {

	private long userId;
	
	@NotBlank(message = "password cannot be blank!")
	private String password;

	private String type;
	
	
	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserPojo(long userId, String password, String type) {
		super();
		this.userId = userId;
		this.password = password;
		this.type = type;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	
}
