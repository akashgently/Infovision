package com.Day8;

public class ProducerConsumerMain {
	
	public static void main(String[] args) {
		ProducerConsumerDemo prodcons = new ProducerConsumerDemo();
		new ProducerThread(prodcons).start();
		new ConsumerThread(prodcons).start();
	}

}
