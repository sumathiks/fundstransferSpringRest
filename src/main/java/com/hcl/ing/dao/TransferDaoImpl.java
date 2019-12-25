package com.hcl.ing.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.ing.dto.TransactionRequestDto;
import com.hcl.ing.dto.TransactionResponseDto;
import com.hcl.ing.entity.Account;
import com.hcl.ing.entity.Transaction;
import com.hcl.ing.exception.ExceptionById;
import com.hcl.ing.exception.InsufficientFundsException;
import com.hcl.ing.util.FundTransferConstants;

@Repository
public class TransferDaoImpl implements TransferDao {

	@Autowired
	private SessionFactory sessionFactory;


	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public TransactionResponseDto fundTranfer(TransactionRequestDto transactionrequest) throws InsufficientFundsException{
		TransactionResponseDto transactionResponseDto=new TransactionResponseDto();
		List<Account> accounts = getSession().createCriteria(Account.class).list();
		accounts.get(0).getCustomer().getCustomerId();
		accounts.get(0).getAccountNo();
		Account account=new Account();
		BeanUtils.copyProperties(transactionrequest, account);
		if(accounts.get(0).getBalance()>accounts.get(1).getBalance()) {
			
			long srcAccntBal=accounts.get(0).getBalance();
			long desstAccntBal=accounts.get(1).getBalance();
			
			srcAccntBal=srcAccntBal-transactionrequest.getTransationAmount();
			desstAccntBal=desstAccntBal+transactionrequest.getTransationAmount();
			
			account=accounts.get(0);
			account.setBalance(srcAccntBal);
			Account accountDest = accounts.get(1);
			accountDest.setBalance(desstAccntBal);
			getSession().save(account);
			getSession().save(accountDest);
			Transaction transaction=new Transaction();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			if(transactionrequest.getTransactionTime()==null) {
		    transaction.setTransactionTime(dtf.format(now));
			}else {
				transaction.setTransactionTime(transactionrequest.getTransactionTime().toString());
			}
			BeanUtils.copyProperties(transactionrequest, transaction);
			transaction.setAccount(account);
			getSession().save(transaction);
			
			transactionResponseDto.setMessage(FundTransferConstants.FUND_TRANSFER_SUCCESSFULL);
			transactionResponseDto.setStatusCode(HttpStatus.CREATED.value());
			}		else {
				throw new InsufficientFundsException(FundTransferConstants.INSUFFICIENT_FUNDS);
			}
		
		return transactionResponseDto;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactions() {
		List<Transaction> transaction = getSession().createCriteria(Transaction.class).list();
		return transaction;
	}

	public TransactionResponseDto getTransactionsByAccountId(int accountId) throws ExceptionById {
		TransactionResponseDto transactionResponseDto=new TransactionResponseDto();
		if (accountId == 0) {
			throw new ExceptionById(FundTransferConstants.BOOK_BY_ID_FAILURE);
		}
		Transaction transactionResp =  (Transaction) getSession().get(Transaction.class, accountId);
		transactionResponseDto.setMessage("Transactions by accountId"+transactionResp.getTransactionId());
		transactionResponseDto.setStatusCode(HttpStatus.OK.value());
		return transactionResponseDto;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public TransactionResponseDto fundTranferByFrmAccToAcc(String fromAcc,String toAcc,long tramt) throws InsufficientFundsException{
		TransactionResponseDto transactionResponseDto=new TransactionResponseDto();
		List<Account> accounts = getSession().createCriteria(Account.class).list();
		
		accounts.get(0).getCustomer().getCustomerId();
		accounts.get(0).getAccountNo();
		Account account=new Account();
		if(accounts.get(0).getBalance()>accounts.get(1).getBalance()) {
			
			long srcAccntBal=accounts.get(0).getBalance();
			long desstAccntBal=accounts.get(1).getBalance();
			
			srcAccntBal=srcAccntBal-tramt;
			desstAccntBal=desstAccntBal+tramt;
			
			account=accounts.get(0);
			account.setBalance(srcAccntBal);
			Account accountDest = accounts.get(1);
			accountDest.setBalance(desstAccntBal);
			getSession().save(account);
			getSession().save(accountDest);
			Transaction transaction=new Transaction();
			//transaction.setTransactionTime(new Date(12, 05, 1988));
			transaction.setAccount(account);
			getSession().save(transaction);
			
			transactionResponseDto.setMessage(FundTransferConstants.FUND_TRANSFER_SUCCESSFULL);
			transactionResponseDto.setStatusCode(HttpStatus.CREATED.value());
			}		else {
				throw new InsufficientFundsException(FundTransferConstants.INSUFFICIENT_FUNDS);
			}
		
		return transactionResponseDto;
	}

}