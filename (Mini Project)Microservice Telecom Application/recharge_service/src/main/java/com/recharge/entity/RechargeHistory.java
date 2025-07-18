package com.recharge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RechargeHistory {
      private Recharge recharge;
      private Plan plan;

    @Override
    public String toString() {
        return "RechargeHistory{" +
                "recharge=" + recharge +
                ", plan=" + plan +
                '}';
    }

    public Recharge getRecharge() {
        return recharge;
    }

    public void setRecharge(Recharge recharge) {
        this.recharge = recharge;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public RechargeHistory(Recharge recharge, Plan plan) {
        this.plan = plan;
        this.recharge = recharge;
    }

    public RechargeHistory(){

    }
}
