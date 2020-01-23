package com.mine.core.recursion;

public class FactorialExample {

	public static void main(String[] args) {
		System.out.printf("The calcualated Factorial is: %d%n", calculateFactorial(5));

	}
	
	public static int calculateFactorial(int n){
		
		if(n < 0){
			throw new IllegalArgumentException("The factorial can only be calcualted for a number more than 1");
		}
		if (n == 0){
			return 1;
		}
		System.out.printf("Called with argument - > %d%n", n);
		
		int returnValue =  n*calculateFactorial(n-1);
		System.out.printf("returning value - > %d%n", returnValue);
		return returnValue;
	}

}
