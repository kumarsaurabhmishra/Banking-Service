package com.saurabh.finance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.finance.entity.AccountUtility;

public interface AccountUtilityRepository extends JpaRepository<AccountUtility, Long>{

	Optional<AccountUtility> findByProviderName(String provider);
	
}
