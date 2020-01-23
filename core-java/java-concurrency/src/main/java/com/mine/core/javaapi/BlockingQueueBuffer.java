package com.mine.core.javaapi;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueBuffer implements Buffer {
    
	private final ArrayBlockingQueue<Integer> blockingQueue;
	
	
	public BlockingQueueBuffer(Queue<Integer> blockingQueue) {
		super();
		this.blockingQueue = (ArrayBlockingQueue<Integer>) blockingQueue;
	}

	@Override
	public int get() throws InterruptedException {
		int value =  blockingQueue.take();
		System.out.printf("%s\t\t%d\t\t%s\t%d%n", "Consumer takes:", value, "blocking queues size:",blockingQueue.size());
		return value;
	}

	@Override
	public void set(int value) throws InterruptedException {
		blockingQueue.put(value);
		System.out.printf("%s\t\t%d\t\t%s\t%d%n", "Producter puts:", value,"blocking queues size:", blockingQueue.size());
		
		
	}

}
