package com.iba.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="nominee")
public class NomineeEntity {
	@Id
	@Column(name = "NOMINEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long nomineeId;

	@Column(name = "NAME")
	private String nomineeName;

	@Column(name = "GOVT_ID")
	private String govtId;

	@Column(name = "GOVT_ID_TYPE")
	private String govtIdType;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "RELATION")
	private String relation;
	
	@ManyToMany(mappedBy = "nominees")
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnoreProperties("nominees")
	private List<AccountEntity> accounts = new ArrayList<AccountEntity>();

	public NomineeEntity() {
		super();
	}

	public NomineeEntity(String nomineeName, String govtId, String govtIdType, String phoneNo, String relation,
			List<AccountEntity> accounts) {
		super();
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

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	
	
}
