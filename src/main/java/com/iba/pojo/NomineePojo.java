package com.iba.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class NomineePojo {
	
	private long nomineeId;

	@NotEmpty(message ="name should not be Empty")
	private String nomineeName;

	@NotEmpty(message ="ID should not be Empty")
	private String govtId;

	@NotEmpty(message ="Type should not be Empty")
	private String govtIdType;
	
	@NotNull(message="number can not be null")
	@Size(min=10, max=10)
	@Pattern(regexp="^[6-9]\\d{9}$")
	private String phoneNo;


	private String relation;
	

	private List<AccountPojo> accounts = new ArrayList<AccountPojo>();


	public NomineePojo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NomineePojo(long nomineeId, String nomineeName, String govtId, String govtIdType, String phoneNo,
			String relation, List<AccountPojo> accounts) {
		super();
		this.nomineeId = nomineeId;
		this.nomineeName = nomineeName;
		this.govtId = govtId;
		this.govtIdType = govtIdType;
		this.phoneNo = phoneNo;
		this.relation = relation;
		this.accounts = accounts;
	}


	public long getNomineeId() {
		return nomineeId;
	}


	public void setNomineeId(long nomineeId) {
		this.nomineeId = nomineeId;
	}


	public String getNomineeName() {
		return nomineeName;
	}


	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}


	public String getGovtId() {
		return govtId;
	}


	public void setGovtId(String govtId) {
		this.govtId = govtId;
	}


	public String getGovtIdType() {
		return govtIdType;
	}


	public void setGovtIdType(String govtIdType) {
		this.govtIdType = govtIdType;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
	}


	public List<AccountPojo> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<AccountPojo> accounts) {
		this.accounts = accounts;
	}
	
	
}
