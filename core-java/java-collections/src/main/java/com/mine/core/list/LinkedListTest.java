package com.mine.core.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		String[] colors = {"black", "yellow", "green", "blue", "violet", "silver"};
		List<String> list1 = new LinkedList<>();
		
		for(String color: colors){
			list1.add(color);
		}
		
		String[] colors2 = {"gold", "white", "brown", "blue", "gray", "silver"};
		
		List<String> list2 = new LinkedList<>();
		
		for(String color: colors2){
			list2.add(color);
			
		}
		list1.addAll(list2);
		printList(list1);
		toUpperCase(list1);
		printList(list1);
		printReverse(list1);
		removeList(list1, 4,7);
		printList(list1);

	}

	private static void removeList(List<String> list1, int i, int j) {
		list1.subList(i, j).clear();
		
	}

	private static void printReverse(List<String> list1) {
		ListIterator<String> it = list1.listIterator(list1.size());
		while(it.hasPrevious()){
			System.out.printf(" %s ", it.previous());
		}
		
	}

	private static void toUpperCase(List<String> list1) {
       for(int i=0; i < list1.size(); i++){
    	   String color = list1.get(i);
    	   list1.set(i, color.toUpperCase());
    	   
       }
		
		
	}

	private static void printList(List<String> list1) {
		System.out.printf("%nlist:%n");
		
		for(String color: list1){
			System.out.printf(" %s ", color);
		}
		System.out.printf("%n");
		
	}

}
