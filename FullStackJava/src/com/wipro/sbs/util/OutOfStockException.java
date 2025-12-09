package com.wipro.sbs.util;

public class OutOfStockException extends Exception{
	@Override
	public String toString() {
	    return "OutOfStockException: " + getMessage();
	}

}
