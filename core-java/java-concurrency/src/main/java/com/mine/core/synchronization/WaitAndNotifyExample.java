package com.mine.core.synchronization;

import java.util.Scanner;

class WaitAndNotifyProcessor {
	 public void produce() throws InterruptedException {
	        synchronized (this) {
	            System.out.println("Producer thread running ....");
	            wait();
	            System.out.println("Resumed.");
	        }
	    }

	    public void consume() throws InterruptedException {
	        
	        Scanner scanner = new Scanner(System.in);
	        Thread.sleep(2000);
	        
	        synchronized (this) {
	            System.out.println("Waiting for return key.");
	            scanner.nextLine();
	            System.out.println("Return key pressed.");
	            // The wait() method releases the lock, but notify() does not release the lock
	            // it only tells wait that it can resume once the lock is available. And the lock 
	            //becomes available after the snychronized block within which notify() is called is
	            // exited
	            notify();
	            scanner.close();
	            Thread.sleep(5000);
	        }
	    }
}


public class WaitAndNotifyExample {
	public static void main(String[] args) throws InterruptedException {

        final WaitAndNotifyProcessor processor = new WaitAndNotifyProcessor();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }

}
