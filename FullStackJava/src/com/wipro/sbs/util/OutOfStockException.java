package com.wipro.sbs.util;

public class OutOfStockException extends Exception{
	public OutOfStockException() {
        super();
    }
    public OutOfStockException(String message) {
        super(message);
    }
	@Override
	public String toString() {
	    return "OutOfStockException: " + getMessage();
	}

}
