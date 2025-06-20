package com.Day7;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class CDR {
    int callId;
    String caller;
    String receiver;
    int duration;

    public CDR(int callId, String caller, String receiver, int duration) {
        this.callId = callId;
        this.caller = caller;
        this.receiver = receiver;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("CDR{id=%d, caller=%s, receiver=%s, duration=%ds}",
                callId, caller, receiver, duration);
    }
}


// ===================================================================================================

class CDRProducer implements Runnable {
    private final BlockingQueue<CDR> queue;

    public CDRProducer(BlockingQueue<CDR> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int callId = 1;
        try {
            while (true) {
                CDR cdr = new CDR(
                        callId++,
                        "+12345" + (10000 + callId++),
                        "+67890" + (10000 + callId++),
                        10
                );
                queue.put(cdr);
                System.out.println("[Producer] Generated: " + cdr);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

//===================================================================================================

class CDRConsumer implements Runnable {
    private final BlockingQueue<CDR> queue;

    public CDRConsumer(BlockingQueue<CDR> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                CDR cdr = queue.take();
                System.out.println("[Consumer] Processing: " + cdr);
                Thread.sleep(1500); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

//===================================================================================================

public class TelecomCDRProcessing {
    public static void main(String[] args) {
        BlockingQueue<CDR> cdrQueue = new ArrayBlockingQueue<>(10);

        Thread producerThread = new Thread(new CDRProducer(cdrQueue));
        Thread consumerThread = new Thread(new CDRConsumer(cdrQueue));

        producerThread.start();
        consumerThread.start();
    }
}
