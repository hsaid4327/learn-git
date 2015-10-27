package com.mine.core.javaapi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(10);
		ReentrantLock lock = new ReentrantLock();
		for(int i =0; i < 10; i++){
			
			Thread t = new Thread (new Runnable(){
				public void run(){
					System.out.println("Running the Thread");
					for(int c = 0; c<100;c++){
						
					}
					
//					try {
//					    Thread.sleep(5000);
//						
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					lock.lock();
					latch.countDown();
					System.out.println("The current latch count is: "+latch.getCount());
					lock.unlock();
				}
			});
			t.start();
		}
//		try {
//			latch.await();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("The current latch count is: "+latch.getCount());
		
        while(latch.getCount() > 5){
        	//System.out.println("Not counted till 500");
        	try {
				latch.await(10, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println("exiting the prog");
	}
	
	

}
