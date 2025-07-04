package com.Day18;
import java.util.*;

public class TelecomRechargePlan {

    private static TelecomRechargePlan instance;


    static class Plan {
        private int id;
        private String name;
        private double price;
        private String benefits;

        public Plan(int id, String name, double price, String benefits) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.benefits = benefits;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getBenefits() { return benefits; }

        @Override
        public String toString() {
            return String.format("Plan ID: %d | Name: %s | Price: ₹%.2f | Benefits: %s",
                    id, name, price, benefits);
        }
    }

    private List<Plan> plans;

    private TelecomRechargePlan() {
        plans = new ArrayList<>();
        plans.add(new Plan(1, "Basic Talktime", 49, "Talktime 40 mins"));
        plans.add(new Plan(2, "Data Pack", 99, "2GB Data + 100 SMS"));
        plans.add(new Plan(3, "Unlimited", 199, "Unlimited Calls + 1.5GB/day Data"));
        plans.add(new Plan(4, "Super Saver", 299, "Unlimited Calls + 3GB/day Data + OTT Subscription"));
    }

    public static TelecomRechargePlan getInstance() {
        if (instance == null) {
            instance = new TelecomRechargePlan();
        }
        return instance;
    }


    public void showAllPlans() {
        System.out.println("Available Recharge Plans:");
        plans.forEach(System.out::println);
    }


    public Optional<Plan> choosePlan(int planId) {
        return plans.stream()
                .filter(p -> p.getId() == planId)
                .findFirst();
    }


    public static void main(String[] args) {
        TelecomRechargePlan recharge = TelecomRechargePlan.getInstance(); // Singleton call
        Scanner scanner = new Scanner(System.in);

        recharge.showAllPlans();

        Optional<Plan> chosenPlan = Optional.empty();
        do {
            System.out.print("\nEnter the Plan ID you want to choose: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a numeric Plan ID.");
                scanner.next();
            }
            int chosenId = scanner.nextInt();
            chosenPlan = recharge.choosePlan(chosenId);

            if (!chosenPlan.isPresent()) {
                System.out.println("Invalid Plan ID selected! Please try again.");
            }
        } while (!chosenPlan.isPresent());

        chosenPlan.ifPresent(plan -> System.out.println("You selected: " + plan));

        scanner.close();
    }
}
