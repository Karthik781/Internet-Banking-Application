package com.iba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iba.entity.BeneficiaryEntity;

@Repository
public interface BeneficiaryRepository extends JpaRepository<BeneficiaryEntity, Long>{
	
	@Query(
			value = "SELECT * FROM beneficiary u WHERE u.ACCOUNT_ID = ?1",
			nativeQuery = true
		)
	List<BeneficiaryEntity> findAllBeneficiariesByAccount(long accountId);
}
