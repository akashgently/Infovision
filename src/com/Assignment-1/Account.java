package com.assignment1;

public class Account extends BankAccount implements AccountCreator{

	 @Override
	 public void openAccount() {
	     System.out.println("Account opened for " + accountHolderName);
	 }

	 @Override
	 public void displayAccountDetails() {
	     System.out.println("Account Type: "+account_type+", Account Holder Name: " + accountHolderName + ", PAN No: " + pan_number + ", Aadhar No: " + aadhar_number);
	 }

	@Override
	public void create(String account_type, String name, String pan_number, String aadhar_number) {
		this.account_type=account_type;
		this.accountHolderName = name;
	    this.pan_number = pan_number;
	    this.aadhar_number = aadhar_number;
	}
	}
