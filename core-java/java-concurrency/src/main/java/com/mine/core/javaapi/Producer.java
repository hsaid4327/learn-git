package com.mine.core.javaapi;

import java.util.Random;

public class Producer implements Runnable {

	private final Buffer buffer;
	private final Random generator = new Random();
	
	@Override
	public void run() {
		int sum = 0;
		for(int i=0; i<10; i++){
			int value = generator.nextInt(300);
			try {
				buffer.set(value);
				sum+=value;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("%s\t\t%d%n", "The sum of the numbers added by the producer is:", sum);

	}

	public Producer(Buffer buffer) {
		
		this.buffer = buffer;
	}
	

}
