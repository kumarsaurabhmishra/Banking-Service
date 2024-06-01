package com.saurabh.finance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.finance.dtos.request.FundTransferRequest;
import com.saurabh.finance.dtos.request.UtilityPaymentRequest;
import com.saurabh.finance.dtos.response.FundTransferResponse;
import com.saurabh.finance.dtos.response.UtilityPaymentResponse;
import com.saurabh.finance.service.TransactionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {

	private final TransactionService service;
	
	@PostMapping("/fund-transfer")
	public ResponseEntity<FundTransferResponse> fundTransfer(@RequestBody FundTransferRequest request) {
		log.info("Fund Transfer initiated in core bank from {}", request.toString());
		return ResponseEntity.ok(service.fundTransfer(request));		
	}
	
	@PostMapping("util-payment")
	public ResponseEntity<UtilityPaymentResponse> utilPayment(@RequestBody UtilityPaymentRequest request) {
		log.info("Utility Payment initiated in core bank from {}", request.toString());
		return ResponseEntity.ok(service.utilPayment(request));
	}
	
	
	
}
