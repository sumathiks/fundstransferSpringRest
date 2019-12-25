package com.hcl.ing.util;

import java.util.Random;

public class FundTransferConstants {
	public static final String ACCOUNT_ADD_SUCCESS = "Account Added successfully";
	public static final String ACCOINTS_ARE_EMPTY = "Accounts are empty";
	public static final String CUST_BAL_NOT_EMPTY = "Customer balance should not empty!!!!";
	public static final String CUSTOMER_ADD_SUCCESSFULLY = "Customer Added successfully!!!!";
	public static final String NOT_ADD_ACCOUNT_SUCCESS = "Not  Added account successfully!!!";
	public static final String FUND_TRANSFER_SUCCESSFULL = "Fund transfer successfull";
	public static final String INSUFFICIENT_FUNDS = "Insufficient Funds";
	public static final String BOOK_BY_ID_FAILURE = "AccountId is null";
	
	
	public String random() {
		Random rand = new Random();
	    String card = "ING";
	    for (int i = 0; i < 14; i++)
	    {
	        int n = rand.nextInt(10) + 0;
	        card += Integer.toString(n);
	    }
	    return card;
	}

}
