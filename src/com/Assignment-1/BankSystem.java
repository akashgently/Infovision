package com.assignment1;

import java.util.Scanner;

@FunctionalInterface
interface AccountCreator {
	public default void showBankName() {
		System.out.println("Welcome to ABC Bank");
	}
	public void create(String account_type, String name, String accNumber, String aadhar_number);
}

public class BankSystem {
 public static void main(String[] args) {
	 Account creator = new Account();
	 creator.showBankName();
	 Scanner scan =new Scanner(System.in);
	 System.out.println("Select 1 for current account and 2 for savings account :)");
	 String option = scan.nextLine();
	 if(option.equalsIgnoreCase("1")){
     System.out.println("Enter the account holder name: ");
	 String name = scan.nextLine();
	 System.out.println("Enter the PAN Number: ");
	 String pan = scan.nextLine();
	 System.out.println("Enter the Aadhar Number: ");
	 String aadhar = scan.nextLine();
	 creator.create("Current Account", name, pan, aadhar);
	 creator.openAccount();
	 creator.displayAccountDetails();
	 }else if(option.equalsIgnoreCase("2")){
	     System.out.println("Enter the account holder name: ");
		 String name = scan.nextLine();
		 System.out.println("Enter the PAN Number: ");
		 String pan = scan.nextLine();
		 System.out.println("Enter the Aadhar Number: ");
		 String aadhar = scan.nextLine();
		 creator.create("Savings Account", name, pan, aadhar);
		 creator.openAccount();
		 creator.displayAccountDetails();
		 }else {
			 System.out.println("Invalid Input");
			 scan.close();
		 }
 }
}

