package com.wipro.sbs.util;

public class ProductNotFoundException extends Exception{
	@Override
	public String toString() {
	    return "BillingOperationException: " + getMessage();
	}

}
