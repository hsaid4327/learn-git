package com.mine.core.javaapi;

public class ThreadDemoWithInlineRunnable {

	public static void main(String[] args) {
		NameRepeater nameRepeater1 = new NameRepeater(5, "first");
		NameRepeater nameRepeater2 = new NameRepeater(5, "second");
		nameRepeater1.start();
		nameRepeater2.start();
		nameRepeater2.start();


	}

}

class NameRepeater {
	private int count;
	private String name;

	public NameRepeater(int count, String name) {
		super();
		this.count = count;
		this.name = name;
	}

	public void start(){
		Thread thread = new Thread(new Runnable () {

			@Override
			public void run() {
				System.out.printf("The count at the start is %d\n", count);
				
				while(count > 0){
					
					System.out.printf("The count for the name %s is %d\n", name, count);
					
					System.out.println("Your name is: "+name);
				count--;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
			
		});
		thread.setName("Thread Name: "+name);
		thread.start();
	}

}
