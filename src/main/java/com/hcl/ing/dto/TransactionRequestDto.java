package com.hcl.ing.dto;

import java.util.Date;

public class TransactionRequestDto {
	
	private Date transactionTime;
	private long transationAmount;
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public long getTransationAmount() {
		return transationAmount;
	}
	public void setTransationAmount(long transationAmount) {
		this.transationAmount = transationAmount;
	}
	@Override
	public String toString() {
		return "TransactionRequestDto [transactionTime=" + transactionTime + ", transationAmount=" + transationAmount
				+ "]";
	}
	
	
	
	
	

}
