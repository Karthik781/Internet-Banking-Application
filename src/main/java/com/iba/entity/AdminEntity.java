package com.iba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(referencedColumnName="user_id")
public class AdminEntity extends UserEntity{

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE )
//	@Column(name ="admin_id")
//	private long adminId;
	
	@Column(name ="admin_name")
	private String adminName;
	@Column(name ="admin_contact")
	private String adminContact;
	@Column(name ="admin_email_id")
	private String adminEmailId;
	
	
	public AdminEntity(String password, String type, String adminName, String adminContact,
			String adminEmailId) {
		super( password, type);
	//	this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.adminEmailId = adminEmailId;
	}


	public AdminEntity() {
		super();
	}


//	public long getAdminId() {
//		return adminId;
//	}
//
//
//	public void setAdminId(long adminId) {
//		this.adminId = adminId;
//	}


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