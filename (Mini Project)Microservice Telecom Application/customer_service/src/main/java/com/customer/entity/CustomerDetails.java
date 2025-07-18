package com.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CustomerDetails {
    private Customer customer;
    private Recharge recharge;
    private PlanDto plan; // optional

    // Constructor with plan
    public CustomerDetails(Customer customer, Recharge recharge, PlanDto plan) {
        this.customer = customer;
        this.recharge = recharge;
        this.plan = plan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Recharge getRecharge() {
        return recharge;
    }

    public void setRecharge(Recharge recharge) {
        this.recharge = recharge;
    }

    public PlanDto getPlan() {
        return plan;
    }

    public void setPlan(PlanDto plan) {
        this.plan = plan;
    }

    // Or constructor without plan, if you don't want plan here
    public CustomerDetails(Customer customer, Recharge recharge) {
        this.customer = customer;
        this.recharge = recharge;
    }

    // getters/setters
}
