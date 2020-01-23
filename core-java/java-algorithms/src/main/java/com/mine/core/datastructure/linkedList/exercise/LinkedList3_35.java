package com.mine.core.datastructure.linkedList.exercise;

import java.util.Random;

/**
 * Write a method that moves the largest item on a given list to be the final
 * node on the list.
 * 
 * @author hsaid-contractor
 *
 */
public class LinkedList3_35 {

	static class Node {
		int val;
		Node next;

		Node(int v, Node t) {
			val = v;
			next = t;
		}
	}

	static Node create() {
		Node a = new Node(23, null);
		Node x = a;
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			int val = random.nextInt(100);
			Node b = new Node(val, null);
			a.next = b;
			
			a = b;
		}

		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node x = create();
		System.out.println("====== Printing list =========");
		print(x);
		Node n = makeCopy(x);
		System.out.println("====== Printing list with largest moved =========");
		print(n);

	}

	private static Node moveLargest(Node x) {
		Node current = x;
		Node largest = current;
		Node previous = current;
		while (current.next != null) {
			if (current.next.val > largest.val) {
				// System.out.println("Current val --->" + current.val);
				// System.out.println("Current next --->" + current.next.val);
				largest = current.next;
				previous = current;
			}
			current = current.next;

		}
		// now move the largest to the end.
		System.out.println("The largest value is ----->" + largest.val);
		previous.next = largest.next;
		Node endPointer = current.next;
		current.next = largest;
		largest.next = endPointer;
		return x;
	}

	/**
	 * This methods moves the smallest node to the beginning of the list
	 * 
	 * @param x
	 * @return
	 */
	private static Node moveSmallest(Node x) {
		Node current = x;
		// Node first = current;
		Node smallest = current;
		Node previous = current;
		while (current.next != null) {
			if (current.next.val < smallest.val) {
				smallest = current.next;
				previous = current;
			}
			current = current.next;
		}
		if (smallest != x) {
			previous.next = smallest.next;
			// Node firstNext = x.next;
			smallest.next = x;
		}
		return smallest;

	}

	
	static Node makeCopy(Node x) {
		Node a = new Node(x.val, null);
		Node start = a;
		
		while(x.next != null) {
			Node b = new Node(x.next.val, null);
			a.next= b;
			x = x.next;
			a = b;
		}
		return start;
	}
	
	static void print(Node h) {
		for (Node t = h; t != null; t = t.next)
			System.out.println(t.val + "");
	}

}
