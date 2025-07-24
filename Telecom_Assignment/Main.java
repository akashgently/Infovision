package com.Telecom_Assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Telecom Customer Management ====");
            System.out.println("1. Add Customer");
            System.out.println("2. Make Call");
            System.out.println("3. Subscribe to VAS");
            System.out.println("4. Unsubscribe from VAS");
            System.out.println("5. File Complaint");
            System.out.println("6. View Complaints");
            System.out.println("7. Display All Customers");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String id;
            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    manager.addCustomer(id, name);
                    break;
                case 2:
                    System.out.print("Enter Customer ID: ");
                    id = scanner.nextLine();
                    Customer customer1 = manager.getCustomer(id);
                    if (customer1 != null) {
                        System.out.print("Enter number called: ");
                        String number = scanner.nextLine();
                        System.out.print("Enter duration (in seconds): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine();
                        customer1.makeCall(number, duration);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    id = scanner.nextLine();
                    Customer customer2 = manager.getCustomer(id);
                    if (customer2 != null) {
                        System.out.print("Enter VAS to subscribe: ");
                        String vas = scanner.nextLine();
                        customer2.subscribeVAS(vas);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    id = scanner.nextLine();
                    Customer customer3 = manager.getCustomer(id);
                    if (customer3 != null) {
                        System.out.print("Enter VAS to unsubscribe: ");
                        String vas = scanner.nextLine();
                        customer3.unsubscribeVAS(vas);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    id = scanner.nextLine();
                    Customer customer4 = manager.getCustomer(id);
                    if (customer4 != null) {
                        System.out.print("Enter complaint description: ");
                        String desc = scanner.nextLine();
                        customer4.fileComplaint(desc);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Customer ID: ");
                    id = scanner.nextLine();
                    Customer customer5 = manager.getCustomer(id);
                    if (customer5 != null) {
                        customer5.viewComplaints();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 7:
                    manager.displayAll();
                    break;
                case 0:
                    System.out.println("Exiting. Thank you!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

