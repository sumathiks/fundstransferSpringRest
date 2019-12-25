package com.hcl.ing.dao;

import java.util.List;

import com.hcl.ing.dto.AccountRequestDto;
import com.hcl.ing.dto.AccountResponseDto;
import com.hcl.ing.entity.Account;
import com.hcl.ing.exception.AccountsEmptyException;

public interface AccountDao {
	
	public AccountResponseDto addAccount(AccountRequestDto requestDto);

	public List<Account> getAccounts() throws AccountsEmptyException;

	public AccountResponseDto fundTranfer(AccountRequestDto accountrequest);

	
}
