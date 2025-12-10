package com.wipro.sbs.util;

public class ProductNotFoundException extends Exception{
	public ProductNotFoundException() {
        super();
    }
    public ProductNotFoundException(String message) {
        super(message);
    }
	@Override
	public String toString() {
	    return "BillingOperationException: " + getMessage();
	}

}
