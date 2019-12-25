package com.hcl.ing.dao;

import java.util.List;

import com.hcl.ing.dto.TransactionRequestDto;
import com.hcl.ing.dto.TransactionResponseDto;
import com.hcl.ing.entity.Transaction;
import com.hcl.ing.exception.ExceptionById;
import com.hcl.ing.exception.InsufficientFundsException;

public interface TransferDao {
	

	public TransactionResponseDto fundTranfer(TransactionRequestDto transactionrequest) throws InsufficientFundsException;

	public List<Transaction> getTransactions();

	public TransactionResponseDto getTransactionsByAccountId(int accountId) throws ExceptionById;

	
}
