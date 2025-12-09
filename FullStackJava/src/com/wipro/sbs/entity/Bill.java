package com.wipro.sbs.entity;

import java.util.ArrayList;

public class Bill {
	private String billId;
	private ArrayList<BillItem> items;
	private double totalAmount;
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public ArrayList<BillItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<BillItem> items) {
		this.items = items;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Bill(String billId, ArrayList<BillItem> items, double totalAmount) {
		super();
		this.billId = billId;
		this.items = items;
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", items=" + items + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
