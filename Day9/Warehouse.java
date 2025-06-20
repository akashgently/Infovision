package com.Day9;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
//	String[] productSlots= new String[100];
	List<String> productSlots = new ArrayList<>();
	
	public void storeProduct(int slot, String product) {
		while (productSlots.size() <= slot) {
			productSlots.add(null);
			}
		productSlots.set(slot, product);
	}
	
	public String getProduct(int slot) {
		System.out.println(productSlots.get(slot));
		return productSlots.get(slot);
	}
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.storeProduct(20, "product-1");
		warehouse.getProduct(20);
	}

}
