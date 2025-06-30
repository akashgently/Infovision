package com.Telecom_Customer_Call_Assignment;

import java.time.LocalDateTime;

public class CallRecord {
    private String caller;
    private String receiver;
    private int duration; // in seconds
    private String location;
    private String operator;
    private LocalDateTime timestamp;

    public CallRecord(String caller, String receiver, int duration, String location, String operator, LocalDateTime timestamp) {
        this.caller = caller;
        this.receiver = receiver;
        this.duration = duration;
        this.location = location;
        this.operator = operator;
        this.timestamp = timestamp;
    }

    public String getCaller() { return caller; }
    public String getReceiver() { return receiver; }
    public int getDuration() { return duration; }
    public String getLocation() { return location; }
    public String getOperator() { return operator; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("Caller: %s, Receiver: %s, Duration: %ds, Location: %s, Operator: %s, Time: %s",
                caller, receiver, duration, location, operator, timestamp);
    }
}

