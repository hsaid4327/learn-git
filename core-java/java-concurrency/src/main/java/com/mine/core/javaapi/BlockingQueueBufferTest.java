package com.mine.core.javaapi;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingQueueBufferTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Queue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
		Buffer buffer = new BlockingQueueBuffer(blockingQueue);
		Producer producer = new Producer(buffer);
		Consumer consuemr = new Consumer(buffer);
		
		executor.execute(producer);
		executor.execute(consuemr);
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----The Blocking Buffer Test is finished------");

	}

}
