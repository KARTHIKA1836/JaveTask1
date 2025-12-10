package com.wipro.sbs.util;

public class BillNotFoundException extends Exception{
	public BillNotFoundException() {
        super();
    }
    public BillNotFoundException(String message) {
        super(message);
    }
	@Override
	public String toString() {
	    return "BillNotFoundException: " + getMessage();
	}
}
