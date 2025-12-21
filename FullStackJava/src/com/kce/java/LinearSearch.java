package com.kce.java;


import java.util.Scanner;

public class LinearSearch {
	public static int search(int[] a,int key) {
	   	
   		for(int i=0;i<a.length;i++) {
   			if(a[i]==key) {
   				return i;
   			}
   		}
   		
   		return -1;
   	}
	
    public static void main(String args[]) {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter n : ");
    	int n=s.nextInt();
    	int[] a=new int[n];
    	System.out.println("Enter element : ");
    	for(int i=0;i<n;i++) {
    		a[i]=s.nextInt();
    		}
    	System.out.println("Enter key :");
    	int key=s.nextInt();
     
        
       int res=search(a,key);
       if(res!=-1) {
       System.out.println(res);
       }else {
    	   System.out.println("Key not found");
       }
       s.close();
    }
}
