package com.iba.pojo;

public class TransactionJson {
	
	private long accountId;
	
	private long receiverAccountId;
	
	private double amount;
	
	private long userId;
	
	private String password;

	public TransactionJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionJson(long accountId, long receiverAccountId, double amount, long userId, String password) {
		super();
		this.accountId = accountId;
		this.receiverAccountId = receiverAccountId;
		this.amount = amount;
		this.userId = userId;
		this.password = password;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(long receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TransactionJson [accountId=" + accountId + ", receiverAccountId=" + receiverAccountId + ", amount="
				+ amount + ", userId=" + userId + ", password=" + password + "]";
	}
	
	

	

}
