package com.mine.core.synchronization;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantRunner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();

		System.out.println("Waiting ....");
		cond.await(); // releases the lock here...

		System.out.println("Woken up!");

		try {
			increment();
		} finally {
			
			lock.unlock();
			System.out.println("First Thread finished processing!");
		}
	}

	public void secondThread() throws InterruptedException {

		Thread.sleep(1000);
		lock.lock();

		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");

		cond.signal(); /// it does not relesase the lock, only tells the waiting thread to proceede once the lock is available

		try {
			
			increment();
			
		} finally {
			System.out.println("Second Thread releasing the lock!");
			
			lock.unlock();
			
			System.out.println("Second Thread finished processing!");
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}

public class ReentrantLockExample {
	public static void main(String[] args) throws Exception {

		final ReentrantRunner runner = new ReentrantRunner();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		runner.finished();
	}

}
