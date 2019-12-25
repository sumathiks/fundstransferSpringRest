package com.hcl.ing.dao;

import com.hcl.ing.dto.CustomerRequestDto;
import com.hcl.ing.dto.CustomerResponseDto;
import com.hcl.ing.exception.BalanceNotEmptyExcpetion;

public interface CustomerDao {
	
	public CustomerResponseDto addCustomer(CustomerRequestDto requestDto) throws BalanceNotEmptyExcpetion;

	
}
