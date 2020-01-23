package com.mine.core.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor_1 implements Runnable {
	private int i;

	public Processor_1(int i) {

		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("The processor is running with " + i);

	}

}

public class ThreadGroupExample {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		for (int i = 1; i < 11; i++) {
			ex.submit(new Processor_1(i));
		}
		ex.shutdown();
		try {
			ex.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All Tasks completed");
	}

}
