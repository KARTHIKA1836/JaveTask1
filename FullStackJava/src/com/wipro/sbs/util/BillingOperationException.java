package com.wipro.sbs.util;

public class BillingOperationException extends Exception {

	@Override
	public String toString() {
		return "BillingOperationException :"+getMessage();
	}
     
}
