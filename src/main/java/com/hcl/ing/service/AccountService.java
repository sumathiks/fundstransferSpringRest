package com.hcl.ing.service;

import java.util.List;

import com.hcl.ing.dto.AccountRequestDto;
import com.hcl.ing.dto.AccountResponseDto;
import com.hcl.ing.entity.Account;
import com.hcl.ing.exception.AccountsEmptyException;

public interface AccountService {
	
	public AccountResponseDto addAccount(AccountRequestDto requestDto) ;

	public List<Account> getAccounts() throws AccountsEmptyException;

	public AccountResponseDto fundTransfor(AccountRequestDto accountrequest);
	
	
}
