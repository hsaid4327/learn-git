package com.mine.core.basic;

public class LogTable {

	public static void main(String[] args) {

		int n = lg(3000, (a) -> {
			int i = 0;
			for (; a > 1;) {
				a = a/2;
				i = i+1;
			}
			
			return i;
		});
		System.out.println(n);
	}

	public static int lg(int N, LogCalculater c) {
		return c.calculateLog(N);
	}

	interface LogCalculater {
		int calculateLog(int N);
	}

}
