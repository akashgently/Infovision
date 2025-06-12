package com.Assignment2;

abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected String mobileNumber;
    protected double balance;

    public BankAccount(String accountHolderName, String mobileNumber, double initialDeposit) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.mobileNumber = mobileNumber;
        this.balance = initialDeposit;
    }

    public abstract void openAccount();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Balance: Rs." + balance);
    }

    private String generateAccountNumber() {
        return "AC" + (int)(Math.random() * 1000000);
    }

    public abstract void withdraw(double amount);
}

class SavingAccount extends BankAccount {
    private static final double MIN_DEPOSIT = 1000;
    private static final double INTEREST_RATE = 0.04; 

    public SavingAccount(String accountHolderName, String mobileNumber, double initialDeposit) {
        super(accountHolderName, mobileNumber, initialDeposit);
    }

    @Override
    public void openAccount() {
        if (balance >= MIN_DEPOSIT) {
            System.out.println("Saving Account Opened Successfully!");
        } else {
            System.out.println("Minimum deposit of Rs.1000 required for Saving Account.");
        }
    }

    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance && amount <= 3) {  
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " successful.");
        } else {
            System.out.println("Withdrawal limit exceeded or insufficient balance.");
        }
    }
}

class CurrentAccount extends BankAccount {
    private static final double MIN_DEPOSIT = 5000;
    private static final double MIN_BALANCE = 2000;
    private static final double PENALTY = 500;

    public CurrentAccount(String accountHolderName, String mobileNumber, double initialDeposit) {
        super(accountHolderName, mobileNumber, initialDeposit);
    }

    @Override
    public void openAccount() {
        if (balance >= MIN_DEPOSIT) {
            System.out.println("Current Account Opened Successfully!");
        } else {
            System.out.println("Minimum deposit of Rs.5000 required for Current Account.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " successful.");
        } else {
            balance -= PENALTY;
            System.out.println("Minimum balance not maintained. Penalty of Rs.500 applied.");
        }
    }
}