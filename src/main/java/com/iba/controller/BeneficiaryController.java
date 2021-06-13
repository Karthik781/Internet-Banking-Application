package com.iba.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.BeneficiaryEntity;
import com.iba.pojo.BeneficiaryPojo;
import com.iba.service.BeneficiaryService;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@GetMapping("/all")
	public List<BeneficiaryPojo> getAllBeneficiaries() {
		return beneficiaryService.listAllBeneficiaries();
	}

	@PostMapping("/create")
	public BeneficiaryPojo addBeneficiary(@Valid @RequestBody BeneficiaryPojo beneficiary) {
		return beneficiaryService.addBeneficiary(beneficiary);
	}

	@PutMapping("/update")
	public BeneficiaryPojo updateBeneficiary(@Valid @RequestBody BeneficiaryPojo beneficiary) {
		return beneficiaryService.updateBeneficiary(beneficiary);
	}

	@DeleteMapping("/delete/{beneficiaryId}")
	public boolean deleteBeneficiary(@PathVariable("beneficiaryId") long beneficiaryId) {
		return beneficiaryService.deleteBeneficiary(beneficiaryId);

	}

	@GetMapping("/get/{beneficiaryId}")
	public BeneficiaryPojo findBeneficiaryById(@PathVariable("beneficiaryId") long beneficiaryId) {
		return beneficiaryService.findBeneficiaryById(beneficiaryId);
	}

	@GetMapping("/account/{accountId}")
	public List<BeneficiaryPojo> listAllBeneficiariesByAccount(@PathVariable("accountId") long accountId) {
		return beneficiaryService.findAllBeneficiariesByAccount(accountId);
	}
}
