package com.iba.service;

import java.util.List;
import java.util.Optional;

import com.iba.entity.NomineeEntity;

public interface NomineeService {
	public NomineeEntity addNominee(NomineeEntity nominee);

	public NomineeEntity updateNominee(NomineeEntity Nominee);

	public boolean deleteNominee(long nomineeId);

	public Optional<NomineeEntity> findNomineeById(long nomineeId);

	public List<NomineeEntity> listAllNominees();
	
	public List<NomineeEntity> listAllNomineesByAccount(long accountId);
}
