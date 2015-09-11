package com.mine.core.javaapi;

import java.security.SecureRandom;

public class PrintTask implements Runnable {

	private static final SecureRandom generator = new SecureRandom();
	private final int sleepTime; // random sleep time for thread
	private final String taskName;

	@Override
	public void run() {
		System.out.printf("%s is going to sleep for %d milliseconds %n", taskName, sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s has done sleeping %n", taskName);
	}

	public PrintTask(String taskName) {

		// pick random sleep time between 0 and 5 seconds
		sleepTime = generator.nextInt(5000); // milliseconds
		this.taskName = taskName;
	}

}
