package com.saurabh.finance.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransactionDTO {

	private Long id;
	private BigDecimal amount;
	private BankAccountDTO bankAccount;
	private String refernceNumber;
	
}
