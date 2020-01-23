package com.mine.core.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
    CountDownLatch latch;
	private int id;
	String task;
    
    
    @Override
	public void run() {
		System.out.printf("Processor %d initializing %s%n", id, task);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
		
	}


	public  Processor(CountDownLatch latch, int id, String task) {
		super();
		this.latch = latch;
		this.id = id;
		this.task = task;
	}
	
}

public class CountDownLatchExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		CountDownLatch latch = new CountDownLatch(3);
		
		for(int i=1; i < 4; i++){
			executor.submit(new Processor(latch, i, "Database-"+i));
			
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All initialization tasks finished");
		
	}

}
