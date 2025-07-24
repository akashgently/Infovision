package com.Telecom_Customer_Call_Assignment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Customer_app {
    private static final CallService callService = new CallService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            switch (scanner.nextLine()) {
                case "1": addCall(); break;
                case "2": listCalls(); break;
                case "3": filterCalls(); break;
                case "4": sortCalls(); break;
                case "5": groupByOperator(); break;
                case "6": groupByLocation(); break;
                case "7": longestCall(); break;
                case "8": frequentCallers(); break;
                case "9": running = false; break;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private static void printMenu() {
        System.out.println(" Call Records CLI  ");
        System.out.println("1. Add Call Record");
        System.out.println("2. List All Calls");
        System.out.println("3. Filter Calls by Min Duration");
        System.out.println("4. Sort Calls by Duration (Descending)");
        System.out.println("5. Group Calls by Operator");
        System.out.println("6. Group Calls by Location");
        System.out.println("7. Longest Call");
        System.out.println("8. Frequent Callers");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addCall() {
        System.out.print("Caller: ");
        String caller = scanner.nextLine();
        System.out.print("Receiver: ");
        String receiver = scanner.nextLine();
        System.out.print("Duration (seconds): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Operator: ");
        String operator = scanner.nextLine();

        CallRecord record = new CallRecord(caller, receiver, duration, location, operator, LocalDateTime.now());
        callService.addCall(record);
        System.out.println("Call record added.");
    }

    private static void listCalls() {
        callService.getAllCalls().forEach(System.out::println);
    }

    private static void filterCalls() {
        System.out.print("Minimum duration (seconds): ");
        int min = Integer.parseInt(scanner.nextLine());
        List<CallRecord> filtered = callService.filterByMinDuration(min);
        filtered.forEach(System.out::println);
    }

    private static void sortCalls() {
        callService.sortByDurationDesc().forEach(System.out::println);
    }

    private static void groupByOperator() {
        Map<String, List<CallRecord>> grouped = callService.groupByOperator();
        grouped.forEach((op, calls) -> {
            System.out.println("Operator: " + op);
            calls.forEach(System.out::println);
        });
    }

    private static void groupByLocation() {
        Map<String, List<CallRecord>> grouped = callService.groupByLocation();
        grouped.forEach((loc, calls) -> {
            System.out.println("Location: " + loc);
            calls.forEach(System.out::println);
        });
    }

    private static void longestCall() {
        Optional<CallRecord> longest = callService.getLongestCall();
        longest.ifPresent(System.out::println);
    }

    private static void frequentCallers() {
        Map<String, Long> freq = callService.getCallCountPerCaller();
        freq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println("Caller: " + e.getKey() + ", Calls: " + e.getValue()));
    }
}

