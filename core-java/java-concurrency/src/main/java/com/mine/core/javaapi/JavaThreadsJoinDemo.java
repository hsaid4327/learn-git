package com.mine.core.javaapi;

public class JavaThreadsJoinDemo {

	public static void main(String[] args) {
		Thread t = kick();
		System.out.println("Starting thread");
		t.start();
		System.out.println("Joining");
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting main");

	}

	private static Thread kick() {
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				
				try {
					System.out.println("Reading");
                    System.in.read();
                } catch (java.io.IOException ex) {
                    System.err.println(ex);
                }
				
			}
			
		});
		
		return t1;
	}

}
