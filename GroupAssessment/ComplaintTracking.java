package com.GroupAssessment;

import java.util.ArrayList;
import java.util.Scanner;

public class ComplaintTracking {
    static ArrayList<CustomerDTO> customerDetails = new ArrayList<>();

    static void displayAllComplaintQueries() {
        customerDetails.forEach(customer -> System.out.println(customer));
    }
    static void deletQueries(int id) {
        customerDetails.removeIf(customerDTO -> customerDTO.getCustomerId() == id);
    }
    static void getCustomerDetailsBYId(int id){
        for (CustomerDTO customerDTO:customerDetails){
            if(customerDTO.getCustomerId()==id){
                System.out.println(customerDTO);
            }
        }
    }

    static void updateStatus(int id){
        for (CustomerDTO customerDTO:customerDetails){
            if(customerDTO.getCustomerId()==id){
                customerDTO.setStatus("disclosed");
                System.out.println("Customer Query Disclosed");
            }
        }

    }

    static void addCustomerQuery(String name, String mobile, String query){
        int i = customerDetails.size() + 1;
        customerDetails.add(new CustomerDTO(i, name, mobile, query,"pending"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("--------------------------------");
            System.out.println("Please enter the options to continue..... 1 - Customer , 2 - Admin, 0 - Exit");
            System.out.println("--------------------------------");
            option = sc.nextInt();

            if (option == 1) {
                System.out.println("Enter your Name");
                String name = sc.next();
                System.out.println("Enter your Contact number");
                String mobile = sc.next();
                System.out.println("Enter your Query");
                String query = sc.next();
                addCustomerQuery(name, mobile, query);
            } else if (option == 2) {
                int admin_option = -1;

                while (admin_option != 0) {
                    System.out.println("--------------------------------");
                    System.out.println("Please enter the options to continue..... 1 - Display All Complaint Queries , 2 - Disclose Query, 3 - Delete Query, 4 - Search Customer By Id, 0 - Exit");
                    System.out.println("--------------------------------");
                    admin_option = sc.nextInt();

                    if (admin_option == 1) {
                        displayAllComplaintQueries();
                    } else if (admin_option == 2) {
                        System.out.println("Enter Customer Id");
                        int customerId = sc.nextInt();
                        updateStatus(customerId);
                    } else if (admin_option == 3) {
                        System.out.println("Enter Customer Id To Delete");
                        int deleteId = sc.nextInt();
                        deletQueries(deleteId);
                    } else if (admin_option == 4) {
                        System.out.println("Enter Customer Id To Search");
                        int searchId = sc.nextInt();
                        getCustomerDetailsBYId(searchId);
                    }else if (option == 0) {
                        System.out.println("Exiting... Thank you!");
                    }else {
                        System.out.println("Invalid option. Please try again.");
                    }
                }
            } else if (option == 0) {
                System.out.println("Exiting... Thank you!");
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}
