package com.Day6;

import java.io.*;
import java.util.Scanner;

public class FileHandlingExample {

    static final String FILE_NAME = "telecom_feedback.txt";
    static final String CSV_FILE_NAME = "telecom_feedback.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Telecom Customer Feedback System ---");
            System.out.println("1. Submit Feedback");
            System.out.println("2. View All Feedbacks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    submitFeedback(scanner);
                    break;
                case 2:
                    readFeedbacks();
                    break;
                case 3:
                    System.out.println("Thank you for your feedback. Have a great day!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void submitFeedback(Scanner scanner) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true);
        		FileWriter writer1 = new FileWriter(CSV_FILE_NAME, true)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Rate our network quality (1-5): ");
            String networkRating = scanner.nextLine();

            System.out.print("Rate our customer service (1-5): ");
            String serviceRating = scanner.nextLine();

            System.out.print("Any additional comments: ");
            String comments = scanner.nextLine();

            writer.write("Name: " + name + "\n");
            writer.write("Network Rating: " + networkRating + "\n");
            writer.write("Service Rating: " + serviceRating + "\n");
            writer.write("Comments: " + comments + "\n");
            writer.write("--------\n");
            
            writer1.write(name +","+comments + "\n");

            System.out.println("Thank you! Your feedback has been recorded.");
        } catch (IOException e) {
            System.out.println("Error while writing feedback.");
            e.printStackTrace();
        }
    }

    public static void readFeedbacks() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            System.out.println("\n--- All Customer Feedbacks ---");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No feedback found yet.");
        } catch (IOException e) {
            System.out.println("Error reading feedbacks.");
            e.printStackTrace();
        }
    }
}
