/**
 * 
 */
package princeton.stackqueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author hoavu
 *
 */
public class Stack<Item> implements Iterable<Item> {
	private Node<Item> first; // top of stack
	private int N;
	
	private class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
	// constructor
	public Stack() {
		first = null;
		N = 0;
	}
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	public void push(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	// return but does not remove the item most recently added
	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item: this)
			s.append(item + " ");
		return s.toString();
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<Item>(first);
	}
	
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;
		public ListIterator(Node<Item> first) {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		
		try {
			FileReader file = new FileReader("tobe.txt");
    		BufferedReader buff = new BufferedReader(file);
    		String line = buff.readLine();
    		
    		String[] array = line.split(" ");
    		for (String item: array) {
    			if (!item.equals("-")) s.push(item);
    			else if (!s.isEmpty()) System.out.println(s.pop());
    		}
    		
    		buff.close();
		} catch (IOException e) {
    		System.out.println("Error reading file");
    	}
	}
}
