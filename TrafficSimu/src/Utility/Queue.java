package Utility;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Queue<Type> {
	Node head;
	Node tail;
	int sz; 
	
	public Queue(){
		head = new Node(null);
		tail = new Node(null);
		head.right = tail;
		tail.left = head;
		sz = 0;
	}
	
	public int size(){
		return sz;
	}
	
	public Type get_Head(){
		return tail.left.data;
	}
	
	public Type get_Tail(){
		return head.right.data;
	}
	
	public void enqueue(Type data){
		if (data == null)
			return;
		
		Node newData = new Node(data);
		
		if (sz == 0){
			newData.right = tail;
			newData.left = head;
			tail.left = newData;
			head.right = newData;
		}else{
			newData.left = head;
			newData.right = head.right;
			head.right.left = newData;
			head.right = newData;
		}
		sz++;
	}
	
	public Type dequeue(){
		
		if (sz == 0)
			return null;
		
		Type retval = tail.left.data;
		tail.left = tail.left.left;
		tail.left.right = tail;
		
		sz--;
		
		return retval;
	}
	
	public Iterator<Type> iterator() 
	{
		return new QueueIterator();
	}
	
	private class Node{
		
	  private Type data;
	  private Node left;
	  private Node right;
	  
	  private Node(Type x) {  
	    data = x;
	    left = right = null;
	  }
	  
	}
	
	private class QueueIterator implements Iterator<Type>{

		private Node current;
		
		QueueIterator(){
			current = tail.left;
		}
		
		public boolean hasNext() {
			return current.left != null;
		}

		public Type next() {
			
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Type retval = current.data;
			current = current.left;
			return retval;
		}
		
		public void remove() {
			dequeue();
		}
	}

}
