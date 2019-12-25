package com.hcl.ing.service;

import java.util.List;

import com.hcl.ing.dto.TransactionRequestDto;
import com.hcl.ing.dto.TransactionResponseDto;
import com.hcl.ing.entity.Transaction;
import com.hcl.ing.exception.ExceptionById;
import com.hcl.ing.exception.InsufficientFundsException;

public interface TransferService {
	
	

	public TransactionResponseDto fundTransfor(TransactionRequestDto transactionrequest) throws InsufficientFundsException;

	public List<Transaction> getTransactions();

	public TransactionResponseDto getTransactionsByAccountId(int accountId) throws ExceptionById;
	
	
}
