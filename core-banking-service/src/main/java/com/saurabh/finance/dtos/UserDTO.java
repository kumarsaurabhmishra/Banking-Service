package com.saurabh.finance.dtos;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String identificationNumber;
	private List<BankAccountDTO> bankAccounts;
	
}
