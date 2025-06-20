package com.Day7;

public class OrderThread extends Thread{
	
	private Inventory inventory;
	private Payment payment;
	private String user;
	private int quantity;
	private int amount;
	public OrderThread(Inventory inventory,Payment payment, String user, int quantity, int amount) {
		super();
		this.inventory = inventory;
		this.payment = payment;
		this.user = user;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	public void run() {
	  inventory.purchase(user, quantity);
	  payment.payment(amount, quantity);
	    
	}

	
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Payment payment = new Payment();
		OrderThread order1=new OrderThread(inventory,payment,"akash",20,10);
		order1.start();
		OrderThread order2=new OrderThread(inventory,payment,"pawan",20,5);
		order2.start();
		OrderThread order3=new OrderThread(inventory,payment,"pawana",80,20);
		order3.start();
	}

}
