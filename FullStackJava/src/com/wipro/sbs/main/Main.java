package com.wipro.sbs.main;

import java.util.ArrayList; 
import com.wipro.sbs.entity.*;
import com.wipro.sbs.service.SupermarketBillingService; 
import com.wipro.sbs.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
 
        ArrayList<Product> products = new ArrayList<Product>(); 
        products.add(new Product("P001", "Bread", 45.0,45)); 
        products.add(new Product("P002", "Milk", 35.0,56)); 
        products.add(new Product("P003", "Eggs (Pack of 6)", 60.0,25)); 
 
        ArrayList<Bill> bills = new ArrayList<>(); 
 
        SupermarketBillingService service = new SupermarketBillingService(products, bills); 
 
        try { 
            ArrayList<BillItem> items = new ArrayList<>(); 
            items.add(new BillItem("P001", 2)); 
            items.add(new BillItem("P003", 1)); 
 
            Bill bill = service.generateBill(items); 
            System.out.println("Bill Generated: " + bill.getBillId()); 
            service.printBillDetails(bill.getBillId()); 
 
            System.out.println("\n--- Cancelling Bill ---"); 
            service.cancelBill(bill.getBillId()); 
            System.out.println("Bill cancelled successfully!"); 
 
            System.out.println("\n--- All Bills ---"); 
            service.displayAllBills(); 
 
        } catch (BillNotFoundException 
        		| BillingOperationException e) {
            System.out.println(e.getMessage());
        }

        catch (Exception ex) { 
            System.out.println("Unexpected Error: " + ex); 
        } 
    } 
} 
