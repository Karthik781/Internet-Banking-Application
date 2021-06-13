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

import com.iba.entity.NomineeEntity;
import com.iba.service.NomineeService;

@RestController
@RequestMapping("/nominee")
public class NomineeController {
	@Autowired
	NomineeService nomineeService;

	@PostMapping("/create")
	public NomineeEntity addNominee(@Valid @RequestBody NomineeEntity nominee) {
		return nomineeService.addNominee(nominee);
	}

	@PutMapping("/update")
	public NomineeEntity updateNominee(@Valid @RequestBody NomineeEntity Nominee) {
		return nomineeService.updateNominee(Nominee);
	}

	@DeleteMapping("/delete/{nomineeId}")
	public boolean deleteNominee(@PathVariable("nomineeId") long nomineeId) {
		return nomineeService.deleteNominee(nomineeId);
	}

	@GetMapping("/{nomineeId}")
	public Optional<NomineeEntity> findNomineeById(@PathVariable("nomineeId") long nomineeId) {
		return nomineeService.findNomineeById(nomineeId);
	}

	@GetMapping("/nominees/{accountId}")
	public List<NomineeEntity> listAllNomineesByAccount(@PathVariable("accountId") long accountId) {
		return nomineeService.listAllNomineesByAccount(accountId);

	}

}
