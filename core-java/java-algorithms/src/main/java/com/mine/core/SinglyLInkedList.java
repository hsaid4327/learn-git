package com.mine.core;

public class SinglyLInkedList<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLInkedList(Node<E> n){
		head = n;
		head.next = null;
		tail = n;
		size = size+1;
		
	}
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void addToHead (Node<E> n){

		n.next = head;
		head = n;
		size = size+1;
		if(size == 1){
			tail = n;
		}
	}
	
	public void addToTail (Node<E> n) {
		if(isEmpty()){
			addToHead(n);
			return;
		}
		
		tail.next = n;
		n.next = null;
		size = size+1;
		
	}
	
	
	
	public void removeFromHead(){
		if(isEmpty()){
			return ;
		}
		
		head = head.next;
		size = size -1;
		if(isEmpty()){
			tail = null;
		}
	}
	
	private static class Node<E> {
		
		private E element;
		private Node<E> next;		
		
		public Node(E element, Node<E> n) {
			super();
			this.element = element;
			this.next = n;
		}

		public E getElement() {
			return element;
		}



		public Node getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
