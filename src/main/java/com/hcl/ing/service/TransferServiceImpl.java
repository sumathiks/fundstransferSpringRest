package com.hcl.ing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.dao.TransferDao;
import com.hcl.ing.dto.TransactionRequestDto;
import com.hcl.ing.dto.TransactionResponseDto;
import com.hcl.ing.entity.Transaction;
import com.hcl.ing.exception.ExceptionById;
import com.hcl.ing.exception.InsufficientFundsException;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	TransferDao transferDao;


	public TransactionResponseDto fundTransfor(TransactionRequestDto transactionrequest) throws InsufficientFundsException{
		return transferDao.fundTranfer(transactionrequest);
	}


	public List<Transaction> getTransactions() {
		return transferDao.getTransactions();
	}


	public TransactionResponseDto getTransactionsByAccountId(int accountId) throws ExceptionById {
		
		return transferDao.getTransactionsByAccountId(accountId);
	}

}
