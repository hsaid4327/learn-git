package com.mine.core;

import java.util.Arrays;

public class InsertionSortExample {

	public static void main(String[] args) {
		Integer[] data = new Integer[]{9, 4, 1};
		insertionSort(data);
		printList(data);

	}
   public static void insertionSort(Integer [] unsortedArray){
	   int n = unsortedArray.length;
	   for(int k= 1; k < n; k++){
		   int cur = unsortedArray[k];
		   int j = k;
		   while(j>0 && unsortedArray[j-1]>cur){
			   unsortedArray[j] = unsortedArray[j-1];
			   j--;
		   }
		   unsortedArray[j] = cur; 
	   }
   }
   
   public static void printList(Integer[] list){
	   for(Integer i: list){
		   System.out.printf("%d%n", i);
	   }
   }
}
