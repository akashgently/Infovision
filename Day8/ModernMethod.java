package com.Day8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ModernMethod {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
		
		Runnable Producer = ()->{
			int value=0;
			try {
				while(true) {
					queue.put(value);
					System.out.println("Producer"+value);
					Thread.sleep(1000);
					value++;
				}
			}catch(InterruptedException ie) {
					ie.printStackTrace();
				}
		};
		
		Runnable Consumer = ()->{
		try {
			while(true) {
				int value = queue.take();
				System.out.println("Consumer"+value);
				Thread.sleep(1000);
			}
	}catch(InterruptedException ie) {
		ie.printStackTrace();
	}
		};
		
		new Thread(Consumer).start();
		new Thread(Producer).start();
	}

}
