package com.iba.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="transaction")
public class TransactionEntity {

		
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE )
		@Column(name = "TRANSACTION_ID" )
		private long  transactionId;
		
		@Column(name = "AMOUNT" )
		private double amount;
		
		@Column(name = "TRANSACTION_TYPE" )
		private String transactionType;
		
		@Column(name = "TRANSACTION_DATE_TIME" )
		private Date  transactionDateTime =  new Date(System.currentTimeMillis());
		

		@Column(name = "TRANSACTION_STATUS" )
		private String transactionStatus;
		
		@Column(name = "TRANSACTION_REMARKS" )
		private String  transactionRemarks;

		@OneToOne
		@JoinColumn(name = "BENEFICIARY_ID", referencedColumnName = "BENEFICIARY_ID")
		private BeneficiaryEntity beneficiary;
		
		@ManyToOne
		@JoinColumn(name = "ACCOUNT_ID" )
		@JsonBackReference
		private AccountEntity account;
		
		public TransactionEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TransactionEntity(double amount, String transactionType, Date transactionDateTime,
				String transactionStatus, String transactionRemarks, BeneficiaryEntity beneficiary,
				AccountEntity account) {
			super();
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

		public AccountEntity getAccount() {
			return account;
		}

		public void setAccount(AccountEntity account) {
			this.account = account;
		}

	

	
		
		
}

		
		
		
	


