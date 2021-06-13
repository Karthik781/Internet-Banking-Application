package com.iba.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class SavingAccountEntity extends AccountEntity {
	
	@Column(name = "MIN_BALANCE")
	private double minBalance;
	
	@Column(name = "FINE")
	private double fine;

	public SavingAccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccountEntity(double interestRate, double balance, String dateOfJoining, long customer,
			List<BeneficiaryEntity> beneficiaries, List<TransactionEntity> transactions, List<NomineeEntity> nominees, double minBalance, double fine) {
		super(interestRate, balance, dateOfJoining, customer, beneficiaries, transactions, nominees);
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

//	public SavingAccountEntity(long customerId, double interestRate, double balance, String dateOfJoining, double minBalance, double fine) {
//		super(interestRate, balance, dateOfJoining);
//		this.minBalance = minBalance;
//		this.fine = fine;
//	}
	
	
	
	

	
}
