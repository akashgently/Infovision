package com.Day20;

public class PlanFactory {
    public static Plan getPlan(String type) {
        switch (type.toLowerCase()) {
            case "prepaid": return new PrepaidPlan();
            case "postpaid": return new PostpaidPlan();
            default: throw new IllegalArgumentException("Invalid Plan Type");
        }
    }
}

