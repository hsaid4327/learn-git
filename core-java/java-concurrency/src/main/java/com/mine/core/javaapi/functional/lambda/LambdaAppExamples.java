package com.mine.core.javaapi.functional.lambda;

interface Executable {
	void execute();

}

interface ExecutableWithReturn {
	int execute();

}


interface ExecutableWithParams {
	int execute(int a, int b);

}


class Runner {
	public void run(Executable e) {
		e.execute();
	}

	public int run(ExecutableWithReturn e) {
		return e.execute();
	}
	
	public int run(int a, int b, ExecutableWithParams e) {
		return e.execute(a, b); 
	}

}

public class LambdaAppExamples {

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run(new Executable() {

			@Override
			public void execute() {
				System.out.println("Executinng anonymous class");

			}

		});

		System.out.println("=========================");

		runner.run(new ExecutableWithReturn() {

			@Override
			public int execute() {
				System.out.println(9);
				return 9;
			}

		});

		System.out.println("=========================");
		System.out.println(runner.run(7, 8, new ExecutableWithParams() {
			
			@Override
			public int execute(int a, int b) {
				// TODO Auto-generated method stub
				return a*b;
			}
		}));
		
		
		System.out.println("=========================");

		System.out.println(runner.run(() -> 8));
		
		System.out.println("=========================");
		
		System.out.println(runner.run(9,9, (a,b)-> a*b));

	}

}
