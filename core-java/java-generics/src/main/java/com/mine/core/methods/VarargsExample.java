package com.mine.core.methods;

import java.util.ArrayList;
import java.util.List;

public class VarargsExample {

	public static void main(String[] args) {
		List<Integer> ints = toList(new Integer[] { 1, 2, 3 });
		List<String> words = toList(new String[] { "hello", "world" });
		
		ints = toListWithVargs(1, 2, 3);
		words = toListWithVargs("one", "two", "three");
	}
	
	public static <T> List<T> toList(T[] array){
		ArrayList<T> list = new ArrayList<T>();
		
		
		for(T element: array) {
			list.add(element);
		}
		return list;
	}
	
	public static <T> List<T> toListWithVargs(T... arr){
		ArrayList<T> list = new ArrayList<T>();
		for(T element: arr) {
			list.add(element);
		}
		return list;
	}

}
