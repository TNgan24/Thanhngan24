package lab6;

import java.util.NoSuchElementException;

public class MyLinkedList {
	public class Node<E>{
		private E data;
		private Node<E> next;
		
		public Node(E data) {
			this.data = data;
		}
		public Node(E data, Node<E> next) {
			this.data= data;
			this.next = next;
		}
	}
	
	public class SinglyLinkedList<E>{
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size;
		
		public SinglyLinkedList() {
			super();
		}
		
// Returns the number of elements in the list.
		public int size() {
			return this.size;
		}
		
// Returns true if the list is empty, and false otherwise.
		public boolean isEmpty() {
			return size ==0;
		}
// Returns (but does not remove) the first element in the list.
		public E first() {
			if(isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}
			return head.data;
		}
// Returns (but does not remove) the last element in the list.
		public E last() {
			if(isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}
			return tail.data;
		}
// Adds a new element to the front of the list.
		public void addFirst(E e) {
			 Node<E> newest = new Node<>(e);
			 
			 if(isEmpty()) {
				 head = newest;
				 tail = newest;
			 }
			 else {
				 newest.next = head;
				 head = newest;
			 }
			 size = size+1;
		}
// Adds a new element to the end of the list.
		public void addLast(E e) {
			Node<E> newest = new Node<>(e);
			
			if(isEmpty()) {
				head= newest;
				tail = newest;	
			}else {
				newest.next = null;
				tail.next = newest;
				tail = newest;
			}
			size = size+1;
		}
// Removes and returns the first element of the list.
		public E removeFirst() {
			if(isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}
			E firstRemove = head.data;
			head = head.next;
			size = size -1;
			return firstRemove;
		}
// Removes and returns the last element of the list.
		public E removeLast() {
			if(isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}
	
			E lastRemove = tail.data;
			if(size ==1) {
				head = null;
				tail = null;
			}else {
				Node<E> current = head;
				while(current != tail) {
					current = current.next;
				}
				current.next = null;
				tail = current;
			}
			size = size-1;
			return lastRemove;	
		
		}
	
	}
	public static void main(String[] args) {
		MyLinkedList linkList = new MyLinkedList();
		MyLinkedList.SinglyLinkedList<Integer> list = linkList.new SinglyLinkedList<>();
		list.addFirst(3);
		list.addLast(8);
		list.addFirst(4);
		list.addLast(5);
		list.addFirst(10);
		list.addLast(15);
		
		System.out.println("Kich thuoc cua danh sach:" + list.size());
		System.out.println("Phan tu dau tien trong danh sach:" + list.first());
		System.out.println("Phan tu cuoi cung trong danh sach:" + list.last());
		System.out.println("Xoa ptu dau tien trong danh sach:" + list.removeFirst());
		System.out.println("Xoa ptu cuoi cung trong danh sach" + list.removeLast());
	}

}
