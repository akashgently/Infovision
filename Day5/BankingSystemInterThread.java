package com.Day5;

//inter thread communication // wait() , notify(),notifyAll()
class BankAccount {
 private int balance = 0;

 // Method to withdraw money
 synchronized void withdraw(int amount) {
     System.out.println("Trying to withdraw ₹" + amount);
     while (balance < amount) {
         System.out.println("Insufficient balance. Waiting for deposit...");
         try {
             wait(); // wait until deposit is made
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
     balance -= amount;
     System.out.println("Withdrawal of ₹" + amount + " successful. Remaining balance: ₹" + balance);
 }

 // Method to deposit money
 synchronized void deposit(int amount) {
     System.out.println("Depositing ₹" + amount);
     balance += amount;
     System.out.println("Deposit of ₹" + amount + " successful. Current balance: ₹" + balance);
     notify(); // notify the waiting withdrawal thread
 }
}

class WithdrawThread extends Thread {
 BankAccount account;

 WithdrawThread(BankAccount account) {
     this.account = account;
 }

 public void run() {
	 try {
         Thread.sleep(2000); // Simulate delay in deposit
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     account.withdraw(1000);
 }
}

class DepositThread extends Thread {
 BankAccount account;

 DepositThread(BankAccount account) {
     this.account = account;
 }

 public void run() {
     account.deposit(2000);
 }
}

public class BankingSystemInterThread {
 public static void main(String[] args) throws InterruptedException {
     BankAccount account = new BankAccount();

     // Start withdrawal and deposit threads
     WithdrawThread wt = new WithdrawThread(account);
     DepositThread dt = new DepositThread(account);

     dt.start();
     dt.join();
     System.out.println("Before Starting: " +wt.isAlive());
     wt.start();
     System.out.println("After Starting: "+wt.isAlive());
     
 }
}