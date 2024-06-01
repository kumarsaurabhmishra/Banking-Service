package com.saurabh.finance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.finance.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{

	
	
}
