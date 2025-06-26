package com.Day12;

import java.util.HashMap;
import java.util.Map;

class Product{
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}


public class ProductInventory {
    public static void main(String[] args) {
        Map<String, Product> inventory= new HashMap<>();

        inventory.put("p001",new Product("iphone13", 78000.00,10));
        inventory.put("p002",new Product("iphone14", 88000.00,8));
        inventory.put("p003",new Product("iphone15", 98000.00,5));

        String searchId ="p001";
        Product searchProduct = inventory.get(searchId);

        if(searchProduct !=null){
            System.out.println("Product Found");
        }else{
            System.out.println("Product Not Found");
        }
    }
}
