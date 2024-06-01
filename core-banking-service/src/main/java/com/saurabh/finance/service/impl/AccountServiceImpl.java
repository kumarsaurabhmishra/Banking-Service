package com.saurabh.finance.service.impl;

import org.springframework.stereotype.Service;

import com.saurabh.finance.dtos.AccountUtitlityDTO;
import com.saurabh.finance.dtos.BankAccountDTO;
import com.saurabh.finance.entity.AccountUtility;
import com.saurabh.finance.entity.BankAccount;
import com.saurabh.finance.mapper.AccountUtilityMapper;
import com.saurabh.finance.mapper.BankAccountMapper;
import com.saurabh.finance.repo.AccountUtilityRepository;
import com.saurabh.finance.repo.BankAccountRepository;
import com.saurabh.finance.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
	
	private BankAccountMapper mapper = new BankAccountMapper();
	private AccountUtilityMapper utilityMapper = new AccountUtilityMapper();
	
	private final BankAccountRepository bankAccountRepository;
	private final AccountUtilityRepository accountUtilityRepository;
	@Override
	public BankAccountDTO readBankAccount(String accountNumber) {
		
		BankAccount bankAccount = bankAccountRepository.findByNumber(accountNumber).get();
		return mapper.convertToDto(bankAccount);
		
	}
	@Override
	public AccountUtitlityDTO readAccountUtility(String provider) {
		
		AccountUtility accountUtility = accountUtilityRepository.findByProviderName(provider).get();
		return utilityMapper.convertToDto(accountUtility);
		
	}
	@Override
	public AccountUtitlityDTO readAccountUtility(Long id) {
		return utilityMapper.convertToDto(accountUtilityRepository.findById(id).get());
	}
	
	
	

}
