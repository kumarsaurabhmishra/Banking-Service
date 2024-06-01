package com.saurabh.finance.service;

import org.springframework.stereotype.Service;

import com.saurabh.finance.dtos.AccountUtitlityDTO;
import com.saurabh.finance.dtos.BankAccountDTO;

@Service
public interface AccountService {

	public BankAccountDTO readBankAccount(String accountNumber);
	
	public AccountUtitlityDTO readAccountUtility(String provider);
	
	public AccountUtitlityDTO readAccountUtility(Long id);
	
}
