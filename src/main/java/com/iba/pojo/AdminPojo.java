package com.iba.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdminPojo extends UserPojo {
	
	
	@NotBlank(message ="name cannot be blank")
	private String adminName;
	
	@NotNull(message="number can not be null")
	@Size(min=10, max=10)
	@Pattern(regexp="^[6-9]\\d{9}$")
	private String adminContact;
	
	@NotNull(message ="MailId must be valid ")
	@Email
	private String adminEmailId;

	public AdminPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminPojo(long userId, String password, String type, String adminName, String adminContact, String adminEmailId) {
		super(userId, password, type);
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.adminEmailId = adminEmailId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	
	
}
