package com.iba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.AccountEntity;
import com.iba.entity.SavingAccountEntity;
import com.iba.pojo.AccountPojo;
import com.iba.pojo.SavingAccountPojo;
import com.iba.pojo.TermAccountPojo;
import com.iba.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/all")
	public List<AccountPojo> getAllAccounts(){
		return accountService.listAllAccounts();
	}
	

	@PostMapping("/savingsaccount")
    public SavingAccountPojo addSavingsAccount(@RequestBody SavingAccountPojo savingsaccount) {
		return accountService.addSavingsAccount(savingsaccount);
    
	}
	
	
	@PostMapping("/termaccount")
	public TermAccountPojo addTermAccount(@RequestBody TermAccountPojo termaccount ) {
		return accountService.addTermAccount(termaccount);
		
	}
	
	
	@PutMapping("/savingaccount")
	public SavingAccountPojo updateSavingAccount(@RequestBody SavingAccountPojo updatedSavingAccount) {
		return accountService.updateSavingAccount(updatedSavingAccount);
	}
	
	@PutMapping("/termaccount")
	public TermAccountPojo updateTermAccount(@RequestBody TermAccountPojo updatedTermAccount) {
		return accountService.updateTermAccount(updatedTermAccount);
	}
	
	
	@DeleteMapping("/savingaccount/{accountId}")
	public boolean deleteSavingAccount(@PathVariable("accountId") long accountId) {
	return accountService.deleteSavingAccount(accountId);	
	}
	
	
	@DeleteMapping("/termaccount/{accountId}")
	public boolean deleteTermAccount(@PathVariable("accountId") long accountId) {
		return accountService.deleteTermAccount(accountId);
		
	}
	
	@GetMapping("/{accountId}")
	public AccountPojo getAccount(@PathVariable("accountId") long accountId) {
		return accountService.getAccount(accountId);
	}
	
	@GetMapping("/account")
	public List<AccountPojo> getlistAllAccounts() {
		return accountService.listAllAccounts();
	}
	
	@GetMapping("/savingaccount")
	public List<SavingAccountPojo> getlistAllSavingsAccounts() {
		return accountService.listAllSavingsAccounts();
	}
	
	@GetMapping("/termaccount")
	public List<TermAccountPojo> getlistAllTermAccounts(){
		return accountService.listAllTermAccounts();
	}
	
	@PutMapping("/deposit/{accountId}/{amount}")
	public AccountPojo deposit(@PathVariable long accountId, @PathVariable double amount) {
		return accountService.Deposit(accountId, amount);
	}

}
