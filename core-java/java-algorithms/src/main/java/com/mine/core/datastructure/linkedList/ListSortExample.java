package com.mine.core.datastructure.linkedList;

import java.util.Random;

class ListSortExample {
	static class Node {
		int val;
		Node next;

		Node(int v, Node t) {
			val = v;
			next = t;
		}
	}

	static Node create() {
		Node a = new Node(0, null);
		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			int val = random.nextInt(100);
			a.next = new Node(val, a.next);
		}

		return a;
	}

	static Node sort(Node unoderedList) {
		Node t, u, x, orderedList = new Node(0, null);
		while (unoderedList.next != null) {
			t = unoderedList.next;
			u = t.next;
			unoderedList.next = u;
			for (x = orderedList; x.next != null; x = x.next)
				if (x.next.val > t.val)
					break;
			t.next = x.next;
			x.next = t;
		}
		return orderedList;
	}

	static void print(Node h) {
		for (Node t = h.next; t != null; t = t.next)
			System.out.println(t.val + "");
	}

	public static void main(String[] args) {
		print(sort(create()));
	}
}