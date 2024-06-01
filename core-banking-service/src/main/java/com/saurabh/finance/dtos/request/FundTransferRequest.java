package com.saurabh.finance.dtos.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FundTransferRequest {

		private String fromAccount;
		private String toAccount;
		private BigDecimal amount;
	
}
