package com.mine.core.javaapi;

public interface Buffer {
	
	public int get() throws InterruptedException;
	
	public void set(int value) throws InterruptedException;

}
