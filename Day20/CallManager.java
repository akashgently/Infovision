package com.Day20;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

public class CallManager {
    private static CallManager instance;
    private Map<String, List<CallLog>> callLogs = new ConcurrentHashMap<>();

    private CallManager() {}

    public static synchronized CallManager getInstance() {
        if (instance == null) instance = new CallManager();
        return instance;
    }

    public void simulateCall(String caller, String receiver, int durationInSeconds) {
        new Thread(() -> {
            LocalDateTime start = LocalDateTime.now();
            try {
                Thread.sleep(durationInSeconds * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LocalDateTime end = LocalDateTime.now();

            CallLog log = new CallLog(caller, receiver, start, end);
            callLogs.computeIfAbsent(caller, k -> new ArrayList<>()).add(log);
        }).start();
    }

    public List<CallLog> getCallLogs(String phoneNumber) {
        return callLogs.getOrDefault(phoneNumber, new ArrayList<>());
    }

    public Map<String, List<CallLog>> getAllLogs() {
        return callLogs;
    }
}

