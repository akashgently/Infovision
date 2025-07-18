package com.customer.entity;

public class RechargeHistoryDto{
    public Recharge getRecharge() {
        return recharge;
    }

    @Override
    public String toString() {
        return "RechargeHistoryDto{" +
                "recharge=" + recharge +
                ", plan=" + plan +
                '}';
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

    private Recharge recharge;
    private PlanDto plan;
}
