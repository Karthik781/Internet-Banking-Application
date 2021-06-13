package com.iba.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.entity.NomineeEntity;
import com.iba.repository.NomineeRepository;

@Service
public class NomineeServiceImpl implements NomineeService {

	@Autowired
	NomineeRepository nomineeRepository;

	public NomineeServiceImpl() {

	}

	@Override
	public NomineeEntity addNominee(NomineeEntity nominee) {
		return nomineeRepository.save(nominee);
	}

	@Override
	public NomineeEntity updateNominee(NomineeEntity nominee) {

		return nomineeRepository.save(nominee);
	}

	@Override
	public boolean deleteNominee(long nomineeId) {
		nomineeRepository.deleteById(nomineeId);
		return true;
	}

	@Override
	public Optional<NomineeEntity> findNomineeById(long nomineeId) {

		return nomineeRepository.findById( nomineeId);
	}

	@Override
	public List<NomineeEntity> listAllNominees() {
		return  nomineeRepository.findAll();
	}

	@Override
	public List<NomineeEntity> listAllNomineesByAccount(long accountId) {
		
		return null;
	}

}
