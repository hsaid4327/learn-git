package com.mine.core.recursion;

import java.util.Random;

public class DivideAndConquerExample {

	public static void main(String[] args) {
		Random random = new Random();
		int[] data = new int[100];
		for(int i=0; i < 100; i++){
			data[i] = random.nextInt(100);
			System.out.println(data[i]);
		}
        System.out.printf("The largest int is: %d%n", findLargest(data, 0, data.length-1));
	}

	public static int findLargest(int[] data, int low, int high) {

		if (low == high) {
			return data[low];
		}
		int mid = (low + high) / 2;
		int u = findLargest(data, low, mid);
		int v = findLargest(data, mid + 1, high);

		if (u > v)
			return u;
		else
			return v;
	}

}
