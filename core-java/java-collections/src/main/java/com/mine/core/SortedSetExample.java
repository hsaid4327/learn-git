package com.mine.core;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {

	public static void main(String[] args) {
		// create TreeSet from array colors
		String[] colors = { "yellow", "green", "black", "tan", "grey", "white",
				"orange", "red", "green" };
		SortedSet<String> tree = new TreeSet<>(Arrays.asList(colors));
		printSet(tree);
		
		System.out.println("-----Printing headset------");
		printSet(tree.headSet("orange"));
		
		System.out.println("------- Printing tailset --------");
		
		printSet(tree.tailSet("orange"));

	}
	
	private static void printSet(Set<String> sortedSet){
		for(String s: sortedSet) {
			System.out.printf(" %s %n", s);
		}
	}

}
