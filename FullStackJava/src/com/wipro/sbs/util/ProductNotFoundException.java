package com.wipro.sbs.util;

public class ProductNotFoundException extends Exception{
	
    public ProductNotFoundException(String message) {
        super(message);
    }
	@Override
	public String toString() {
	    return "ProductNotFoundException: " + getMessage();
	}

}
