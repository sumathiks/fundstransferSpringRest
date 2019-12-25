package com.hcl.ing.dto;

public class CustomerRequestDto {
	
	private String customerName;
	private String ifscCode;
	private long balance;
	private String accountType;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
		return "CustomerRequestDto [customerName=" + customerName + ", ifscCode=" + ifscCode + ", balance=" + balance
				+ ", accountType=" + accountType + "]";
	}
	
	
	
	
	

}
