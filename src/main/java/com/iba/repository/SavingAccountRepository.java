package com.iba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iba.entity.SavingAccountEntity;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccountEntity, Long> {

}
