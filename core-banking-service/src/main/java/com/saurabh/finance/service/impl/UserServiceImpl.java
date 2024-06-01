package com.saurabh.finance.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.saurabh.finance.dtos.UserDTO;
import com.saurabh.finance.entity.User;
import com.saurabh.finance.mapper.UserMapper;
import com.saurabh.finance.repo.UserRepository;
import com.saurabh.finance.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
	
	private UserMapper mapper;
	
	private final UserRepository repository;

	@Override
	public UserDTO readUser(String identificationNumber) {
		
		User user = repository.findByIdentificationNumber(identificationNumber).get();
		return mapper.convertToDto(user);
		
	}

	@Override
	public List<UserDTO> readUsers(Pageable pageable) {
		return mapper.convertToDtoList(repository.findAll(pageable).getContent());
		
	}
	
	

}
