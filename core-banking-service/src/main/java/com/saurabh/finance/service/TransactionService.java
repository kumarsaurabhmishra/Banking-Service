package com.saurabh.finance.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.saurabh.finance.dtos.BankAccountDTO;
import com.saurabh.finance.dtos.request.FundTransferRequest;
import com.saurabh.finance.dtos.request.UtilityPaymentRequest;
import com.saurabh.finance.dtos.response.FundTransferResponse;
import com.saurabh.finance.dtos.response.UtilityPaymentResponse;

@Service
public interface TransactionService {

	public FundTransferResponse fundTransfer(FundTransferRequest request);
	
	public UtilityPaymentResponse utilPayment(UtilityPaymentRequest request);
	
	public String internalFundTransfer(BankAccountDTO fromAccount, BankAccountDTO toAccount, BigDecimal amount);
}
