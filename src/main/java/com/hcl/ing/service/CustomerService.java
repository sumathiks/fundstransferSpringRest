package com.hcl.ing.service;

import com.hcl.ing.dto.CustomerRequestDto;
import com.hcl.ing.dto.CustomerResponseDto;
import com.hcl.ing.exception.BalanceNotEmptyExcpetion;

public interface CustomerService {
	
	public CustomerResponseDto addCustomer(CustomerRequestDto requestDto) throws BalanceNotEmptyExcpetion ;
	
	
}
