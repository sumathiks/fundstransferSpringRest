package com.hcl.ing.dto;

public class AccountRequestDto {
	
	private String accountName;
	private String ifscCode;
	private long balance;
	private String accountType;
	private String accountNo;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "AccountRequestDto [accountName=" + accountName + ", ifscCode=" + ifscCode + ", balance=" + balance
				+ ", accountType=" + accountType + ", accountNo=" + accountNo + "]";
	}
	
	
	
	
	

}
