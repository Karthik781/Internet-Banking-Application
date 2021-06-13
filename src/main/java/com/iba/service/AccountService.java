package com.iba.service;

import java.util.List;
import java.util.Set;

import com.iba.entity.AccountEntity;
import com.iba.entity.SavingAccountEntity;
import com.iba.pojo.AccountPojo;
import com.iba.pojo.SavingAccountPojo;
import com.iba.pojo.TermAccountPojo;

public interface AccountService {

	
	public AccountPojo TransferMoney(AccountPojo transfermoney);
    
	public AccountPojo Withdraw(long accountId, double amount);
    
	public AccountPojo Deposit(long accountId, double amount);    		
	
	public SavingAccountPojo addSavingsAccount(SavingAccountPojo savingaccount);
	
	public TermAccountPojo addTermAccount(TermAccountPojo termaccount );
	
	public SavingAccountPojo updateSavingAccount(SavingAccountPojo updatedSavingAccount);
	
	public TermAccountPojo updateTermAccount(TermAccountPojo updatedTermAccount);
	
	public boolean deleteSavingAccount(long accountId);			
	
	public boolean deleteTermAccount(long accountId);
	
	public AccountPojo getAccount(long accountId);
	
	public List<AccountPojo> listAllAccounts() ;
	
	public List<SavingAccountPojo> listAllSavingsAccounts();
	
	public List<TermAccountPojo> listAllTermAccounts();
	
}
