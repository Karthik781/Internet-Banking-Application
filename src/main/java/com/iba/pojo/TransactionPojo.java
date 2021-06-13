package com.iba.pojo;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.iba.entity.BeneficiaryEntity;


public class TransactionPojo {

	private long transactionId;
	
	private double amount;
	
	@NotBlank(message ="transactionType cannot be blank")
	private String transactionType;

	private Date transactionDateTime;
	
	@NotBlank(message ="transactionStatus cannot be blank")
	private String transactionStatus;

	private String transactionRemarks;

	private BeneficiaryEntity beneficiary;

	private AccountPojo account;

	public TransactionPojo() {
		super();
		
	}

	public TransactionPojo(long transactionId, double amount, String transactionType, Date transactionDateTime,
			String transactionStatus, String transactionRemarks, BeneficiaryEntity beneficiary, AccountPojo account) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionDateTime = transactionDateTime;
		this.transactionStatus = transactionStatus;
		this.transactionRemarks = transactionRemarks;
		this.beneficiary = beneficiary;
		this.account = account;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	public BeneficiaryEntity getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryEntity beneficiary) {
		this.beneficiary = beneficiary;
	}

	public AccountPojo getAccount() {
		return account;
	}

	public void setAccount(AccountPojo account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "TransactionPojo [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
				+ transactionType + ", transactionDateTime=" + transactionDateTime + ", transactionStatus="
				+ transactionStatus + ", transactionRemarks=" + transactionRemarks + ", beneficiary=" + beneficiary
				+ ", account=" + account + "]";
	}

	
}
