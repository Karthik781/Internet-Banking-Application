package com.iba.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iba.repository.CustomerRepository;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type", 
discriminatorType = DiscriminatorType.INTEGER)
public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	@Column(name = "ACCOUNT_ID")
	private long accountId;

	@Column(name = "INTEREST_RATE")
	private double interestRate;
	
	@Column(name = "BALANCE")
	private double balance;
	
	@Column(name = "DATE_OF_OPENING")
	private String dateOfJoining;
	
	
	@Column(name = "customer_id")
	private long customer;
	
//	@Column(name = "DATE_OF_OPENING")
//	@JsonFormat(pattern="yyyy-MM-dd")
//	private Date dateOfJoining;
	
	
//	private CustomerEntity customer;
	
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<BeneficiaryEntity> beneficiaries = new ArrayList<BeneficiaryEntity>();

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TransactionEntity> transactions = new ArrayList<TransactionEntity>();

	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
	  name = "account_nominee", 
	  joinColumns = @JoinColumn(name = "account_id"), 
	  inverseJoinColumns = @JoinColumn(name = "nominee_id"))
	@JsonIgnoreProperties("accounts")
	private List<NomineeEntity> nominees = new ArrayList<NomineeEntity>();
	

	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountEntity(double interestRate, double balance, String dateOfJoining, long customer,
			List<BeneficiaryEntity> beneficiaries, List<TransactionEntity> transactions, List<NomineeEntity> nominees) {
		super();
		this.interestRate = interestRate;
		this.balance = balance;
		this.dateOfJoining = dateOfJoining;
		this.customer = customer;
		this.beneficiaries = beneficiaries;
		this.transactions = transactions;
		this.nominees = nominees;
	}
	
//	public void addTransaction(TransactionEntity transaction) {
//		
//		if (transactions.contains(transaction))
//		      return ;
//		
//		
//			transactions.add(transaction);
//			transaction.setAccount(this);
//	}
//
//	public void removeTransaction(TransactionEntity transaction) {
//		
//		if (!transactions.contains(transaction))
//		      return ;
//		
//		transaction.setAccount(null);
//	   this.transactions.remove(transaction);
//	}


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


	public List<BeneficiaryEntity> getBeneficiaries() {
		return beneficiaries;
	}



	public void setBeneficiaries(List<BeneficiaryEntity> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}


	public List<TransactionEntity> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<TransactionEntity> transactions) {
		this.transactions = transactions;
	}


	public List<NomineeEntity> getNominees() {
		return nominees;
	}


	public void setNominees(List<NomineeEntity> nominees) {
		this.nominees = nominees;
	}


	
	
	
	
}
