package com.mine.core;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<Double> queue = new PriorityQueue<Double>();
		queue.offer(3.3);
		queue.offer(9.8);
		queue.offer(9.0);

		System.out.println(".....Iterating over the Queue");
		Iterator<Double> it = queue.iterator();
		while (it.hasNext()) {
			System.out.printf(" %.1f ", it.next());
		}
		System.out.println(".....Getting Elements from the Queue .......");

		while (queue.size() > 0) {
			System.out.printf(" %.1f ", queue.poll());
		}
		Queue<Double> queueWithComparator = new PriorityQueue<Double>(new DoubleComporator());
		queueWithComparator.offer(3.3);
		queueWithComparator.offer(9.8);
		queueWithComparator.offer(9.0);	
		System.out.println(".....Getting Elements from the Queue with comparator .......");

		while (queueWithComparator.size() > 0) {
			System.out.printf(" %.1f ", queueWithComparator.poll());
		}		
	}

	static class DoubleComporator implements Comparator<Double> {

		@Override
		public int compare(Double o1, Double o2) {
			if (o2 > o1) {
				return 1;
			} else if (o2 < o1) {
				return -1;
			}
			return 0;
		}

	}
}
