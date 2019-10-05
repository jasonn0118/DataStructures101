package QueuePackage;

/**
 * An interface for the ADT queue.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Modified to add size() and toArray()
 */
public interface QueueInterface<T> {
	/**
	 * Adds a new entry to the back of this queue. 
	 * Object may be null. Note this is different from java library spec.
	 * 
	 * @param newEntry An object (possibly null) to be added.
	 */
	public void enqueue(T newEntry);

	/**
	 * Removes and returns the entry at the front of this queue.
	 * or an EmptyQueueException if queue is empty.
	 * 
	 * @return object at front of queue 
	 * @throws EmptyQueueException if the queue is empty. 
	 */
	public T dequeue();

	/**
	 * Retrieves the entry at the front of this queue
	 * or an EmptyQueueException if queue is empty.
	 * 
	 * @return object at front of the queue
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public T getFront();

	/**
	 * Detects whether this queue is empty.
	 * 
	 * @return True if the queue is empty, or false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Removes all entries from this queue.
	 */
	public void clear();
	
	/**
	 * Gets the size of the queue
	 * @return queue size
	 */
	public int size();
	
	/**
	 * Gets an array consisting of a copy of 
	 * all elements in the queue
	 * @return array of queue elements
	 */
	public T[] toArray();
}
