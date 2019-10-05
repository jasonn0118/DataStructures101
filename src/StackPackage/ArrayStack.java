package StackPackage;

import java.util.Arrays;

/**
 * A class of stacks whose entries are stored in an array.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @author Jeamin Shin
 * @version 5.0
 */
public final class ArrayStack<T> implements StackInterface<T> {
	private T[] stack; // Array of stack entries
	private int topIndex; // Index of top entry

	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int initialCapacity) {

		checkCapacity(initialCapacity); // do we have enough room?

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		// used to suppress warning generated due to unchecked casting
		// while the later warning is used to remind about adding SerialVersionUID in a
		// Serializable class.

		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;

	}

	/**
	 * Throws an exception if the client requests a capacity that is too large.
	 * 
	 * @param capacity requested capacity
	 */
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a stack " + "whose capacity exceeds " + "allowed maximum.");
	}

	/**
	 * Doubles the size of the array stack if it is full
	 */
	private void ensureCapacity() {
		if (topIndex >= stack.length - 1) {
			// the array is full, so double the size

			int newLength = 2 * stack.length;
			checkCapacity(newLength);

			// copyOf will create a new array with
			// the larger size and copy all elements

			stack = Arrays.copyOf(stack, newLength);
		}
	}

	@Override
	public void push(T newEntry) {
		ensureCapacity();

		stack[topIndex + 1] = newEntry;
		topIndex++;

	}

	@Override
	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			// get the top index
			T top = stack[topIndex];

			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return stack[topIndex];
		}
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void clear() {
		while(topIndex>-1) {
			stack[topIndex]=null;
			topIndex--;
		}

	}

	@Override
	public int size() {
		return topIndex+1;
	}

	@Override
	public T[] toArray() {
		return Arrays.copyOf(stack, this.size());
	}
}
