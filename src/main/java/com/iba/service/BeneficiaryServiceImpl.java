package com.iba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.entity.AccountEntity;
import com.iba.entity.BeneficiaryEntity;
import com.iba.entity.CustomerEntity;
import com.iba.entity.UserEntity;
import com.iba.exception.AdminNotFoundException;
import com.iba.exception.BeneficiaryNotFoundException;
import com.iba.pojo.AccountPojo;
import com.iba.pojo.BeneficiaryPojo;
import com.iba.pojo.CustomerPojo;
import com.iba.repository.BeneficiaryRepository;
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{
	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Override
	public BeneficiaryPojo addBeneficiary(BeneficiaryPojo beneficiary) {
		
		
		BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
		
		AccountPojo accountPojo = beneficiary.getAccount();
		
		AccountEntity accountEntity = new AccountEntity();
		
		BeanUtils.copyProperties(accountPojo, accountEntity);

		BeanUtils.copyProperties(beneficiary, beneficiaryEntity);
		
		beneficiaryEntity.setAccount(accountEntity);
				
		BeneficiaryEntity newEntity =  beneficiaryRepository.save(beneficiaryEntity);
		
		BeanUtils.copyProperties(newEntity, beneficiary);
		
		return beneficiary;
		
	}

	@Override
	public BeneficiaryPojo updateBeneficiary(BeneficiaryPojo beneficiary) {
		
		System.out.println(beneficiary);
		
		BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
		
		AccountPojo accountPojo = beneficiary.getAccount();
		
		AccountEntity accountEntity = new AccountEntity();
		
		BeanUtils.copyProperties(accountPojo, accountEntity);

		BeanUtils.copyProperties(beneficiary, beneficiaryEntity);
		
		beneficiaryEntity.setAccount(accountEntity);
				
		BeneficiaryEntity newEntity =  beneficiaryRepository.save(beneficiaryEntity);
		
		BeanUtils.copyProperties(newEntity, beneficiary);
		
		return beneficiary;
	}

	@Override
	public boolean deleteBeneficiary(long beneficiaryId) {
		beneficiaryRepository.deleteById( beneficiaryId);;
		return true;
	}

	@Override
	public BeneficiaryPojo findBeneficiaryById(long beneficiaryId) {
		
		Optional<BeneficiaryEntity> beneficiaryEntity =  beneficiaryRepository.findById(beneficiaryId);
		
		if(beneficiaryEntity.isPresent() == false) {
			throw new BeneficiaryNotFoundException("No beneficiary found!");
		}
		
		BeneficiaryPojo beneficiaryPojo = new BeneficiaryPojo();
		
		AccountEntity accountEntity = beneficiaryEntity.get().getAccount();
		
		AccountPojo accountPojo= new AccountPojo();
		
		BeanUtils.copyProperties(accountEntity, accountPojo);
		
		BeanUtils.copyProperties(beneficiaryEntity, beneficiaryPojo);
		
		beneficiaryPojo.setAccount(accountPojo);
		
		return beneficiaryPojo;
	}

	@Override
	public List<BeneficiaryPojo> listAllBeneficiaries() {
		
		List<BeneficiaryEntity> beneficiaryEntities = beneficiaryRepository.findAll();
		
		if(beneficiaryEntities.isEmpty()) {
			throw new BeneficiaryNotFoundException("No beneficiaries  found");
		}
		List<BeneficiaryPojo> beneficiaryPojos = new ArrayList<BeneficiaryPojo>();

		for (BeneficiaryEntity entity : beneficiaryEntities) {
			
			AccountEntity accountEntity = entity.getAccount();
			
			AccountPojo accountPojo= new AccountPojo();
			
			BeanUtils.copyProperties(accountEntity, accountPojo);
			
			BeneficiaryPojo beneficiaryPojo = new BeneficiaryPojo();

			BeanUtils.copyProperties(entity, beneficiaryPojo);
			
			beneficiaryPojo.setAccount(accountPojo);

			beneficiaryPojos.add(beneficiaryPojo);
		}

		return beneficiaryPojos;
		
	}

	@Override
	public	List<BeneficiaryPojo> findAllBeneficiariesByAccount(long accountId) {
		List<BeneficiaryEntity> beneficiaryEntities = beneficiaryRepository.findAllBeneficiariesByAccount(accountId);
		
		if(beneficiaryEntities.isEmpty()) {
			throw new BeneficiaryNotFoundException("No beneficiaries  found");
		}
		List<BeneficiaryPojo> beneficiaryPojos = new ArrayList<BeneficiaryPojo>();

		for (BeneficiaryEntity entity : beneficiaryEntities) {
			
			AccountEntity accountEntity = entity.getAccount();
			
			AccountPojo accountPojo= new AccountPojo();
			
			BeanUtils.copyProperties(accountEntity, accountPojo);
			
			BeneficiaryPojo beneficiaryPojo = new BeneficiaryPojo();

			BeanUtils.copyProperties(entity, beneficiaryPojo);
			
			beneficiaryPojo.setAccount(accountPojo);

			beneficiaryPojos.add(beneficiaryPojo);
		}

		return beneficiaryPojos;
	}
	
}
