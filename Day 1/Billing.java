package com.Day1;

import java.util.Scanner;

public class Billing {
	
	static int gst=18;
	
	public double bill_amount(double amount) {
		if(amount<1000) {
		double sum = (amount*gst)/100;
		return amount+sum;
		}else if(amount>1000) {
			return amount;
		}
		return amount;
	}
	
	public static void gst() {
		System.out.println(gst + " %");
	}
	
	public static void main(String[] args) {
		Billing.gst();
		Billing bill =new Billing();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount:");
		double n = sc.nextDouble();
		double result = bill.bill_amount(n);
		System.out.println("Rs. "+result);
		
	}

}
