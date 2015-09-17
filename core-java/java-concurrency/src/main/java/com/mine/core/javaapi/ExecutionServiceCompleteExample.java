package com.mine.core.javaapi;

import java.security.SecureRandom;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionServiceCompleteExample {
	private static final SecureRandom generator = new SecureRandom();

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();

		ExecutorCompletionService<String> service = new ExecutorCompletionService<String>(
				executor);

		int i = 1;
		for (; i < 11; i++) {
			service.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {

					int sum = 0;
					for (int i = 0; i < 1000; i++) {
						sum += i;

					}
					System.out.printf("%s%n", sum);
					return "Thread Name: " + generator.nextInt(5000)
							+ " Completed";
				}

			});
		}

		try {
			int c = 1;
			while (c < 11) {
				Future<String> f = service.take();

				System.out.printf("%s%n", f.get());

				c++;
			}
			executor.shutdown();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
