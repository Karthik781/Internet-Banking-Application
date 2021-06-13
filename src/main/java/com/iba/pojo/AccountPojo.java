package com.iba.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class AccountPojo {

	private long accountId;
	
	@NotBlank(message ="interest cannot be blank")
	private double interestRate;
	
	@NotBlank(message ="balance cannot be blank")
	private double balance;

	private String dateOfJoining;

	private long customer;

	private List<BeneficiaryPojo> beneficiaries = new ArrayList<BeneficiaryPojo>();

	private List<TransactionPojo> transactions = new ArrayList<TransactionPojo>();

	private List<NomineePojo> nominees = new ArrayList<NomineePojo>();

	public AccountPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountPojo(long accountId, double interestRate, double balance, String dateOfJoining, long customer,
			List<BeneficiaryPojo> beneficiaries, List<TransactionPojo> transactions, List<NomineePojo> nominees) {
		super();
		this.accountId = accountId;
		this.interestRate = interestRate;
		this.balance = balance;
		this.dateOfJoining = dateOfJoining;
		this.customer = customer;
		this.beneficiaries = beneficiaries;
		this.transactions = transactions;
		this.nominees = nominees;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public long getCustomer() {
		return customer;
	}

	public void setCustomer(long customer) {
		this.customer = customer;
	}

	public List<BeneficiaryPojo> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<BeneficiaryPojo> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public List<TransactionPojo> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionPojo> transactions) {
		this.transactions = transactions;
	}

	public List<NomineePojo> getNominees() {
		return nominees;
	}

	public void setNominees(List<NomineePojo> nominees) {
		this.nominees = nominees;
	}

	@Override
	public String toString() {
		return "AccountPojo [accountId=" + accountId + ", interestRate=" + interestRate + ", balance=" + balance
				+ ", dateOfJoining=" + dateOfJoining + ", customer=" + customer + ", beneficiaries=" + beneficiaries
				+ ", transactions=" + transactions + ", nominees=" + nominees + "]";
	}
	
	
		
}
