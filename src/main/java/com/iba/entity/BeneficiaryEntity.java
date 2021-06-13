package com.iba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="beneficiary")
public class BeneficiaryEntity {
	@Id
	@Column(name="BENEFICIARY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long beneficiaryId;
	
	@Column(name ="BENEFICIARY_NAME")
	private String beneficiaryName;
	
	@Column(name="BENEFICIARY_ACCOUNT_NO")
	private long beneficiaryAccountNumber;
	
	@Column(name="IFSC")
	private String IFSC;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	@JsonBackReference
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private AccountEntity account;

	public BeneficiaryEntity() {
		super();
	}

	public BeneficiaryEntity(String beneficiaryName, long beneficiaryAccountNumber, String iFSC, String accountType,
			AccountEntity account) {
		super();
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		IFSC = iFSC;
		this.accountType = accountType;
		this.account = account;
	}

	public long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}


	

}
