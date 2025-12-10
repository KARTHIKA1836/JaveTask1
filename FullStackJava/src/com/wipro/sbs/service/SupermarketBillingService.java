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
	private static int counter = 1000;
	
	public SupermarketBillingService(ArrayList<Product> products, ArrayList<Bill> bills) {
		super();
		this.products = products;
		this.bills = bills;
	}
	public Product findProduct(String productId) throws ProductNotFoundException{
		if (productId == null) {
            throw new ProductNotFoundException("Product id is null");
        }
		for(Product p: products) {
			if(p.getProductId().equals(productId));
			return p;
		}
		throw new ProductNotFoundException("Product id '" + productId + "' not found");
	}
	public void checkStock(String productId, int quantity) throws OutOfStockException, ProductNotFoundException{

		Product p = findProduct(productId);
        if (quantity <= 0) {
            throw new OutOfStockException("Requested quantity must be greater than zero");
        }
        if (p.getStock() < quantity) {
            throw new OutOfStockException("Product '" + p.getProductName() + "' has insufficient stock. Available: "
                    + p.getStock() + ", Requested: " + quantity);
        }
	}
	public Bill generateBill(ArrayList<BillItem> items) throws BillingOperationException, OutOfStockException, ProductNotFoundException {
		if (items == null || items.isEmpty()) {
			throw new BillingOperationException();
	        }
	       for (BillItem item : items) {
	            if (item == null) {
	                throw new BillingOperationException("Bill contains null item");
	            }
	            if (item.getQuantity() <= 0) {
	                throw new BillingOperationException("Quantity must be greater than zero for productId: " + item.getProductId());
	            }
	            checkStock(item.getProductId(), item.getQuantity()); // may throw ProductNotFoundException or OutOfStockException
	        }

	        // Deduct stock
	        for (BillItem item : items) {
	            Product p = findProduct(item.getProductId());
	            int newStock = p.getStock() - item.getQuantity();
	            p.setStock(newStock);
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
        if (billId == null) {
            throw new BillNotFoundException("Bill id '" + billId + "' not found");
        }

        bills.remove(billId1);
	}
	public void printBillDetails(String billId) throws BillNotFoundException, ProductNotFoundException{
		for (Bill b : bills) {
            if (b.getBillId().equals(billId)) {
                System.out.println("BILL DETAILS");
                System.out.println("Bill ID: " + b.getBillId());
                System.out.println("Items:");
                
                for (BillItem item : b.getItems()) {
                    Product p = findProduct(item.getProductId());
                    double amount = p.getPrice() * item.getQuantity();

                    System.out.println(p.getProductId()+""+p.getProductName()+""+
                            item.getQuantity()+""+
                            amount);
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
