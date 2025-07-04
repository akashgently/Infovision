package com.Day16;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount, LocalDateTime.now()));
    }

    public void withdraw(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient Balance");
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount, LocalDateTime.now()));
    }

    public Stream<Transaction> getTransactionStream() {
        return transactions.stream();
    }

    public double getBalance() {
        return balance;
    }
}
