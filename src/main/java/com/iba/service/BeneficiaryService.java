package com.iba.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;

import com.iba.entity.BeneficiaryEntity;
import com.iba.pojo.BeneficiaryPojo;

public interface BeneficiaryService {
	
	public BeneficiaryPojo addBeneficiary(BeneficiaryPojo beneficiary);

	public BeneficiaryPojo updateBeneficiary(BeneficiaryPojo Beneficiary);

	public boolean deleteBeneficiary(long beneficiaryId);

	public BeneficiaryPojo findBeneficiaryById(long beneficiaryId);

	public List<BeneficiaryPojo> listAllBeneficiaries();
	
	public List<BeneficiaryPojo> findAllBeneficiariesByAccount(long accountId);
	
}


