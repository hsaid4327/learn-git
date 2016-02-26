package com.mine.core.javaapi.functional;

public class AnynomousClassExample {

	public static int handleBase(Base b) {
		return b.method1();
	}

	public static void main(String[] args) {
		int b = handleBase(new Base() {
			public int method1() {
				return 2;
			}
		});
		System.out.println(b);

	}

}
