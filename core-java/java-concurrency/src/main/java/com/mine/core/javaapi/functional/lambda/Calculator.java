package com.mine.core.javaapi.functional.lambda;

public class Calculator {

	interface IntegerMath {
		int operation(int a, int b);
	}

	public int operateBinary(int x, int y, IntegerMath op) {
		return op.operation(x, y);
	}

	public static void main(String... args) {

		Calculator myApp = new Calculator();
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("20 - 10 = "
				+ myApp.operateBinary(20, 10, subtraction));
		System.out.println("20 * 10 = "
				+ myApp.operateBinary(20, 10, (a,b) -> a*b));
	}
}