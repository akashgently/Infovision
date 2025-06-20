package com.Day7;

import java.util.LinkedList;
import java.util.Queue;
 
class SharedBuffer {
    private Queue<Integer> buffer = new LinkedList<>();
    private int capacity = 5;
 
    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); // Wait until space is available
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notify(); // Notify consumer
    }
 
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Wait until item is available
        }
        // Both poll() and remove() are methods used to remove elements from a queue. 
        //They differ in their behavior when the queue is empty
        //poll() -> Returns null if the queue is empty.
        //remove() -> Throws a NoSuchElementException if the queue is empty.
        int item = buffer.poll();
        System.out.println("Consumed: " + item);
        notify(); // Notify producer
        return item;
    }
}
 
class Producer extends Thread {
    private SharedBuffer buffer;
 
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
 
    public void run() {
        int i = 1;
        while (true) {
            try {
                buffer.produce(i++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 
class Consumer extends Thread {
    private SharedBuffer buffer;
 
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
 
    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 
public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}
