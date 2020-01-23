package com.mine.core.javaapi.functional;

/**
 * Lambda Syntax A lambda consists of a parameter list followed by the arrow
 * token (->) and a body, as in:
 * 
 * (parameterList) -> {statements}
 * 
 * The following lambda receives two ints and returns their sum:
 * 
 * @author hsaid-contractor
 *
 */
public class SimpleLambdaExpressions {

	public static void main(String[] args) {
         
		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");

		// Run em!
		r1.run();
		r2.run();

	}

}
