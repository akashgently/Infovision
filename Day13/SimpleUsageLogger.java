package com.Day13;

import java.util.*;

class UsageRecord {
    int customerId;
    String type;

    UsageRecord(int customerId, String type) {
        this.customerId = customerId;
        this.type = type;
    }

    public String toString() {
        return "CustomerID: " + customerId + ", Type: " + type;
    }
}

public class SimpleUsageLogger {
    static Vector<UsageRecord> usageRecords = new Vector<>();

    static class LoggerThread extends Thread {
        int customerId;

        LoggerThread(int customerId) {
            this.customerId = customerId;
        }

        public void run() {
            String[] types = {"call", "sms", "data"};
            for (int i = 0; i < 5; i++) {
                String type = types[new Random().nextInt(types.length)];
                usageRecords.add(new UsageRecord(customerId, type));
                System.out.println("CustomerID: " + customerId + ", Type: " + type);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new LoggerThread(1);
        Thread t2 = new LoggerThread(2);
        Thread t3 = new LoggerThread(3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll Usage Records:");
        for (UsageRecord record : usageRecords) {
            System.out.println(record);
        }
    }
}

