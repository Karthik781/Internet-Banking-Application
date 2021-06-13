package com.iba.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(referencedColumnName="user_id")
public class CustomerEntity extends UserEntity{
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	@Column(name ="customer_id")
    private long customerId;
	
	@Column(name ="customer_name")
    private String customerName;
	
	@Column(name ="customer_phone")
    private String phoneNo;
	@Column(name ="customer_email_id")
    private String emailId;
	@Column(name ="customer_age")
    private int age;
	@Column(name ="customer_gender")
    private String gender;
	
	@OneToMany
	@JoinColumn(name="customer_id", referencedColumnName="customer_id")
	private List<AccountEntity> accounts = new ArrayList<AccountEntity>();

	
	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String password, String type, String customerName, String phoneNo, String emailId, int age,
			String gender, List<AccountEntity> accounts) {
		super(password, type);
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