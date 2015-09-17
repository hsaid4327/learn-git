package com.mine.core.javaapi;

public class SimpleArrayWriter implements Runnable {

	private final SynchronizedSimpleArray simpleArray;
	private final int value;
	
	@Override
	public void run() {
		for (int i = value; i < value+3; i++){
			simpleArray.add(i);
		}
		
	}


	public SimpleArrayWriter(SynchronizedSimpleArray simpleArray, int v) {
		
		this.simpleArray = simpleArray;
		this.value = v;
	}
	
	

}
