package com.hcl.ing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ing.dao.AccountDao;
import com.hcl.ing.dto.AccountRequestDto;
import com.hcl.ing.dto.AccountResponseDto;
import com.hcl.ing.entity.Account;
import com.hcl.ing.exception.AccountsEmptyException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	
	@Transactional
	public AccountResponseDto addAccount(AccountRequestDto requestDto) {
		return accountDao.addAccount(requestDto);
	}


	public List<Account> getAccounts() throws AccountsEmptyException{
		return accountDao.getAccounts();
	}

	@Transactional
	public AccountResponseDto fundTransfor(AccountRequestDto accountrequest) {
		return accountDao.fundTranfer(accountrequest);
	}

}
