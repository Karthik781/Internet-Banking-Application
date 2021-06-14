package com.iba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iba.entity.CustomerEntity;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	

	@Query(
		value = "SELECT * FROM ACCOUNT u WHERE u.ACCOUNT_ID = ?1",
		nativeQuery = true
	)
	List<CustomerEntity> findTransactionsByAccount(long accountId);
	
}
