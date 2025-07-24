package com.Telecom_Assignment;

import java.time.LocalDateTime;

public class Call {
    private String phoneNumber;
    private int duration;
    private LocalDateTime timestamp;

    public Call(String phoneNumber, int duration) {
        this.phoneNumber = phoneNumber;
        this.duration = duration;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Call to: " + phoneNumber + ", Duration: " + duration + "s, Time: " + timestamp;
    }
}
