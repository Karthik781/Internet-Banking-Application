package com.iba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iba.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity	, Long> {

}
