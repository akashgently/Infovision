package com.Day16;

public class Customer {
    private String id;
    private String name;
    private Account account;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.account = new Account(id);
    }

    public Account getAccount() {
        return account;
    }

    
}
