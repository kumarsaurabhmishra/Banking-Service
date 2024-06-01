package com.saurabh.finance.mapper;

import org.springframework.beans.BeanUtils;

import com.saurabh.finance.dtos.AccountUtitlityDTO;
import com.saurabh.finance.entity.AccountUtility;

public class AccountUtilityMapper extends BaseMapper<AccountUtility, AccountUtitlityDTO>{

	@Override
	public AccountUtility convertToEntity(AccountUtitlityDTO dto, Object... args) {
		
		AccountUtility entity = new AccountUtility();
		
		if(dto!=null) {
			BeanUtils.copyProperties(dto, entity);
		}
		
		return entity;
	}

	@Override
	public AccountUtitlityDTO convertToDto(AccountUtility entity, Object... args) {
		
		AccountUtitlityDTO dto = new AccountUtitlityDTO();
		
		if(entity!=null) {
			BeanUtils.copyProperties(entity, dto);
		}
		
		return dto;
	}
	
	
	

}
