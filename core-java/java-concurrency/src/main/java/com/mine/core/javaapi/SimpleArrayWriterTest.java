package com.mine.core.javaapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleArrayWriterTest {

	public static void main(String[] args) {
		SynchronizedSimpleArray simpleArray = new SynchronizedSimpleArray(6);
		SimpleArrayWriter simpleArrayWriter_1 = new SimpleArrayWriter(
				simpleArray, 1);
		SimpleArrayWriter simpleArrayWriter_2 = new SimpleArrayWriter(
				simpleArray, 11);

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(simpleArrayWriter_1);
		executorService.execute(simpleArrayWriter_2);

		executorService.shutdown();

		try {
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded = executorService.awaitTermination(1,
					TimeUnit.MINUTES);

			if (tasksEnded)
				System.out.println(simpleArray); // print contents
			else
				System.out
						.println("Timed out while waiting for tasks to finish.");
		} // end try
		catch (InterruptedException ex) {
			System.out
					.println("Interrupted while waiting for tasks to finish.");
		} // end catch
	} // end main

}
