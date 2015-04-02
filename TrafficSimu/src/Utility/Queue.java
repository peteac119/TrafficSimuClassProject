package Utility;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * Doubly Linked list algorithm is applied in this class.
 * 
 * Main priority of this class is to store data based on data type provided.
 * 
 * @author pichan vasantakitkumjorn
 *
 * @param <Type>
 */

public class Queue<Type> {
	Node head;
	Node tail;
	int sz; 
	// Constructor
	public Queue(){
		head = new Node(null);
		tail = new Node(null);
		head.right = tail;
		tail.left = head;
		sz = 0;
	}
	/**
	 * Number of element in this list.
	 * 
	 * @return int
	 */
	public int size(){
		return sz;
	}
	/**
	 * Get the first element in the list.
	 * 
	 * @return <T>
	 */
	public Type get_Head(){
		return tail.left.data;
	}
	/**
	 * Get the last element in the list.
	 * 
	 * @return <T>
	 */
	public Type get_Tail(){
		return head.right.data;
	}
	/**
	 * Adding element at the head.
	 * 
	 * @param data
	 */
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
	/**
	 * Delete the last element of the list.
	 * 
	 * @return <Type>
	 */
	public Type dequeue(){
		
		if (sz == 0)
			return null;
		
		Type retval = tail.left.data;
		tail.left = tail.left.left;
		tail.left.right = tail;
		
		sz--;
		
		return retval;
	}
	/**
	 * Return a set of current data as iterator.
	 * @return
	 */
	public Iterator<Type> iterator() 
	{
		return new QueueIterator();
	}
	
	/**
	 * Inner class that store data.
	 * @author pete
	 *
	 */
	private class Node{
		
	  private Type data;
	  private Node left;
	  private Node right;
	  
	  private Node(Type x) {  
	    data = x;
	    left = right = null;
	  }
	  
	}
	/**
	 * Iterator class contains a current list of data. 
	 * 
	 * @author pete
	 *
	 */
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
