package com.saurabh.finance.service;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.saurabh.finance.dtos.UserDTO;

@Service
public interface UserService {
	
	public UserDTO readUser(String identificationNumber);
	
	public List<UserDTO> readUsers(Pageable pageable);

}
