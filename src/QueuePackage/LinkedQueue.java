package QueuePackage;

/**
 * A class that implements a queue of objects by using a chain of linked nodes
 * that has both head and tail references.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Jeamin Shin
 * @version 5.0
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
	private Node<T> firstNode; // References node at front of queue
	private Node<T> lastNode; // References node at back of queue
	int numberOfEntries;

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end default constructor

	@Override
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry,null);
		
		//make the new node the next on the chain from the lastNode
		if(isEmpty()) {
			firstNode = newNode;
		}else {
			lastNode.setNextNode(newNode);
		}
		
		//then set the last node to the new node.
		lastNode = newNode;
		numberOfEntries++;
	}

	@Override
	public T dequeue() {
		T front = getFront();
		
		//clear the data in the first node,
		//then skip around it, setting the first node.
		//to its next in the chain.
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		
		//chain is empty.
		if(firstNode==null) {
			lastNode=null;
		}
		numberOfEntries--;
		return front;
	}

	@Override
	public T getFront() {
		if(isEmpty()){
			throw new EmptyQueueException();
		}else {
			return firstNode.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;

	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public T[] toArray() {
		//create a new array;
		@SuppressWarnings("unchecked")
		T[] items = (T[]) new Object[size()];
		
		//walk along the chain, copying the data to the array each iteration.
		int index =0;
		for(Node<T> currentNode = firstNode;currentNode!=null;currentNode=currentNode.getNextNode()) {
			items[index] = currentNode.getData();
			index++;
		}
		
		return items;
	}
} // end LinkedQueue
