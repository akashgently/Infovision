package com.Day20;

import java.util.List;

public class BillingEngine {
    private static BillingEngine instance;

    private BillingEngine() {}

    public static synchronized BillingEngine getInstance() {
        if (instance == null) instance = new BillingEngine();
        return instance;
    }

    public void generateBills(CustomerService customerService, CallManager callManager) {
        for (Customer customer : customerService.getAllCustomers()) {
            List<CallLog> logs = callManager.getCallLogs(customer.getPhoneNumber());
            double total = 0;
            for (CallLog log : logs) {
                long duration = log.getDurationInMinutes();
                total += duration * customer.getPlan().getRatePerMinute();
            }
            System.out.println("BILL for " + customer.getName() + ": $" + total);
        }
    }
}

