package com.mine.core.wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCardExample {

	public static void main(String[] args) {
		List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
		List<Integer> ints = Arrays.asList(5, 6);
		List<Integer> source = Arrays.asList(1, 2);
		copy(objs, ints);
		WildCardExample.<Object>copyList_2(objs, ints);
		WildCardExample.<Integer>copyList_2(source, ints);
		WildCardExample.<Integer>copyList_1(source, ints);
		WildCardExample.<Integer>copyList_3(objs, ints);
		
		print(objs);
		

	}
	
	/**
	 * The possible signatures of the method could be:
	 * 
	 * public static <T> void copy(List<T> dst, List<T> src) ---> works only with Integer
       public static <T> void copy(List<T> dst, List<? extends T> src)----> works only with explicit cast of Object
       public static <T> void copy(List<? super T> dst, List<T> src)
       public static <T> void copy(List<? super T> dst, List<? extends T> src)

	 * @param dst
	 * @param src
	 */
	
	
	public static <T> void copyList(List<? super T> dst, List<? extends T>src){
		for (int i = 0; i < src.size(); i++) {
		    dst.set(i, src.get(i));
		}
		
	}
	
	public static <T> void copyList_1(List<T> dst, List<T>src){
		for (int i = 0; i < src.size(); i++) {
		    dst.set(i, src.get(i));
		}
		
	}
	
	public static <T> void copyList_2(List<T> dst, List<? extends T>src){
		for (int i = 0; i < src.size(); i++) {
		    dst.set(i, src.get(i));
		}
		
	}
	
	public static <T> void copyList_3(List<? super T> dst, List<T>src){
		for (int i = 0; i < src.size(); i++) {
		    dst.set(i, src.get(i));
		}
		
	}	
	
	
	public static <T> void copy(List<T> dst, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++) {
		    dst.set(i, src.get(i));
		}		
	}
	
	
	public static <T> void print(List<T> list) {
		for(T t: list) {
			System.out.printf("%s\t", t);
		}
	}

}
