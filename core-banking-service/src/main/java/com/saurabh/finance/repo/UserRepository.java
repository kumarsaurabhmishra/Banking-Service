package com.saurabh.finance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.finance.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByIdentificationNumber(String identificationNumber);
	
}
