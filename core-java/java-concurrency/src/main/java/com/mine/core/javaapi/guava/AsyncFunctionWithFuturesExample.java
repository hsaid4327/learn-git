package com.mine.core.javaapi.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class AsyncFunctionWithFuturesExample {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		ListeningExecutorService service = MoreExecutors.listeningDecorator(executorService);
		ListenableFuture<Person> future = service.submit(new Callable<Person>(){

			@Override
			public Person call() throws Exception {
				System.out.printf("%s calling in the first listenable future%n",Thread.currentThread().getName());
				return Service.findPerson(2);
			}
			
		});	
		ListenableFuture<Double> result = Futures.transform(future, new AysncSalarayFunction(), service);
		try {
			System.out.printf("The result for the Async Function: %.2f%n", result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
