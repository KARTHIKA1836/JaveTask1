package com.wipro.sbs.service;
import java.util.ArrayList;
import java.util.HashMap;


import com.wipro.sbs.entity.Bill;
import com.wipro.sbs.entity.BillItem;
import com.wipro.sbs.entity.Product;
import com.wipro.sbs.util.BillNotFoundException;
import com.wipro.sbs.util.BillingOperationException;
import com.wipro.sbs.util.OutOfStockException;
import com.wipro.sbs.util.ProductNotFoundException;

public class SupermarketBillingService {
	private ArrayList<Product> products;
	private ArrayList<Bill> bills;
	private HashMap<String, Integer> stockMap = new HashMap<>();
	private static int counter = 1000;
	
	public SupermarketBillingService(ArrayList<Product> products, ArrayList<Bill> bills) {
		super();
		this.products = products;
		this.bills = bills;
	}
	
	public Product findProduct(String productId) throws ProductNotFoundException{
		for(Product p: products) {
			if(p.getProductId().equals(productId));
			return p;
		}
		throw new ProductNotFoundException();
	}
	public void checkStock(String productId, int quantity) throws OutOfStockException{

	    int available = stockMap.get(productId);

	    if (available < quantity) {
	        throw new OutOfStockException();
	    }
	}
	public Bill generateBill(ArrayList<BillItem> items) throws BillingOperationException {
		

		 if (items == null || items.isEmpty()) {
	            throw new BillingOperationException();
	        }

	        // Product validation only
	        for (BillItem item : items) {
	            try {
	                findProduct(item.getProductId());
	            } catch (Exception e) {
	                throw new BillingOperationException();
	            }
	        }

	        double total = calculateTotal(items);
	        String billId = "B"+ (counter++);

	        Bill bill = new Bill(billId, items, total);
	        bills.add(bill);

	        return bill;
	    }


	private double calculateTotal(ArrayList<BillItem> items) {
		 double sum = 0;
	        for (BillItem item : items) {
	            try {
	                Product p = findProduct(item.getProductId());
	                sum += item.getQuantity() * p.getPrice();
	            } catch (ProductNotFoundException e) {
	            }
	        }
	        return sum;
	}
	public void cancelBill(String billId) throws BillNotFoundException{
		Bill billId1 = null;

        for (Bill b : bills) {
            if (b.getBillId().equals(billId1)) {
                billId1 = b;
                break;
            }
        }
        if (billId1 == null) {
            throw new BillNotFoundException();
        }
        bills.remove(billId1);
	}
	public void printBillDetails(String billId) throws BillNotFoundException{
		for (Bill b : bills) {
            if (b.getBillId().equals(billId)) {
                System.out.println("BILL DETAILS");
                System.out.println("Bill ID: " + b.getBillId());
                System.out.println("Items:");

                for (BillItem item : b.getItems()) {
                    try {
                        Product p = findProduct(item.getProductId());
                        System.out.println(p.toString());
                    } catch (ProductNotFoundException e) {
                        System.out.println("Product Unavailable");
                    }
                }

                System.out.println("Total: " + b.getTotalAmount());
                return;
            }
        }

        throw new BillNotFoundException();
	}
	public void displayAllBills() {
		for (Bill b : bills) {
            System.out.println("Bill ID: " + b.getBillId() + " Total: " + b.getTotalAmount());
        }
	}
}
