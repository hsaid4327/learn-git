package com.mine.core.javaapi;


public class Consumer implements Runnable {

	private final Buffer buffer;

	@Override
	public void run() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {

			try {
				int value = buffer.get();
				sum += value;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.printf("%s\t\t%d%n",
				"The sum of the numbers added by the consumer is:", sum);

	}

	public Consumer(Buffer buffer) {

		this.buffer = buffer;
	}

}
