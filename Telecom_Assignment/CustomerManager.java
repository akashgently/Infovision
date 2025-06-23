package com.Telecom_Assignment;

import java.util.*;

public class CustomerManager {
    private final Map<String, Customer> customerMap;

    public CustomerManager() {
        customerMap = new HashMap<>();
    }

    public void addCustomer(String id, String name) {
        if (customerMap.containsKey(id)) {
            System.out.println("Customer ID already exists.");
            return;
        }
        customerMap.put(id, new Customer(id, name));
        System.out.println("Customer " + name + " added successfully.");
    }

    public Customer getCustomer(String id) {
        return customerMap.get(id);
    }

    public void displayAll() {
        if (customerMap.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            customerMap.values().forEach(Customer::displaySummary);
        }
    }
}
