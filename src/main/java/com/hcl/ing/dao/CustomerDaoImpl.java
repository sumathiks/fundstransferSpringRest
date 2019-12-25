package com.hcl.ing.dao;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.ing.dto.CustomerRequestDto;
import com.hcl.ing.dto.CustomerResponseDto;
import com.hcl.ing.entity.Account;
import com.hcl.ing.entity.Customer;
import com.hcl.ing.exception.BalanceNotEmptyExcpetion;
import com.hcl.ing.util.FundTransferConstants;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	CustomerResponseDto responseDto = new CustomerResponseDto();

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	
	public CustomerResponseDto addCustomer(CustomerRequestDto requestDto) throws BalanceNotEmptyExcpetion {
		
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		Customer customer=new Customer();
		if(Objects.isNull(customer.getBalance())) {
			throw new BalanceNotEmptyExcpetion(FundTransferConstants.CUST_BAL_NOT_EMPTY);
		}else {
		BeanUtils.copyProperties(requestDto, customer);
		getSession().save(customer);
		customerResponseDto.setMessage(customer.getCustomerName()+FundTransferConstants.CUSTOMER_ADD_SUCCESSFULLY);
		customerResponseDto.setStatusCode(HttpStatus.CREATED.value());
		if(customerResponseDto.getStatusCode()==201) {
			Account account=new Account();
			account.setAccountNo(new FundTransferConstants().random());
			account.setAccountName(customer.getCustomerName());
			account.setAccountType(customer.getAccountType());
			account.setIfscCode(customer.getIfscCode());
			account.setCustomer(customer);
			account.setBalance(customer.getBalance());
			getSession().save(account);
		}else {
			customerResponseDto.setMessage(customer.getCustomerName()+FundTransferConstants.NOT_ADD_ACCOUNT_SUCCESS);
			customerResponseDto.setStatusCode(HttpStatus.CREATED.value());
		}
		}
		
		return customerResponseDto;
}
}