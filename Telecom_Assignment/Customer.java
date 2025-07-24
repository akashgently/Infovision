package com.Telecom_Assignment;

import java.util.*;

public class Customer implements ServiceSubscriber, ComplaintHandler {
    private final String customerId;
    private final String name;

    private final List<Call> callHistory;
    private final Set<String> subscribedVAS;
    private final List<Complaint> complaints;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.callHistory = new ArrayList<>();
        this.subscribedVAS = new HashSet<>();
        this.complaints = new ArrayList<>();
    }

    public void makeCall(String number, int duration) {
        callHistory.add(new Call(number, duration));
    }

    @Override
    public void subscribeVAS(String service) {
        if (subscribedVAS.add(service)) {
            System.out.println(service + " has been subscribed.");
        } else {
            System.out.println(service + " is already active.");
        }
    }

    @Override
    public void unsubscribeVAS(String service) {
        if (subscribedVAS.remove(service)) {
            System.out.println(service + " has been unsubscribed.");
        } else {
            System.out.println(service + " is not subscribed.");
        }
    }

    @Override
    public void fileComplaint(String description) {
        complaints.add(new Complaint(description));
    }

    @Override
    public void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints filed.");
        } else {
            complaints.forEach(System.out::println);
        }
    }

    public void displaySummary() {
        System.out.println("Customer ID: " + customerId + ", Name: " + name);
        System.out.println("VAS: " + (subscribedVAS.isEmpty() ? "None" : subscribedVAS));
        System.out.println("Call History:");
        if (callHistory.isEmpty()) {
            System.out.println("  No calls made.");
        } else {
            callHistory.forEach(call -> System.out.println("  " + call));
        }
        System.out.println("Complaints:");
        viewComplaints();
        System.out.println("------------------------------");
    }

    public String getCustomerId() {
        return customerId;
    }
}

