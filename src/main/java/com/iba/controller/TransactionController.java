package com.iba.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iba.entity.TransactionEntity;
import com.iba.pojo.TransactionPojo;
import com.iba.service.TransactionService;

@RestController
@RequestMapping("transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/create")
	public TransactionPojo addTransaction(@Valid @RequestBody TransactionPojo transaction) {
		return transactionService.createTransaction(transaction);

	}

	@GetMapping("/transaction/{transactionId}")
	public TransactionPojo getTransaction(@PathVariable("transactionId") long trasId) {
		return transactionService.viewTransaction(trasId);
	}

	@GetMapping("/{id}")
	public TransactionPojo getTransactionById(@PathVariable("id") long transId) {
		return transactionService.findTransactionById(transId);
	}

	@GetMapping("/all")
	public List<TransactionPojo> listAllTransactions() {
		return transactionService.listAllTransactions();
	}

	@GetMapping("/account/{accountId}")
	public List<TransactionPojo> getAllMyaccTransactions(@PathVariable("accountId") long accountId) {
		return transactionService.getAllMyaccTransactions(accountId);
	}

}
