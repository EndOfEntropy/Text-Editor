package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 * @author Mickael Grivolat
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element == null) {
			throw new NullPointerException("MyLinkedList cannot store null pointers.");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> prevNode = tail.prev;
		prevNode.next = newNode;
		newNode.prev = prevNode;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index > MyLinkedList size.");
		}
		
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		E value = node.data;

		return value;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null) {
			throw new NullPointerException("MyLinkedList cannot store null pointers.");
		}
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("Index > MyLinkedList size.");
		}
		
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> nodeAtIndex = head;
		for (int i = 0; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.next;
		}
		LLNode<E> prev = nodeAtIndex.prev;
		prev.next = nodeToAdd;
		nodeToAdd.prev = prev;
		nodeToAdd.next = nodeAtIndex;
		nodeAtIndex.prev = nodeToAdd;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		LLNode<E> nodeToRemove = head;
		for (int i = 0; i <= index; i++) {
			nodeToRemove = nodeToRemove.next;
		}
		// System.out.println(nodeToRemove.data);
		LLNode<E> prev = nodeToRemove.prev;
		LLNode<E> next = nodeToRemove.next;
		//System.out.println(prev.data);
		prev.next = next;
		next.prev = prev;
		size--;
		E value = nodeToRemove.data;
		return value;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (element == null) {
			throw new NullPointerException("MyLinkedList cannot store null pointers.");
		}
		LLNode<E> nodeToSet = head;
		for (int i = 0; i <= index; i++) {
			nodeToSet = nodeToSet.next;
		}
		nodeToSet.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// E.g. you might want to add another constructor
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E theData, LLNode<E> prevNode) {
		this.data = theData;
		this.next = prevNode.next;
		prevNode.next = this;
	}

}
