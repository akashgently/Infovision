package com.Day1;

import java.util.Scanner;

public class ATMWithdrawal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double balance = 2000.0;
		System.out.println("Welcome to InfoVision Bank ATM");
		System.out.println("Do you want to make transaction? (yes/no):");
		String choice = scan.nextLine();
		while(choice.equalsIgnoreCase("yes")) {
			System.out.println("Enter the amount to withdraw:");
			double amount = scan.nextDouble();
			if(amount>0 && amount<balance) {
				System.out.println("Transaction Successful");
				balance-=amount;
			}else {
				System.out.println("Transaction Failed");
			}
		}
		System.out.println("Thank you!");
		scan.close();
	}
 
}
