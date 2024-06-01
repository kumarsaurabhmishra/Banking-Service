package com.saurabh.finance.service.impl;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.saurabh.finance.dtos.AccountUtitlityDTO;
import com.saurabh.finance.dtos.BankAccountDTO;
import com.saurabh.finance.dtos.request.FundTransferRequest;
import com.saurabh.finance.dtos.request.UtilityPaymentRequest;
import com.saurabh.finance.dtos.response.FundTransferResponse;
import com.saurabh.finance.dtos.response.UtilityPaymentResponse;
import com.saurabh.finance.entity.BankAccount;
import com.saurabh.finance.entity.Transactions;
import com.saurabh.finance.enums.TransactionType;
import com.saurabh.finance.repo.BankAccountRepository;
import com.saurabh.finance.repo.TransactionRepository;
import com.saurabh.finance.service.AccountService;
import com.saurabh.finance.service.TransactionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class TransactionServiceImpl implements TransactionService{

	private final AccountService accountService;
	private final BankAccountRepository bankAccountRepository;
	private final TransactionRepository transactionRepository;
	
	@Override
	public FundTransferResponse fundTransfer(FundTransferRequest request) {
		
		BankAccountDTO fromBankAccount = accountService.readBankAccount(request.getFromAccount());
		BankAccountDTO toBankAccount = accountService.readBankAccount(request.getToAccount());
		
		validateBalance(fromBankAccount, request.getAmount());
		
		String transactionId = internalFundTransfer(fromBankAccount, toBankAccount, request.getAmount());
		
		return FundTransferResponse.builder()
				.message("Transaction Completed Successfully")
				.transactionId(transactionId)
				.build();
		
	}
	
	private void validateBalance(BankAccountDTO fromBankAccount, BigDecimal amount) {
		
		if(fromBankAccount.getActualBalance().compareTo(BigDecimal.ZERO) < 0 || fromBankAccount.getActualBalance().compareTo(amount) < 0) {
			throw new RuntimeException();
		}
		
	}
	
	@Override
	public UtilityPaymentResponse utilPayment(UtilityPaymentRequest request) {
		
		String transactionId = UUID.randomUUID().toString();
		
		BankAccountDTO fromBankAccount = accountService.readBankAccount(request.getAccount());
		
		validateBalance(fromBankAccount, request.getAmount());
		
		AccountUtitlityDTO accountUtitlityDTO = accountService.readAccountUtility(request.getProviderId());
		
		BankAccount fromAccount = bankAccountRepository.findByNumber(fromBankAccount.getNumber()).get();
		
		//
		
		fromAccount.setActualBalance(fromAccount.getActualBalance().subtract(request.getAmount()));
		fromAccount.setAvailableBalance(fromAccount.getActualBalance().subtract(request.getAmount()));
		
		transactionRepository.save(
				Transactions.builder()
				.type(TransactionType.UTILITY_PAYMENT)
				.account(fromAccount)
				.transactionId(transactionId)
				.refernceNumber(request.getReferenceNumber())
				.amount(request.getAmount().negate())
				.build());
		
		return UtilityPaymentResponse.builder()
				.message("Utility Payment Successfully Completed")
				.transactionId(transactionId)
				.build();
	}
	
	@Override
	public String internalFundTransfer(BankAccountDTO fromAccount, BankAccountDTO toAccount, BigDecimal amount) {
		
		String transactionId = UUID.randomUUID().toString();
		
		BankAccount fromBankAccount = bankAccountRepository.findByNumber(fromAccount.getNumber()).get();
		BankAccount toBankAccount = bankAccountRepository.findByNumber(toAccount.getNumber()).get();
		
		fromBankAccount.setActualBalance(fromAccount.getActualBalance().subtract(amount));
		fromBankAccount.setAvailableBalance(fromAccount.getActualBalance().subtract(amount));
		
		bankAccountRepository.save(fromBankAccount);
		
		transactionRepository.save(
				Transactions.builder()
				.type(TransactionType.FUND_TRANSFER)
				.refernceNumber(toBankAccount.getNumber())
				.transactionId(transactionId)
				.account(fromBankAccount)
				.amount(amount.negate())
				.build()
				);
		
		toBankAccount.setActualBalance(toAccount.getActualBalance().add(amount));
		toBankAccount.setAvailableBalance(toAccount.getActualBalance().add(amount));
		
		bankAccountRepository.save(toBankAccount);
		
		transactionRepository.save(
				Transactions.builder()
				.type(TransactionType.FUND_TRANSFER)
				.refernceNumber(toBankAccount.getNumber())
				.transactionId(transactionId)
				.account(toBankAccount)
				.amount(amount)
				.build()
				);
		
		
		return transactionId;
	}
	
	
	
}
