package com.mine.core.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	Object lock1 = new Object();
	Object lock2 = new Object();
	Random random = new Random();

	public void main() {
		System.out.println("starting.........");
		long start = System.currentTimeMillis();
		Thread t1 = (new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}

		}));
		t1.setName("first");
		t1.start();

		Thread t2 = (new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}

		}));
		t2.setName("second");
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("The time needed is: " + interval);
		System.out.println("The size of list1: " + list1.size());
		System.out.println("The size of list2:" + list2.size());

	}

	public void stageOne() {

		synchronized (lock1) {
			String name = Thread.currentThread().getName();
			System.out.println(name+ " acquired the method stagOne()");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));

		}

	}

	public void stageTwo() {
		
		
		synchronized (lock2) {
			String name = Thread.currentThread().getName();
			System.out.println(name+ " acquired the method stageTwo()");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));

		}

	}

	public void process() {
		System.out.println("Starting process.......");
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
		System.out.println("Terminating process.......");
	}

}
