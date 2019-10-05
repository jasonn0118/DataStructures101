package QueuePackage;

/**
 * A class that implements the ADT deque by using a doubly linked chain of
 * nodes.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Jeamin Shin
 * @version 5.0
 */
public class LinkedDeque<T> implements DequeInterface<T> {
	private DoublyLinkedNode<T> firstNode; // References node at front of deque
	private DoublyLinkedNode<T> lastNode; // References node at back of deque

	int numberOfEntries;

	public LinkedDeque() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}

	@Override
	public void addToFront(T newEntry) {
		
		//instead, previous node is null, and next is the start of the list.
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(null,newEntry,firstNode);
		
		//if first and last are null, set last to the new node
		//otherwise set the previous node for the start of the list to this one
		
		if(isEmpty()) {
			lastNode=newNode;
		}else {
			firstNode.setPreviousNode(newNode);
		}
		
		//links are all fixed up, make the first node this one
		firstNode = newNode;
		numberOfEntries++;
	}

	@Override
	public void addToBack(T newEntry) {
		// set the previous node for the entry, and next is null.
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(lastNode, newEntry, null);

		// if both are null, just need to set the first one
		// otherwise lastNode's next is set to null, so set it to this one.
		if (isEmpty()) {
			firstNode = newNode;
		} else
			lastNode.setNextNode(newNode);

		// finally make the new node the last node, now that all the links are fixed up.

		lastNode = newNode;
		numberOfEntries++;

	}

	@Override
	public T removeFront() {
		T front = getFront();
		
		if(front==null) {
			return null;
		}
		
		//skip around node, resetting first node to the next on the chain
		//make sure the previous node is also set to null
		
		firstNode = firstNode.getNextNode();
		
		if(firstNode==null){
			lastNode = null;
		}else {
			firstNode.setPreviousNode(null);
		}
		
		numberOfEntries--;
		return front;
	}

	@Override
	public T removeBack() {
		T back = getBack();
		
		if(back==null)
			return null;
		
		//move the lastNode to the one before then set its next to null
		lastNode = lastNode.getPreviousNode();
		
		if(lastNode==null) {
			firstNode = null;
		}else {
			lastNode.setNextNode(null);
		}
		
		numberOfEntries--;
		
		return back;
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	}

	@Override
	public T getBack() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return lastNode.getData();
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
		// create a new array
		@SuppressWarnings("unchecked")
		T[] items = (T[]) new Object[size()];

		// walk along the chain, copying the data to the array each iteration.
		int index = 0;
		for (Node<T> currentNode = firstNode; currentNode != null; currentNode = currentNode.getNextNode()) {
			items[index] = currentNode.getData();
			index++;
		}

		return items;
	}

}
