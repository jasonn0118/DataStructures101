package QueuePackage;
/**
 * A class that implements the ADT queue by using a two-part circular chain of
 * linked nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Jeamin Shin
 * @version 5.0
 */
public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T> {
	private Node<T> queueNode; // References first node in queue
	private Node<T> freeNode; // References node after back of queue, chain of unallocated nodes
	int numberOfEntries;

	public TwoPartCircularLinkedQueue() {
		freeNode = new Node<>(null, null);
		freeNode.setNextNode(freeNode);   // links to itself
		queueNode = freeNode;  // queueNode will be at the top of the chain
	    numberOfEntries = 0;
	} // end default constructor

	@Override
	public void enqueue(T newEntry) {
		freeNode.setData(newEntry);
		if(isNewNodeNeeded()) {
			
			//allocate a new node (null) and insert it after the node that freeNode reference
			Node<T> newNode = new Node<>(null,freeNode.getNextNode());
			freeNode.setNextNode(newNode);
		}
		//we have a null as next node, so set free node to it.
		freeNode = freeNode.getNextNode();
		numberOfEntries++;
	}
	
	private boolean isNewNodeNeeded() {
		return queueNode == freeNode.getNextNode();
	}

	@Override
	public T dequeue() {
		//get the front of the queue
		T front = getFront();
		
		//clear the data, and set the front to the next node.
		queueNode.setData(null);
		queueNode=queueNode.getNextNode();
		
		numberOfEntries--;
		return front;
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return queueNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return queueNode==freeNode;
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			dequeue();
		}
		
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public T[] toArray() {
		//create new array.
		@SuppressWarnings("unchecked")
		T[] items = (T[]) new Object[size()];
		
		//walk along the chain, copying the data to the array each iteration
		//note that the end of the queue is at freeNode
		
		int index = 0;
		for(Node<T> node=queueNode; node != freeNode; node = node.getNextNode()) {
			items[index]=node.getData();
			index++;
		}
		//ok to return an array with no items.
		return items;
		
	}


	
} 
