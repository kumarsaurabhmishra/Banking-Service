package com.saurabh.finance.dtos;

import java.math.BigDecimal;

import com.saurabh.finance.enums.AccountStatus;
import com.saurabh.finance.enums.AccountType;

import lombok.Data;

@Data
public class BankAccountDTO {

	private Long id;
	private String number;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    private UserDTO user;
	
}
