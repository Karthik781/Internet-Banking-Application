package com.iba.service;

import java.util.List;
import java.util.Set;

import com.iba.entity.AccountEntity;
import com.iba.entity.SavingAccountEntity;
import com.iba.pojo.AccountPojo;
import com.iba.pojo.SavingAccountPojo;
import com.iba.pojo.TermAccountPojo;

public interface AccountService {

	
	public AccountPojo TransferMoney(long accountId, long receiverId, double amount, long userId, String password);
    
	public AccountPojo withdraw(long accountId, double amount, long name, String password);
    
	public AccountPojo deposit(long accountId, double amount);    		
	
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
