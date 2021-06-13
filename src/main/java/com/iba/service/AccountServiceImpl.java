package com.iba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iba.entity.AccountEntity;
import com.iba.entity.AdminEntity;
import com.iba.entity.BeneficiaryEntity;
import com.iba.entity.NomineeEntity;
import com.iba.entity.SavingAccountEntity;
import com.iba.entity.TermAccountEntity;
import com.iba.entity.TransactionEntity;
import com.iba.exception.AccountNotFoundException;
import com.iba.pojo.AccountPojo;
import com.iba.pojo.AdminPojo;
import com.iba.pojo.BeneficiaryPojo;
import com.iba.pojo.NomineePojo;
import com.iba.pojo.SavingAccountPojo;
import com.iba.pojo.TermAccountPojo;
import com.iba.pojo.TransactionPojo;
import com.iba.repository.AccountRepository;
import com.iba.repository.SavingAccountRepository;
import com.iba.repository.TermAccountRepository;
import com.iba.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	public AccountRepository accountRepository;

	@Autowired
	public SavingAccountRepository savingAccountRepository;

	@Autowired
	public TermAccountRepository termAccountRepository;

//	@Autowired
	public TransactionRepository transactionRepository;

	public AccountServiceImpl() {

	}

	@Override
	public AccountPojo TransferMoney(AccountPojo transfermoney) {
		return transfermoney;
	}

	@Override
	public AccountPojo Withdraw(long accountId, double amount) {
		return null;
	}

	@Override
	public AccountPojo Deposit(long accountId, double amount) {

		SavingAccountEntity accountEntity = savingAccountRepository.findById(accountId).get();

		SavingAccountPojo accountPojo = new SavingAccountPojo();

		double balance = accountEntity.getBalance();

		accountEntity.setBalance(balance + amount);

		List<BeneficiaryEntity> beneficiaryEntities = accountEntity.getBeneficiaries();
		BeneficiaryEntity beneficiaryEntity = beneficiaryEntities.get(0);

		TransactionEntity transactionEntity = new TransactionEntity();

		List<TransactionEntity> transactionEntities = new ArrayList<TransactionEntity>();

		transactionEntity.setAccount(accountEntity);
		transactionEntity.setAmount(amount);
		transactionEntity.setTransactionType("deposit");
		transactionEntity.setTransactionStatus("success!");
		transactionEntity.setBeneficiary(beneficiaryEntity);
//		BeanUtils.copyProperties(beneficiaryEntity, beneficiaryPojo);
//		System.out.println(beneficiaryPojo);

		transactionEntities.add(transactionEntity);
//		System.out.println(transactionEntities);
		
		TransactionPojo transactionPojo = new TransactionPojo();
		BeanUtils.copyProperties(transactionEntity, transactionPojo);
		
		accountEntity.setTransactions(transactionEntities);


		accountEntity = accountRepository.saveAndFlush(accountEntity);

		BeanUtils.copyProperties(accountEntity, accountPojo);
		
		List<TransactionEntity> allTransactionEntities = accountEntity.getTransactions();
		List<TransactionPojo> allTransactionPojos = new ArrayList<TransactionPojo>();
		for (TransactionEntity tEntity : allTransactionEntities) {
			TransactionPojo tPojo = new TransactionPojo();
			BeanUtils.copyProperties(tEntity, tPojo);
			tPojo.setBeneficiary(null);

			allTransactionPojos.add(tPojo);
		}

		accountPojo.setTransactions(allTransactionPojos);
		

		return accountPojo;
	}

	@Override
	public SavingAccountPojo addSavingsAccount(SavingAccountPojo savingaccount) {

		List<NomineePojo> nomineePojos = savingaccount.getNominees();

		List<NomineeEntity> nomineeEntities = new ArrayList<NomineeEntity>();

		SavingAccountEntity accountEntity = new SavingAccountEntity();

		BeanUtils.copyProperties(savingaccount, accountEntity);

		for (NomineePojo nomineePojo : nomineePojos) {
			NomineeEntity nomineeEntity = new NomineeEntity();
			BeanUtils.copyProperties(nomineePojo, nomineeEntity);
			nomineeEntities.add(nomineeEntity);
		}

		accountEntity.setNominees(nomineeEntities);

		SavingAccountEntity newAccountEntity = savingAccountRepository.saveAndFlush(accountEntity);

		BeanUtils.copyProperties(newAccountEntity, savingaccount);

		List<NomineeEntity> newNomineeEntities = newAccountEntity.getNominees();

		List<NomineePojo> newNomineePojos = new ArrayList<NomineePojo>();

		for (NomineeEntity newNomineeEntity : newNomineeEntities) {
			NomineePojo newNomineePojo = new NomineePojo();
			BeanUtils.copyProperties(newNomineeEntity, newNomineePojo);

			newNomineePojos.add(newNomineePojo);
		}
		savingaccount.setNominees(newNomineePojos);

		return savingaccount;

	}

	@Override
	public TermAccountPojo addTermAccount(TermAccountPojo termaccount) {
//		TermAccountEntity entity = new TermAccountEntity();
//
//		BeanUtils.copyProperties(termaccount, entity);
//
//		TermAccountEntity e = termAccountRepository.save(entity);
//
//		BeanUtils.copyProperties(e, termaccount);
//
//		return termaccount;

		List<NomineePojo> nomineePojos = termaccount.getNominees();

		List<NomineeEntity> nomineeEntities = new ArrayList<NomineeEntity>();

		TermAccountEntity accountEntity = new TermAccountEntity();

		BeanUtils.copyProperties(termaccount, accountEntity);

		for (NomineePojo nomineePojo : nomineePojos) {
			NomineeEntity nomineeEntity = new NomineeEntity();
			BeanUtils.copyProperties(nomineePojo, nomineeEntity);
			nomineeEntities.add(nomineeEntity);
		}

		accountEntity.setNominees(nomineeEntities);

		TermAccountEntity newAccountEntity = termAccountRepository.saveAndFlush(accountEntity);

		BeanUtils.copyProperties(newAccountEntity, termaccount);

		List<NomineeEntity> newNomineeEntities = newAccountEntity.getNominees();

		List<NomineePojo> newNomineePojos = new ArrayList<NomineePojo>();

		for (NomineeEntity newNomineeEntity : newNomineeEntities) {
			NomineePojo newNomineePojo = new NomineePojo();
			BeanUtils.copyProperties(newNomineeEntity, newNomineePojo);

			newNomineePojos.add(newNomineePojo);
		}
		termaccount.setNominees(newNomineePojos);

		return termaccount;

	}

	@Override
	public SavingAccountPojo updateSavingAccount(SavingAccountPojo savingaccount) {

		List<NomineePojo> nomineePojos = savingaccount.getNominees();

		List<NomineeEntity> nomineeEntities = new ArrayList<NomineeEntity>();

		SavingAccountEntity accountEntity = new SavingAccountEntity();

		BeanUtils.copyProperties(savingaccount, accountEntity);

		for (NomineePojo nomineePojo : nomineePojos) {
			NomineeEntity nomineeEntity = new NomineeEntity();
			BeanUtils.copyProperties(nomineePojo, nomineeEntity);
			nomineeEntities.add(nomineeEntity);
		}

		accountEntity.setNominees(nomineeEntities);

		SavingAccountEntity newAccountEntity = savingAccountRepository.saveAndFlush(accountEntity);

		BeanUtils.copyProperties(newAccountEntity, savingaccount);

		List<NomineeEntity> newNomineeEntities = newAccountEntity.getNominees();

		List<NomineePojo> newNomineePojos = new ArrayList<NomineePojo>();

		for (NomineeEntity newNomineeEntity : newNomineeEntities) {
			NomineePojo newNomineePojo = new NomineePojo();
			BeanUtils.copyProperties(newNomineeEntity, newNomineePojo);

			newNomineePojos.add(newNomineePojo);
		}
		savingaccount.setNominees(newNomineePojos);

		return savingaccount;
	}

	@Override
	public TermAccountPojo updateTermAccount(TermAccountPojo updatedTermAccount) {

		List<NomineePojo> nomineePojos = updatedTermAccount.getNominees();

		List<NomineeEntity> nomineeEntities = new ArrayList<NomineeEntity>();

		TermAccountEntity accountEntity = new TermAccountEntity();

		BeanUtils.copyProperties(updatedTermAccount, accountEntity);

		for (NomineePojo nomineePojo : nomineePojos) {
			NomineeEntity nomineeEntity = new NomineeEntity();
			BeanUtils.copyProperties(nomineePojo, nomineeEntity);
			nomineeEntities.add(nomineeEntity);
		}

		accountEntity.setNominees(nomineeEntities);

		TermAccountEntity newAccountEntity = termAccountRepository.saveAndFlush(accountEntity);

		BeanUtils.copyProperties(newAccountEntity, updatedTermAccount);

		List<NomineeEntity> newNomineeEntities = newAccountEntity.getNominees();

		List<NomineePojo> newNomineePojos = new ArrayList<NomineePojo>();

		for (NomineeEntity newNomineeEntity : newNomineeEntities) {
			NomineePojo newNomineePojo = new NomineePojo();
			BeanUtils.copyProperties(newNomineeEntity, newNomineePojo);

			newNomineePojos.add(newNomineePojo);
		}
		updatedTermAccount.setNominees(newNomineePojos);

		return updatedTermAccount;

	}

	@Override
	public boolean deleteSavingAccount(long accountId) {

		accountRepository.deleteById(accountId);
		return true;
	}

	@Override
	public boolean deleteTermAccount(long accountId) {

		accountRepository.deleteById(accountId);
		return true;
	}

	@Override
	public AccountPojo getAccount(long accountId) {

		Optional<AccountEntity> result = accountRepository.findById(accountId);

		if (result.isPresent() == false) {
			throw new AccountNotFoundException("Account with ID:" + accountId + " not found!");
		}

		AccountEntity accountEntity = result.get();

		AccountPojo accountPojo = new AccountPojo();

		BeanUtils.copyProperties(accountEntity, accountPojo);

		// handle nested beneficiaries
		List<BeneficiaryEntity> allBeneficiaries = accountEntity.getBeneficiaries();
		List<BeneficiaryPojo> allBeneficiaryPojos = new ArrayList<BeneficiaryPojo>();
		for (BeneficiaryEntity bEntity : allBeneficiaries) {
			BeneficiaryPojo bPojo = new BeneficiaryPojo();
			BeanUtils.copyProperties(bEntity, bPojo);

			allBeneficiaryPojos.add(bPojo);
		}

		accountPojo.setBeneficiaries(allBeneficiaryPojos);

		// handle nested transactions
		List<TransactionEntity> allTransactionEntities = accountEntity.getTransactions();
		List<TransactionPojo> allTransactionPojos = new ArrayList<TransactionPojo>();
		for (TransactionEntity tEntity : allTransactionEntities) {
			TransactionPojo tPojo = new TransactionPojo();
			BeanUtils.copyProperties(tEntity, tPojo);

			allTransactionPojos.add(tPojo);
		}

		accountPojo.setTransactions(allTransactionPojos);

		// handle nested beneficiaries
		List<NomineeEntity> allNomineeEntities = accountEntity.getNominees();
		List<NomineePojo> allNomineePojos = new ArrayList<NomineePojo>();
		for (NomineeEntity nEntity : allNomineeEntities) {
			NomineePojo nPojo = new NomineePojo();
			BeanUtils.copyProperties(nEntity, nPojo);

			allNomineePojos.add(nPojo);
		}

		accountPojo.setNominees(allNomineePojos);

		return accountPojo;

	}

	@Override
	public List<AccountPojo> listAllAccounts() {

		List<AccountEntity> accountEntities = accountRepository.findAll();

		if (accountEntities.isEmpty()) {
			throw new AccountNotFoundException("No Accounts found!");
		}

		List<AccountPojo> allAccounts = new ArrayList<AccountPojo>();
		for (AccountEntity account : accountEntities) {
			AccountPojo accountPojo = new AccountPojo();

			BeanUtils.copyProperties(account, accountPojo);

			// handle nested beneficiaries
			List<BeneficiaryEntity> allBeneficiaries = account.getBeneficiaries();
			List<BeneficiaryPojo> allBeneficiaryPojos = new ArrayList<BeneficiaryPojo>();
			for (BeneficiaryEntity bEntity : allBeneficiaries) {
				BeneficiaryPojo bPojo = new BeneficiaryPojo();
				BeanUtils.copyProperties(bEntity, bPojo);

				allBeneficiaryPojos.add(bPojo);
			}

			accountPojo.setBeneficiaries(allBeneficiaryPojos);

			// handle nested transactions
			List<TransactionEntity> allTransactionEntities = account.getTransactions();
			List<TransactionPojo> allTransactionPojos = new ArrayList<TransactionPojo>();
			for (TransactionEntity tEntity : allTransactionEntities) {
				TransactionPojo tPojo = new TransactionPojo();
				BeanUtils.copyProperties(tEntity, tPojo);

				allTransactionPojos.add(tPojo);
			}

			accountPojo.setTransactions(allTransactionPojos);

			// handle nested beneficiaries
			List<NomineeEntity> allNomineeEntities = account.getNominees();
			List<NomineePojo> allNomineePojos = new ArrayList<NomineePojo>();
			for (NomineeEntity nEntity : allNomineeEntities) {
				NomineePojo nPojo = new NomineePojo();
				BeanUtils.copyProperties(nEntity, nPojo);

				allNomineePojos.add(nPojo);
			}

			accountPojo.setNominees(allNomineePojos);

			allAccounts.add(accountPojo);
		}
		return allAccounts;

	}

	@Override
	public List<SavingAccountPojo> listAllSavingsAccounts() {

		List<SavingAccountEntity> accountEntities = savingAccountRepository.findAll();
		
		if (accountEntities.isEmpty()) {
			throw new AccountNotFoundException("No Accounts found!");
		}
		
		System.out.println(accountEntities);
		List<SavingAccountPojo> allAccounts = new ArrayList<SavingAccountPojo>();
		for (AccountEntity account : accountEntities) {
			SavingAccountPojo accountPojo = new SavingAccountPojo();

			BeanUtils.copyProperties(account, accountPojo);

			// handle nested beneficiaries
			List<BeneficiaryEntity> allBeneficiaries = account.getBeneficiaries();
			List<BeneficiaryPojo> allBeneficiaryPojos = new ArrayList<BeneficiaryPojo>();
			for (BeneficiaryEntity bEntity : allBeneficiaries) {
				BeneficiaryPojo bPojo = new BeneficiaryPojo();
				BeanUtils.copyProperties(bEntity, bPojo);

				allBeneficiaryPojos.add(bPojo);
			}

			accountPojo.setBeneficiaries(allBeneficiaryPojos);

			// handle nested transactions
			List<TransactionEntity> allTransactionEntities = account.getTransactions();
			List<TransactionPojo> allTransactionPojos = new ArrayList<TransactionPojo>();
			for (TransactionEntity tEntity : allTransactionEntities) {
				TransactionPojo tPojo = new TransactionPojo();
				BeanUtils.copyProperties(tEntity, tPojo);

				allTransactionPojos.add(tPojo);
			}

			accountPojo.setTransactions(allTransactionPojos);

			// handle nested beneficiaries
			List<NomineeEntity> allNomineeEntities = account.getNominees();
			List<NomineePojo> allNomineePojos = new ArrayList<NomineePojo>();
			for (NomineeEntity nEntity : allNomineeEntities) {
				NomineePojo nPojo = new NomineePojo();
				BeanUtils.copyProperties(nEntity, nPojo);

				allNomineePojos.add(nPojo);
			}

			accountPojo.setNominees(allNomineePojos);

			allAccounts.add(accountPojo);
		}
		return allAccounts;

	}

	@Override
	public List<TermAccountPojo> listAllTermAccounts() {

		List<AccountEntity> accountEntities = termAccountRepository.findAll();
		
		if (accountEntities.isEmpty()) {
			throw new AccountNotFoundException("No Accounts found!");
		}
		List<TermAccountPojo> allAccounts = new ArrayList<TermAccountPojo>();
		for (AccountEntity account : accountEntities) {
			TermAccountPojo accountPojo = new TermAccountPojo();

			BeanUtils.copyProperties(account, accountPojo);

			// handle nested beneficiaries
			List<BeneficiaryEntity> allBeneficiaries = account.getBeneficiaries();
			List<BeneficiaryPojo> allBeneficiaryPojos = new ArrayList<BeneficiaryPojo>();
			for (BeneficiaryEntity bEntity : allBeneficiaries) {
				BeneficiaryPojo bPojo = new BeneficiaryPojo();
				BeanUtils.copyProperties(bEntity, bPojo);

				allBeneficiaryPojos.add(bPojo);
			}

			accountPojo.setBeneficiaries(allBeneficiaryPojos);

			// handle nested transactions
			List<TransactionEntity> allTransactionEntities = account.getTransactions();
			List<TransactionPojo> allTransactionPojos = new ArrayList<TransactionPojo>();
			for (TransactionEntity tEntity : allTransactionEntities) {
				TransactionPojo tPojo = new TransactionPojo();
				BeanUtils.copyProperties(tEntity, tPojo);

				allTransactionPojos.add(tPojo);
			}

			accountPojo.setTransactions(allTransactionPojos);

			// handle nested beneficiaries
			List<NomineeEntity> allNomineeEntities = account.getNominees();
			List<NomineePojo> allNomineePojos = new ArrayList<NomineePojo>();
			for (NomineeEntity nEntity : allNomineeEntities) {
				NomineePojo nPojo = new NomineePojo();
				BeanUtils.copyProperties(nEntity, nPojo);

				allNomineePojos.add(nPojo);
			}

			accountPojo.setNominees(allNomineePojos);

			allAccounts.add(accountPojo);
		}
		return allAccounts;

	}

}
