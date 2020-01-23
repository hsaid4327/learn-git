package com.mine.core.methods;

public class GenericMaxMethodWithComporable {

	public static void main(String[] args) {
		System.out.printf("Maximum of %d, %d and %d is %d\n\n", 3, 4, 5,
				max(3, 4, 5));
		System.out.printf("Maximum of %.1f, %.1f and %.1f is %.1f\n\n", 6.6,
				8.8, 7.7, max(6.6, 8.8, 7.7));
		System.out.printf("Maximum of %s, %s and %s is %s\n", "pear", "apple",
				"orange", max("pear", "apple", "orange"));

	}

	public static <T extends Comparable<T>> T max(T a, T b, T c) {
		T max = a;
		if (a.compareTo(b) < 1) {
			max = b;
		}
		if (max.compareTo(c) < 1) {
			max = c;
		}

		return max;
	}

}
