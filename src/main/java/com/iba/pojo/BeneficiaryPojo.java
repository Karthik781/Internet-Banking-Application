package com.iba.pojo;

import javax.validation.constraints.NotBlank;

public class BeneficiaryPojo {
	
	private long beneficiaryId;
	
	@NotBlank(message ="name cannot be blank")
	private String beneficiaryName;
	
	@NotBlank(message ="account cannot be blank")
	private long beneficiaryAccountNumber;
	
	@NotBlank(message ="IFSC cannot be blank")
	private String IFSC;

	private String accountType;

	private AccountPojo account;

	public BeneficiaryPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeneficiaryPojo(long beneficiaryId, String beneficiaryName, long beneficiaryAccountNumber, String iFSC,
			String accountType, AccountPojo account) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.IFSC = iFSC;
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
		this.IFSC = iFSC;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public AccountPojo getAccount() {
		return account;
	}

	public void setAccount(AccountPojo account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "BeneficiaryPojo [beneficiaryId=" + beneficiaryId + ", beneficiaryName=" + beneficiaryName
				+ ", beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", IFSC=" + IFSC + ", accountType="
				+ accountType + ", account=" + account + "]";
	}
	
	
	
	
}
