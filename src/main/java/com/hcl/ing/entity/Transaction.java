package com.hcl.ing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private String transactionTime;
	private long transationAmount;
	
	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String string) {
		this.transactionTime = string;
	}

	@OneToOne
	@JoinColumn(name = "accountId",nullable=false)
	private Account account;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	
	public long getTransationAmount() {
		return transationAmount;
	}

	public void setTransationAmount(long transationAmount) {
		this.transationAmount = transationAmount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionTime=" + transactionTime
				+ ", transationAmount=" + transationAmount + ", account=" + account + "]";
	}
	
	
	

}
