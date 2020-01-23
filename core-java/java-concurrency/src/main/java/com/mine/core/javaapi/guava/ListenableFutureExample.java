package com.mine.core.javaapi.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ListenableFutureExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ListeningExecutorService service = MoreExecutors.listeningDecorator(executorService);
		ListenableFuture<String> listenableFuture = service.submit(new Callable<String>(){

			@Override
			public String call() throws Exception {
				
				System.out.println("........ Processing Order.......");
				Thread.sleep(5000);
				return "The order has been processed, and sent to the shipping office";
			}
			
		});
		try {
			System.out.println(" Listenable Future output is: "+ listenableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listenableFuture.addListener(new Runnable(){

			@Override
			public void run() {
				System.out.println("The order has been receieved, the item would be shipped in time");
				
			}
			
		}, service);
          System.out.println("The main thread execution ends");
	}

}
