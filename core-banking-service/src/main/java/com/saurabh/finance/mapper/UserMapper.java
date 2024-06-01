package com.saurabh.finance.mapper;

import org.springframework.beans.BeanUtils;

import com.saurabh.finance.dtos.UserDTO;
import com.saurabh.finance.entity.User;

public class UserMapper extends BaseMapper<User, UserDTO>{
	
	private BankAccountMapper bankAccountMapper = new BankAccountMapper();

	@Override
	public User convertToEntity(UserDTO dto, Object... args) {
		
		User user = new User();
		if(dto!=null) {
			BeanUtils.copyProperties(dto, user, "accounts");
			user.setAccounts(bankAccountMapper.convertToEntityList(dto.getBankAccounts()));
		}	
		return user;		
	}

	@Override
	public UserDTO convertToDto(User entity, Object... args) {
		
		UserDTO dto = new UserDTO();
		
		if(entity!=null) {
			BeanUtils.copyProperties(entity, dto, "accounts");
			dto.setBankAccounts(bankAccountMapper.convertToDtoList(entity.getAccounts()));
		}
		
		return dto;
		
	}

}
