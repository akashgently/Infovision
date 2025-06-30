package com.Telecom_Customer_Call_Assignment;
import java.util.*;
import java.util.stream.Collectors;

public class CallService {
    private final List<CallRecord> records = new ArrayList<>();

    public void addCall(CallRecord record) {
        records.add(record);
    }

    public List<CallRecord> getAllCalls() {
        return new ArrayList<>(records);
    }

    public List<CallRecord> filterByMinDuration(int minSeconds) {
        return records.stream()
                .filter(r -> r.getDuration() >= minSeconds)
                .collect(Collectors.toList());
    }

    public List<CallRecord> sortByDurationDesc() {
        return records.stream()
                .sorted(Comparator.comparingInt(CallRecord::getDuration).reversed())
                .collect(Collectors.toList());
    }

    public Map<String, Long> getCallCountPerCaller() {
        return records.stream()
                .collect(Collectors.groupingBy(CallRecord::getCaller, Collectors.counting()));
    }

    public Map<String, List<CallRecord>> groupByOperator() {
        return records.stream()
                .collect(Collectors.groupingBy(CallRecord::getOperator));
    }

    public Map<String, List<CallRecord>> groupByLocation() {
        return records.stream()
                .collect(Collectors.groupingBy(CallRecord::getLocation));
    }

    public Optional<CallRecord> getLongestCall() {
        return records.stream()
                .max(Comparator.comparingInt(CallRecord::getDuration));
    }
}

