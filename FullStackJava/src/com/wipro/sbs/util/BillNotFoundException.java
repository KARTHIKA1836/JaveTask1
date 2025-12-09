package com.wipro.sbs.util;

public class BillNotFoundException extends Exception{
	@Override
	public String toString() {
	    return "BillNotFoundException: " + getMessage();
	}
}
