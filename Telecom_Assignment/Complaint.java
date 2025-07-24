package com.Telecom_Assignment;

import java.time.LocalDateTime;

public class Complaint {
    private static int complaintCounter = 1000;
    private final int complaintId;
    private final String description;
    private final LocalDateTime createdAt;

    public Complaint(String description) {
        this.complaintId = complaintCounter++;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Complaint #" + complaintId + ": " + description + " (Filed on: " + createdAt + ")";
    }
}

