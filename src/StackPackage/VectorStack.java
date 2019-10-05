package StackPackage;

import java.util.Vector;

/**
 * A class of stacks whose entries are stored in a vector.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * @author Jeamin Shin
 * added toArray() and size() implementations to reflect modified
 * StackInterface
 */
public final class VectorStack<T> implements StackInterface<T> {
	private Vector<T> stack; // Last element is the top entry in stack

	// Vector class can grow dynamically, so no need to increase
	
	private static final int DEFAULT_CAPACITY = 50;

	public VectorStack() {
		this(DEFAULT_CAPACITY);
	} 

	public VectorStack(int initialCapacity) {
		stack = new Vector<>(initialCapacity); // Size doubles as needed
	}

	@Override
	public void push(T newEntry) {
		stack.add(newEntry);
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			return null;
		}else {
			return stack.remove(stack.size()-1);
		}
		
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}else {
			return stack.lastElement();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		stack.clear();
		
	}

	@Override
	public int size() {
		
		return stack.size();
	}

	@Override
	public T[] toArray() {
		
		//Why is not this.size();?
		T[] tempStack = (T[]) new Object[this.size()];
		return stack.toArray(tempStack);
	} 




}
