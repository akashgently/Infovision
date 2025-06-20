package com.Day8;

import java.util.LinkedList;

public class ProducerConsumerDemo {
	
	private static final int capacity = 10;
	private final LinkedList<Integer> buffer = new LinkedList();
	
	synchronized public void produce(int value) throws InterruptedException {
		while(buffer.size()==capacity) {
			wait();
		}
		buffer.add(value);
		System.out.println("Product Produced " + value);
		notify();
	}
	
	synchronized public void consume() throws InterruptedException {
		while(buffer.isEmpty()) {
			wait();
		}
		int value = buffer.removeFirst();
		System.out.println("Product Consumed " + value);
		notify();
	}

}
