package com.iba.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class TermAccountEntity extends AccountEntity {
	
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "MONTHS")
	private int months;

	@Column(name = "PENALTY_AMOUNT")
	private double penaltyAmount;

	public TermAccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TermAccountEntity(double interestRate, double balance, String dateOfJoining, long customer,
			List<BeneficiaryEntity> beneficiaries, List<TransactionEntity> transactions, List<NomineeEntity> nominees, double amount, int months, double penaltyAmount) {
		super(interestRate, balance, dateOfJoining, customer, beneficiaries, transactions, nominees);
		this.amount = amount;
		this.months = months;
		this.penaltyAmount = penaltyAmount;
	}

//	public TermAccountEntity(long customerId, double interestRate, double balance, String dateOfJoining, double amount, int months,double penaltyAmount ) {
//		super(interestRate, balance, dateOfJoining);
//		this.amount = amount;
//		this.months = months;
//		this.penaltyAmount = penaltyAmount;
//	}
	
	

	
	
	
}
