package com.mine.core.javaapi.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class FutureCallBackExample {

	public static void main(String[] args) {
		Thread.currentThread().setName("Main Thread");
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		ListeningExecutorService service = MoreExecutors.listeningDecorator(executorService);
		ListenableFuture<String> futureTask = service.submit(new Callable<String>(){

			@Override
			public String call() throws Exception {
				
				System.out.println(Thread.currentThread().getName()+"........ Processing Order.......");
				//Thread.sleep(500);
				System.out.println("........ thread wakes up.......");
				return "The order has been processed, and sent to the shipping office";
			}
			
		});
		FutureCallbackImpl callback = new FutureCallbackImpl();
		Futures.addCallback(futureTask, callback);
        System.out.printf("%s", callback.getCallbackResult());
        System.out.println("........The main prog ends........");
	}

	public static class FutureCallbackImpl implements FutureCallback<String> {

	    private StringBuilder builder = new StringBuilder();

	    @Override
	    public void onSuccess(String result) {
	        
	    	System.out.println(Thread.currentThread().getName()+"........ handling callback.......");
	    	
	    	builder.append(result).append(" successfully");

	    }

	    @Override
	    public void onFailure(Throwable t) {
	        builder.append(t.toString());
	    }

	    public String getCallbackResult() {
	        return builder.toString();
	    }
	}



}
