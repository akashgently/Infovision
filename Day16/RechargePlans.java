package com.Day16;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RechargePlans {
    public static void main(String[] args) {
        List<String> plans = Arrays.asList(
                "1.Plan A - ₹199 - Unlimited Calls + 1.5GB/day",
                "2.Plan B - ₹299 - Unlimited Calls + 2GB/day",
                "3.Plan C - ₹399 - Unlimited Calls + 3GB/day + Netflix",
                "4.Plan D - ₹499 - Unlimited Calls + 4GB/day + Amazon Prime"
        );

        System.out.println("Available Recharge Plans:");
        plans.forEach(i -> System.out.println(i));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the plan you want to choose: ");
        int choice = scanner.nextInt();

        int index = choice - 1;
        plans.stream()
                .filter(plan -> plans.indexOf(plan) == index)
                .findFirst()
                .ifPresentOrElse(
                        selected -> System.out.println("You have selected: " + selected),
                        () -> System.out.println("Invalid choice. Please try again.")
                );


    }
}

