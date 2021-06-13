package com.iba.pojo;

import java.util.List;


public class TermAccountPojo extends AccountPojo {

	private double amount;

	private int months;

	private double penaltyAmount;

	public TermAccountPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TermAccountPojo(long accountId, double interestRate, double balance, String dateOfJoining, long customer,
			List<BeneficiaryPojo> beneficiaries, List<TransactionPojo> transactions, List<NomineePojo> nominees,
			double amount, int months, double penaltyAmount) {
			super(accountId, interestRate, balance, dateOfJoining, customer, beneficiaries, transactions, nominees);
			this.amount = amount;
			this.months = months;
			this.penaltyAmount = penaltyAmount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public double getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}


	
	
}
