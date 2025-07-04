package com.Day16;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime date;

    public Transaction(String type, double amount, LocalDateTime date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return type + " of ₹" + amount + " on " + date;
    }

    public double getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDateTime getDate() { return date; }
}
