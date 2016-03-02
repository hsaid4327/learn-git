package com.mine.core.synchronization;

import java.util.Scanner;

class Runner extends Thread {
	private volatile boolean running = true;

	@Override
	public void run() {

		while (running) {
			System.out.println("Hello world");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void shutdown() {
		running = false;
	}

}

public class VolatileExample {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		System.out.println("Press Enter to shutdown");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		runner1.shutdown();

	}

}
