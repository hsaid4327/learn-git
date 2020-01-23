package com.mine.core.javaapi.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class AysncSalarayFunction implements AsyncFunction<Person, Double> {

	private ListeningExecutorService service;
	
	@Override
	public ListenableFuture<Double> apply(final Person person) throws Exception {
		
		System.out.printf("%s calling in the Function%n",Thread.currentThread().getName());
		ExecutorService executorService = Executors.newCachedThreadPool();
		service = MoreExecutors.listeningDecorator(executorService);
		ListenableFuture<Double> future = service.submit(new Callable<Double>(){

			@Override
			public Double call() throws Exception {
				System.out.printf("%s calling in the second listenable future with Async Function%n",Thread.currentThread().getName());
				return Service.calculateSalary(person);
			}
			
		});
		return future;
	}

}
