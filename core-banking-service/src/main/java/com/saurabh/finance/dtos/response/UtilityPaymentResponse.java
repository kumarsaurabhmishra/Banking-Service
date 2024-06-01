package com.saurabh.finance.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UtilityPaymentResponse {

	
	private String message;
	private String transactionId;
	
}
