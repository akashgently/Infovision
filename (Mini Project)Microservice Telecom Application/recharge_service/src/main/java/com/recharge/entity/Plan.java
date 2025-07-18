package com.recharge.entity;

import javax.persistence.Embeddable;

public class Plan {
    private Long id;

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", validity=" + validity +
                '}';
    }

    private String name;
    private String type;
    private Double price;
    private Integer validity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public Plan(Long id, String name, String type, Double price, Integer validity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.validity = validity;
    }
    public Plan(){

    }
}


