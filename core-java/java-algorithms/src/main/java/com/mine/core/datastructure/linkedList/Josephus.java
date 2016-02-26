package com.mine.core.datastructure.linkedList;

class Josephus {
	static class Node {
		int val;
		Node next;

		Node(int v) {
			val = v;
		}
	}

	public static void main(String[] args) {
		int N = 9;
		int M = 5;
		Node t = new Node(1);
		Node x = t;
		for (int i = 2; i <= N; i++) {
			x.next = new Node(i);
			x= x.next;
		}
		x.next = t;
		while (x != x.next) {
			for (int i = 1; i < M; i++)
				x = x.next;
			x.next = x.next.next;
		}
		System.out.println("Survivor is " + x.val);
	}
}
