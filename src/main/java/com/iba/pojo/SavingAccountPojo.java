package com.iba.pojo;

import java.util.List;

public class SavingAccountPojo extends AccountPojo {

	private double minBalance;

	private double fine;

	public SavingAccountPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccountPojo(long accountId, double interestRate, double balance, String dateOfJoining, long customer,
			List<BeneficiaryPojo> beneficiaries, List<TransactionPojo> transactions, List<NomineePojo> nominees,
			double minBalance, double fine) {
			super(accountId, interestRate, balance, dateOfJoining, customer, beneficiaries, transactions, nominees);
			this.minBalance = minBalance;
			this.fine = fine;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}
	
}
