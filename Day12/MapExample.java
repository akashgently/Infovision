package com.Day12;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<String,List<String>> customer = new HashMap<>();

        customer.put("Fashion",Arrays.asList( "Preetti","Kavya","Nisha"));
        customer.put("Laptops",Arrays.asList( "Chityala","Nivetha","ChittiRaja"));

        customer.putIfAbsent("Electronics", new ArrayList<>());

        customer.get("Electronics").add("Jaya");

        for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
            System.out.println("Category: " +entry);
        }

        for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
            System.out.println("Category: " +entry.getKey());
        }

        for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
            System.out.println("Category: " +entry.getValue());
        }

        for (Map.Entry<String, List<String>> entry  : customer.entrySet()) {
            System.out.println("Category: " +entry.getKey() + "Customer" + entry.getValue());
        }
    }
}


