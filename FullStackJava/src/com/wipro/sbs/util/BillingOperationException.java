package com.wipro.sbs.util;

public class BillingOperationException extends Exception {
	
    public BillingOperationException(String message) {
        super(message);
    }
	@Override
	public String toString() {
		return "BillingOperationException :"+getMessage();
	}
     
}
