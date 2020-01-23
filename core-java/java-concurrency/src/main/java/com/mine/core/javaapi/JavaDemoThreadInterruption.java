package com.mine.core.javaapi;

public class JavaDemoThreadInterruption {

	public static void main(String[] args) {
		InterruptableThreaExample e1 = new InterruptableThreaExample();
		InterruptableThreaExample e2 = new InterruptableThreaExample();
		Thread t1 = new Thread(e1);
		t1.setName("firstThread");
		Thread t2 = new Thread(e2);
		t2.setName("secondThread");
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		e1.shutdown();
		e2.shutdown();

	}

}

class InterruptableThreaExample implements Runnable {

	private volatile boolean done = false;

	@Override
	public void run() {
		try {
			while (!done) {
				System.out.printf("%s is still running\n", Thread
						.currentThread().getName());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					done = true;
				}

			}
		} finally {
			System.out.println(".......Exiting........");
		}

	}

	public void shutdown() {
		done = true;

	}

}
