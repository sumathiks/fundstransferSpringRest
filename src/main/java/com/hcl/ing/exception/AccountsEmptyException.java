package com.hcl.ing.exception;

public class AccountsEmptyException extends Exception {
	private static final long serialVersionUID = 1L;
	public AccountsEmptyException(String message) {
		super(message);
	}
}
