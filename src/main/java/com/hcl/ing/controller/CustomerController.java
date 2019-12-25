package com.hcl.ing.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.dto.CustomerRequestDto;
import com.hcl.ing.dto.CustomerResponseDto;
import com.hcl.ing.dto.TransactionRequestDto;
import com.hcl.ing.dto.TransactionResponseDto;
import com.hcl.ing.entity.Account;
import com.hcl.ing.entity.Transaction;
import com.hcl.ing.exception.AccountsEmptyException;
import com.hcl.ing.exception.BalanceNotEmptyExcpetion;
import com.hcl.ing.exception.ExceptionById;
import com.hcl.ing.exception.InsufficientFundsException;
import com.hcl.ing.service.AccountService;
import com.hcl.ing.service.CustomerService;
import com.hcl.ing.service.TransferService;


@RestController
@RequestMapping("/customers")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerService booksService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	TransferService transferService;
	
	/**
	 * 
	 * @param customer type 
	 * @return ResponseEntity of Customer response 
	 * @throws BalanceNotEmptyExcpetion when balance empty
	 */
	@RequestMapping(value = "/addCustomers", method = RequestMethod.POST)
	public ResponseEntity<CustomerResponseDto> addCustomers(CustomerRequestDto customer) throws BalanceNotEmptyExcpetion {
		LOGGER.info("addCustomers Method in CustomerController started");
		return new ResponseEntity<CustomerResponseDto>(booksService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param empty
	 * @return ResponseEntity of List of accounts  
	 * @throws AccountsEmptyException when accounts are  empty
	 */
	@RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAccounts() throws AccountsEmptyException {
		LOGGER.info("getAccounts Method in CustomerController started");
		return new ResponseEntity<List<Account>>(accountService.getAccounts(), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param transactionrequest 
	 * @return ResponseEntity of Transaction   
	 * @throws InsufficientFundsException when from account balance empty or less than to account 
	 */
	@RequestMapping(value = "/fundTransfor", method = RequestMethod.POST) 
	public ResponseEntity<TransactionResponseDto> fundTransfor(TransactionRequestDto transactionrequest) throws InsufficientFundsException {
		LOGGER.info("fundTransfor Method in CustomerController started");
		return new ResponseEntity<TransactionResponseDto>(transferService.fundTransfor(transactionrequest), HttpStatus.OK);
	}

	/**
	 * 
	 * @param empty 
	 * @return ResponseEntity of list of transactions for perticular  customer   
	 * @throws InsufficientFundsException when from account balance empty or less than to account 
	 */
	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getTransactions()  {
		LOGGER.info("getTransactions Method in CustomerController started");
		return new ResponseEntity<List<Transaction>>(transferService.getTransactions(), HttpStatus.OK);
	}
	@RequestMapping(value = "/getTransactions/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<TransactionResponseDto> getTransactionsByAccountId(int accountId) throws ExceptionById  {
		LOGGER.info("getTransactionsByAccountId Method in CustomerController started");
		return new ResponseEntity<TransactionResponseDto>(transferService.getTransactionsByAccountId(accountId), HttpStatus.OK);
	}
}
