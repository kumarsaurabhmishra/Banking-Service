package com.saurabh.finance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.finance.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

	Optional<BankAccount> findByNumber(String accountNumber);
	
}
