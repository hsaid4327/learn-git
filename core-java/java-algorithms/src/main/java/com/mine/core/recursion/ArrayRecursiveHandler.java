package com.mine.core.recursion;

public class ArrayRecursiveHandler {

	public static void main(String[] args) {
		int[] data = new int[] {1, 2, 3, 4,5,6,7, 8, 9, 10, 11, 12, 13};
//		System.out.printf("The sum of the array is : %d%n", sum(data, data.length));
//		reverseArray(data, 0, data.length-1);
//		printArray(data);
		System.out.printf("The binary sum of the array is : %d%n", binarySum(data, 0, data.length-1));
	}

	public static int binarySum(int[] data, int low, int high){
		if(low > high)
			return 0;
		else if (low == high)
			return data[low];
		else {
			int mid =( high+low)/2;
			return binarySum(data, low, mid)+binarySum(data, mid+1, high);
		}
	}
	
	
	public static int sum(int[] data, int n) {
		if (n == 0) {
			return 0;
		}
		return data[n - 1] + sum(data, n - 1);
		
	}
	
	public static void reverseArray(int[] data, int low, int high){

		if (low > high){
			return ;
		}
		int temp = data[low];
		data[low] = data[high];
		data[high]= temp;
		
		reverseArray(data, low+1, high-1);
		
	}
	public static void printArray(int[] data){
		for(int n: data){
			System.out.printf("%d\t", n);
		}
	}

}
