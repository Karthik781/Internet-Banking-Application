package com.iba.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.entity.AccountEntity;
import com.iba.entity.TransactionEntity;
import com.iba.exception.TransactionNotFoundException;
import com.iba.pojo.AccountPojo;
import com.iba.pojo.TransactionPojo;
import com.iba.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;


	@Override
	public TransactionPojo createTransaction(TransactionPojo transaction) {
		
		TransactionEntity transactionEntity = new TransactionEntity();
		
		AccountPojo accountPojo = transaction.getAccount();
		
		AccountEntity accountEntity = new AccountEntity();
		
		BeanUtils.copyProperties(accountPojo, accountEntity);
		
		BeanUtils.copyProperties(transaction, transactionEntity);
		
		transactionEntity.setAccount(accountEntity);
		
		TransactionEntity newEntity = transactionRepository.save(transactionEntity);
		
		BeanUtils.copyProperties(newEntity, transaction);
		
		return transaction;
	}

	@Override
	public TransactionPojo viewTransaction(long transactionId) {

		TransactionEntity transactionEntity = transactionRepository.getById(transactionId);
		
		TransactionPojo transactionPojo = new TransactionPojo();
		
		BeanUtils.copyProperties(transactionEntity, transactionPojo);
		
		return transactionPojo;
			
			
	}

	@Override
	public TransactionPojo findTransactionById(long transactionId) {
		
		TransactionEntity transactionEntity = transactionRepository.getById(transactionId);
		
		TransactionPojo transactionPojo = new TransactionPojo();
		
		BeanUtils.copyProperties(transactionEntity, transactionPojo);
		
		return transactionPojo;
	}

	@Override
	public List<TransactionPojo> listAllTransactions() {
				
		List<TransactionEntity> transactionEntities = transactionRepository.findAll();
		
		if(transactionEntities.isEmpty()) {
			throw new TransactionNotFoundException("No transactions found!");
		}
		
		List<TransactionPojo> transactionPojos = new ArrayList<TransactionPojo>();
		
		for(TransactionEntity transactionEntity : transactionEntities) {
			TransactionPojo transactionPojo = new TransactionPojo();
			
			BeanUtils.copyProperties(transactionEntity, transactionPojo);
			
			transactionPojos.add(transactionPojo);
		}
		return transactionPojos;
	}

	@Override
	public List<TransactionPojo> getAllMyaccTransactions(long accountId) {
		List<TransactionEntity> transactionEntities = transactionRepository.findTransactionsByAccount(accountId);
		
		if(transactionEntities.isEmpty()) {
			throw new TransactionNotFoundException("No transactions found!");
		}
		
		List<TransactionPojo> transactionPojos = new ArrayList<TransactionPojo>();
		
		for(TransactionEntity transactionEntity : transactionEntities) {
			TransactionPojo transactionPojo = new TransactionPojo();
			
			BeanUtils.copyProperties(transactionEntity, transactionPojo);
			
			transactionPojos.add(transactionPojo);
		}
		return transactionPojos;
	}

	

	
}
