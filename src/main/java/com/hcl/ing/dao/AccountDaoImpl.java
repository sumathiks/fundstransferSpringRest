package com.hcl.ing.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.ing.dto.AccountRequestDto;
import com.hcl.ing.dto.AccountResponseDto;
import com.hcl.ing.entity.Account;
import com.hcl.ing.exception.AccountsEmptyException;
import com.hcl.ing.util.FundTransferConstants;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	AccountResponseDto responseDto = new AccountResponseDto();

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	public AccountResponseDto addAccount(AccountRequestDto requestDto)  {
		
		Account account=new Account();
		BeanUtils.copyProperties(requestDto, account);
		getSession().save(account);
		responseDto.setMessage(account.getAccountName()+FundTransferConstants.ACCOUNT_ADD_SUCCESS);
		responseDto.setStatusCode(HttpStatus.CREATED.value());
		return responseDto;
	}
	@SuppressWarnings("unchecked")
	public List<Account> getAccounts() throws AccountsEmptyException{
		List<Account> accounts = getSession().createCriteria(Account.class).list();
		if(accounts.isEmpty()) {
			throw new AccountsEmptyException(FundTransferConstants.ACCOINTS_ARE_EMPTY);
		}else {
		return accounts;
		}
	}
	@SuppressWarnings("unchecked")
	public AccountResponseDto fundTranfer(AccountRequestDto accountrequest) {
		List<Account> accounts = getSession().createCriteria(Account.class).list();
		for (Account account : accounts) {
			String srcAccountNo = account.getAccountNo();
			long balance = account.getBalance();
		}
		getSession().save(accounts.get(0));
		return null;
	}
}