package com.Assignment2;

public class BankAccountSystem {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("Akash Gently", "9876543210", 1500);
        savingAccount.openAccount();
        savingAccount.displayAccountDetails();
        System.out.println("Interest: Rs." + savingAccount.calculateInterest());
        savingAccount.withdraw(500); 
        savingAccount.displayAccountDetails();

        CurrentAccount currentAccount = new CurrentAccount("Samuel", "9123456789", 6000);
        currentAccount.openAccount();
        currentAccount.displayAccountDetails();
        currentAccount.withdraw(1000); 
        currentAccount.displayAccountDetails();
    }
}
