package com.Day13;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {

        Vector<String> fruits = new Vector<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        fruits.add(1, "Orange");
        System.out.println("Element at index 2: " + fruits.get(2));
        fruits.set(2, "Grapes");
        fruits.remove("Banana");

        System.out.println("Contains Mango? " + fruits.contains("Mango"));

        System.out.println("Fruits in vector: " + fruits);
    }
}

