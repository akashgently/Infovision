package com.Day20;
import java.util.*;

public class CustomerService {
    private Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getPhoneNumber(), customer);
    }

    public void updateCustomer(String phone, String newName) {
        Customer c = customers.get(phone);
        if (c != null) c.setName(newName);
    }

    public void deleteCustomer(String phone) {
        customers.remove(phone);
    }

    public void activatePlan(String phone, String planType) {
        Customer c = customers.get(phone);
        if (c != null) c.setPlan(PlanFactory.getPlan(planType));
    }

    public Customer getCustomer(String phone) {
        return customers.get(phone);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}

