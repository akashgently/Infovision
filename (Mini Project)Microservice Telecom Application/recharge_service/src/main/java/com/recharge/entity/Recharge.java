package com.recharge.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recharge {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long planId;
    private LocalDateTime rechargeDate;

    @Override
    public String toString() {
        return "Recharge{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", planId=" + planId +
                ", rechargeDate=" + rechargeDate +
                '}';
    }

    public Recharge() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPlanId() {
        return planId;
    }


    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public LocalDateTime getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(LocalDateTime rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public Recharge(Long id, Long customerId, Long planId, LocalDateTime rechargeDate) {
        this.id = id;
        this.customerId = customerId;
        this.planId = planId;
        this.rechargeDate = rechargeDate;
    }
}

