package com.iba;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.iba.entity.AccountEntity;
import com.iba.entity.AdminEntity;
import com.iba.entity.BeneficiaryEntity;
import com.iba.entity.CustomerEntity;
import com.iba.entity.NomineeEntity;
import com.iba.entity.SavingAccountEntity;
import com.iba.entity.TransactionEntity;
import com.iba.entity.UserEntity;
import com.iba.repository.AdminRepository;
import com.iba.repository.BeneficiaryRepository;
import com.iba.repository.CustomerRepository;
import com.iba.repository.NomineeRepository;
import com.iba.repository.SavingAccountRepository;
import com.iba.repository.TransactionRepository;
import com.iba.repository.UserRepository;

@SpringBootApplication
public class InternetBankingApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext configurableApplicationContext =	SpringApplication.run(InternetBankingApplication.class, args);
//		UserRepository adminRepository = configurableApplicationContext.getBean(AdminRepository.class);
		
		//UserRepository customerRepository = configurableApplicationContext.getBean(CustomerRepository.class);
		
//		UserEntity admin = new AdminEntity( "password", "type",  "adminName", "adminContact","adminEmailId");
		
//		UserEntity cust = new CutomerEntity( "anjsd123", "customer","tom", "997878687",
//				"tom@gmail.com", 30, "male");
//		
//		customerRepository.save(cust);
		
//		SavingAccountRepository savingAccountRepository= configurableApplicationContext.getBean(SavingAccountRepository.class);
//		
//		SavingAccountEntity savAccount = new SavingAccountEntity(21, 12.0, 10000.0,
//				"2018-01-25", 500.0, 20.0);
//		
//		savingAccountRepository.save(savAccount);
		
		
//		BeneficiaryRepository beneficiaryRepository = configurableApplicationContext.getBean(BeneficiaryRepository.class);
//		
//		BeneficiaryEntity ben = new BeneficiaryEntity("maria", 7700798, "ifsc1787",
//				"term", 53);
//		beneficiaryRepository.save(ben);
		
//		TransactionRepository transactionRepository= configurableApplicationContext.getBean(TransactionRepository.class);
//		
//		TransactionEntity tran = new TransactionEntity(10.0, "debit",
//				"fail", "server error", 56, 53);
//		
//		transactionRepository.save(tran);
		
//		NomineeRepository nomineeRepository = configurableApplicationContext.getBean(NomineeRepository.class);
//		
//		NomineeEntity nom = new NomineeEntity( "twon",  "345345334", "Adhaar", "97867565",
//				 "son");
//		
//		nomineeRepository.save(nom);
	}

}
