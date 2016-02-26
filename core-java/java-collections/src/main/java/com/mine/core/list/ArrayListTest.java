package com.mine.core.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ArrayListTest {
	
	public static void main(String args[]){
		List<String> colors = new ArrayList<>();
		String[] colorsToAdd = {"Blue","Green", "Yellow", "Magenta"};
		String [] colorsToRemove = {"Blue", "Green"};
		
		List<String> removeList = new ArrayList<>();
		
		for(String toAdd: colorsToAdd){
			colors.add(toAdd);
		}
				
		for(String toRemove: colorsToRemove){
			removeList.add(toRemove);
		}
		
		removeColors(colors, removeList);
	}

	private static void removeColors(List<String> colors,
			List<String> removeList) {
		
         System.out.println("This is the list of colors");
         System.out.println(colors);
         
         System.out.println("This is the list of colors to remove");
         System.out.println(removeList);
         
         Iterator<String> it = colors.iterator();
         while (it.hasNext()){
        	 String color = it.next();
        	 if(removeList.contains(color)){
        		 it.remove();
        		 
        	 }
         }
		System.out.println("The list after removal");
		System.out.println(colors);
	}
        
}
