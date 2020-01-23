package com.mine.core.javaapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {

	public static void main(String[] args) {
		
		PrintTask printask_1 = new PrintTask("task_1");
		PrintTask printask_2 = new PrintTask("task2");
		PrintTask printtask_3 = new PrintTask("task3");
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		System.out.println("Starting Executor");
		
		executorService.execute(printask_1);
		executorService.execute(printask_2);
		executorService.execute(printtask_3);
		
		executorService.shutdown();
		
		System.out.printf("Tasks started, main ends.%n%n");
	}

}
