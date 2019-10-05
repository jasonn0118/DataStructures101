package StackPackage;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * @author jeamin Shin
 * modified to use public Node class
 * 
 * added toArray() and size() implementations to reflect modified
 * StackInterface
 */
public final class LinkedStack<T> implements StackInterface<T> {
	private Node<T> topNode; // References the first node in the chain
	private int numberOfEntries;

	public LinkedStack() {
		topNode = null;
		numberOfEntries = 0;
	}

	@Override
	public void push(T newEntry) {
		//creat a new node, set its next node to the top.
		Node<T> newNode = new Node<T>(newEntry,topNode);
		//set the top to the new node just created.
		topNode = newNode;
		numberOfEntries++;
		
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		
		T top = peek();
		topNode = topNode.getNextNode();
		numberOfEntries--;
		return top;
		
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}else {
			return topNode.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries==0;
	}

	@Override
	public void clear() {
		topNode = null;
		numberOfEntries=0;
		
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public T[] toArray() {
		//create a new array
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[size()];
		//walk along to chain, copying the data to the array each iteration.
		int index =0;//numberOfEntries.
		for(Node<T> currentNode = topNode;currentNode !=null;currentNode= currentNode.getNextNode()) {
			tempStack[index] = currentNode.getData();
			index++;
		}
		return tempStack;
	}


}
