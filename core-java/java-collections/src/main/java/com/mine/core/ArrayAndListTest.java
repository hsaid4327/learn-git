package com.mine.core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayAndListTest {

	public static void main(String[] args) {
		String [] colors = {"Blue", "Yellow", "Magenta", "Green"};
		
		List<String> list = new LinkedList<String>(Arrays.asList(colors));
		list.add("Dubchraba");
		
		for(String color: colors){
			System.out.printf(" %s ", color);
		}
		
		colors = list.toArray(new String[list.size()]);
		colors[0]= "Red";
		
		System.out.println(list);
		

	}

}
