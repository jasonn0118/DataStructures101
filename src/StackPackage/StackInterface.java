package StackPackage;

/**
 * An interface for the ADT stack.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * added toArray() and size() to allow for display of stack contents
 */
public interface StackInterface<T> {
	/**
	 * Adds a new entry to the top of this stack.
	 * 
	 * @param newEntry An object to be added to the stack.
	 */
	public void push(T newEntry);

	/**
	 * Removes and returns this stack's top entry.
	 * 
	 * @return The object at the top of the stack or null if empty
	 */
	public T pop();

	/**
	 * Retrieves this stack's top entry.
	 * 
	 * @return The object at the top of the stack or null if empty
	 */
	public T peek();

	/**
	 * Detects whether this stack is empty.
	 * 
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty();

	/**
	 * Removes all entries from this stack.
	 */
	public void clear();
	
	/**
	 * Gets the number of elements in the stack
	 * @return stack size
	 */
	public int size();
	
	/**
	 * Gets a copy of the stack as an array.
	 * 
	 * Top of stack is the last element in the array.
	 * @return copy of the stack
	 */
	public T[] toArray();

}
