package com.mine.core.javaapi.functional.lambda;

import java.util.concurrent.Callable;

/**
 * 
 * The method invoke(Callable<T>) will be invoked because that method returns a
 * value; the method invoke(Runnable) does not. In this case, the type of the
 * lambda expression () -> "done" is Callable<T>.
 *
 */

public class LambdaExpressionType {

	public void invoke(Runnable r) {
		System.out.printf("%s%n", "Invoking Runnable");
		r.run();
	}

	public <T> T invoke(Callable<T> c) throws Exception {
		System.out.printf("%s%n", "Invoking Callable");
		return c.call();
	}

	public static void main(String[] args) throws Exception {
		LambdaExpressionType lambdaExpressionType = new LambdaExpressionType();
		System.out.printf("%s%n", lambdaExpressionType.invoke(() -> "done"));
		lambdaExpressionType.invoke(() -> {System.out.println("Running Thread");});

	}

}
