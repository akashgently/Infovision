package com.Day13;

import java.util.Vector;

class Customer{
    private int customerId;
    private String recordType;

    public Customer(int customerId, String recordType) {
        this.customerId = customerId;
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        return "\nCustomerId=" + customerId +
                ", recordType='" + recordType + '\'';
    }
}

public class Vector_Assignment {
    public static void main(String[] args) {
        Vector<Customer> customer_records = new Vector<>();
        customer_records.add(new Customer(1,"sms"));
        customer_records.add(new Customer(1,"call"));
        customer_records.add(new Customer(2,"sms"));
        customer_records.add(new Customer(3,"call"));
        customer_records.add(new Customer(1,"sms"));

        System.out.println(customer_records);

    }
}
