package com.mine.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		createMap(myMap);
		displayMap(myMap);

	}

	private static void createMap(Map<String, Integer> map) {
		
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter a String");
       String line = scanner.nextLine();
       scanner.close();
       String[] tokens = line.split(" ");
       
       for(String token: tokens) {
    	  if(map.containsKey(token)) {
    		  int count = map.get(token);
    		  map.put(token, count+1);
    	  }
    	  else {
    		  map.put(token, 1);
    	  }
       }
       
		
	}

	private static void displayMap(Map<String, Integer> myMap) {
		Set<String> keys = myMap.keySet();
		
		Set<String> treeSet = new TreeSet<String>(keys);
		
		System.out.printf("%nMap contains:%nKey\t\tValue%n");
		
		
		for(String key: treeSet){
			System.out.printf("%-20s%s%n", key, myMap.get(key));
		}
		
	}

}
