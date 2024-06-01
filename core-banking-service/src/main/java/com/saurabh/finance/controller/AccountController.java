package com.saurabh.finance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.finance.dtos.AccountUtitlityDTO;
import com.saurabh.finance.dtos.BankAccountDTO;
import com.saurabh.finance.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/account")
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService service;
	
	@GetMapping("/bank-account/{account_number}")
	public ResponseEntity<BankAccountDTO> getBankAccount(@PathVariable("account_number") String accountNumber) {
		log.info("Reading acount by Id {}", accountNumber);
		return ResponseEntity.ok(service.readBankAccount(accountNumber));				
	}
	
	@GetMapping("/util-account/{account_name}")
	public ResponseEntity<AccountUtitlityDTO> getUtilityAccount(@PathVariable("account_name") String providerName) {
		log.info("Reading utility account by Id {}", providerName);
		return ResponseEntity.ok(service.readAccountUtility(providerName));
	}

}
