package com.Day7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Payment {
	private Lock lock = new ReentrantLock();
	
	public void payment(int amount, int quantity) {
		lock.lock();
		try {
		if(quantity > 0) {
			System.out.println("Bill Amount: "+ (amount*quantity));
		}else {
			System.out.println("Not Billable!");
		}}
		finally {
			lock.unlock();
		}
		
	}

}
