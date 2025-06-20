package com.Day7;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
	private int stock = 100;
	private Lock lock = new ReentrantLock();
	
	public void purchase(String user, int quantity) {
		lock.lock();
		try {
		if(stock >= quantity) {
			System.out.println(user + " purchased "+ quantity+" item ");
			stock-=quantity;
//			return true;
		}else {
			System.out.println("Not Purchased!");
//			return false;
		}}
		finally {
			lock.unlock();
		}
		
	}
	

	public int getStock() {
		return stock;
	}

}
