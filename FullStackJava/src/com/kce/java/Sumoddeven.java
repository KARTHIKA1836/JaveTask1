package com.kce.java;

import java.util.Scanner;

public class Sumoddeven {
       public static void main(String args[]) {
    	   try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter size of Array");
			   int n = s.nextInt();
			   int[] a=new int[n];
			   for(int i=0;i<n;i++) {
				   a[i]=s.nextInt();
			   }
			   int even=0;
			   int odd=0;
			   for(int j=0;j<n;j++) {
				   if(j%2==0) {
					   even=even+a[j];
				   }
				   else {
					   odd=odd+a[j];
				   }
			   }
			   System.out.printf("Sum of alternative digit is :",even-odd);
		}
       }
}
