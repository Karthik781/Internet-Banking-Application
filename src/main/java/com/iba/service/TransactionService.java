package com.iba.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.iba.entity.TransactionEntity;
import com.iba.pojo.TransactionPojo;

public interface TransactionService {

	public TransactionPojo createTransaction(TransactionPojo Transaction);
	public TransactionPojo viewTransaction(long transactionId);
	public TransactionPojo  findTransactionById(long TransactionId);
    public List<TransactionPojo> listAllTransactions();
	public List<TransactionPojo> getAllMyaccTransactions(long accountId);
	
}
