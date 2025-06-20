package com.Day8;

public class ConsumerThread extends Thread{
	private ProducerConsumerDemo pc;

	public ConsumerThread(ProducerConsumerDemo pc) {
		super();
		this.pc = pc;
	}
	
	public void run() {
		try {
			while(true) {
		pc.consume();
		Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}