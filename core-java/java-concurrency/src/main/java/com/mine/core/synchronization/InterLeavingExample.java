package com.mine.core.synchronization;

public class InterLeavingExample {
	private int count = 0;
	private Object lock = new Object();

	public static void main(String[] args) {
		InterLeavingExample example = new InterLeavingExample();
		example.doWork();

	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					synchronized (lock) {
						count++;
					}
				}

			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					synchronized (lock) {
						count++;
					}
				}

			}

		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}

}
