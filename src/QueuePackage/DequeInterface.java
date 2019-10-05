package QueuePackage;
/**
 * An interface for the ADT deque.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Modified to add size() and toArray()
 */
public interface DequeInterface<T> {
	/**
	 * Adds a new entry to the front of this deque.
	 * 
	 * @param newEntry An object to be added.
	 */
	public void addToFront(T newEntry);

	/**
	 * Adds a new entry to the back of this deque.
	 * 
	 * @param newEntry An object to be added.
	 */
	public void addToBack(T newEntry);

	/**
	 * Removes and returns the front entry of this deque.
	 * 
	 * @return front of the deque
	 * @throws  EmptyQueueException if the deque is empty before the operation. 
	 */
	public T removeFront();

	/**
	 * Removes and returns the back entry of this deque.
	 * 
	 * @return back of the deque
	 * @throws  EmptyQueueException if the deque is empty before the operation. 
	 */
	public T removeBack();

	/**
	 * Retrieves the front entry of this deque.
	 * 
	 * @return front of the deque
	 * @throws  EmptyQueueException if the deque is empty before the operation. 
	 */
	public T getFront();

	/**
	 * Retrieves the front entry of this deque.
	 * 
	 * @return back of the deque
	 * @throws  EmptyQueueException if the deque is empty before the operation. 
	 */
	public T getBack();

	/**
	 * Detects whether this deque is empty.
	 * 
	 * @return True if the deque is empty, or false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Removes all entries from this deque.
	 */
	public void clear();
	
	/**
	 * Gets the size of the deque
	 * @return queue size
	 */
	public int size();
	
	/**
	 * Gets an array consisting of a copy of 
	 * all elements in the deque
	 * @return array of queue elements
	 */
	public T[] toArray();
} 
