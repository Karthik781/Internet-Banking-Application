package com.iba.pojo;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.iba.entity.AccountEntity;

public class CustomerPojo extends UserPojo {


	private long customerId;
	
	@NotBlank(message="Name cannot be blank")
	private String customerName;

	@NotNull(message="number can not be null")
	@Size(min=10, max=10)
	@Pattern(regexp="^[6-9]\\d{9}$")
	private String phoneNo;
	
	@NotNull(message ="MailId must be valid ")
	@Email
	private String emailId;

	private int age;

	private String gender;

	private List<AccountEntity> accounts = new ArrayList<AccountEntity>();

	public CustomerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerPojo(long userId, String password, String type, long customerId,
			@NotBlank(message = "Name cannot be blank") String customerName,
			@NotNull(message = "number can not be null") @Size(min = 10, max = 10) @Pattern(regexp = "^[6-9]\\d{9}$") String phoneNo,
			@NotNull(message = "MailId must be valid ") @Email String emailId, int age, String gender,
			List<AccountEntity> accounts) {
		super(userId, password, type);
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.age = age;
		this.gender = gender;
		this.accounts = accounts;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<AccountEntity> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	
	
	
	
	
	
}
