package QueueDemoPackage;

import QueuePackage.*;

/**
 * A driver that demonstrates the class LinkedDeque.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Exceptions now caught for empty queue. display method added.
 */
public class LinkedDequeDemo {
	public static void main(String[] args) {

		System.out.println("Create a deque: ");

//		DequeInterface<String> myDeque = new LinkedDeque<>();
		DequeInterface<String> myDeque = new LinkedDeque<>();
		System.out.println("isEmpty() returns " + myDeque.isEmpty());

		System.out.println("Add Jim Jess to front, Jill Jane to back, Joe to front, then Jerry to back");
		System.out.println("Result should be: Joe Jess Jim Jill Jane Jerry");
		myDeque.addToFront("Jim");
		myDeque.addToFront("Jess");

		myDeque.addToBack("Jill");
		myDeque.addToBack("Jane");

		myDeque.addToFront("Joe");
		myDeque.addToBack("Jerry");
		
		displayQueue(myDeque);

		System.out.println("isEmpty() returns " + myDeque.isEmpty());

		System.out.println("Testing getFront, getBack, removeFront, removeBack:");
		String front, back;
		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");

		back = myDeque.getBack();
		System.out.println(back + " is at the back of the deque.");

		front = myDeque.removeFront();
		System.out.println(front + " is removed from the front of the deque.");

		back = myDeque.removeBack();
		System.out.println(back + " is removed from the back of the deque.");

		front = myDeque.getFront();
		System.out.println(front + " is at the front of the deque.");

		back = myDeque.getBack();
		System.out.println(back + " is at the back of the deque.");

		System.out.println("Testing clear:");
		myDeque.clear();
		System.out.println("isEmpty() returns " + myDeque.isEmpty());

		System.out.println("The next calls will throw an exception");

		try {
			System.out.println("myDeque.removeFront() called on what should be an empty queue");
			front = myDeque.removeFront();
			System.out.println(front + " is at the front of the queue.");
		} catch (EmptyQueueException e) {
			System.out.println("myDeque.removeFront() caught EmptyQueueException");
		}
		
		try {
			System.out.println("myDeque.removeBack() called on what should be an empty queue");
			back = myDeque.removeBack();
			System.out.println(back + " is at the front of the queue.");
		} catch (EmptyQueueException e) {
			System.out.println("myDeque.removeBack() caught EmptyQueueException");
		}
	} 
	
	/**
	 * Display all of the items in a deque
	 * @param queue
	 */
	static <T> void displayQueue(DequeInterface<T> queue) {
		T[] items = queue.toArray();
		
		if(items == null) {
			System.out.println("displayQueue(): queue is empty");
			return;
		}
		System.out.println("displayQueue(): size " + queue.size() + " items size " + items.length);
		
		for(T item : items)
			System.out.print(" " + item);
		System.out.println();
	}
}

/*
Create a deque: 
isEmpty() returns true
Add Jim Jess to front, Jill Jane to back, Joe to front, then Jerry to back
Result should be: Joe Jess Jim Jill Jane Jerry
displayQueue(): size 6 items size 6
 Joe Jess Jim Jill Jane Jerry
isEmpty() returns false
Testing getFront, getBack, removeFront, removeBack:
Joe is at the front of the deque.
Jerry is at the back of the deque.
Joe is removed from the front of the deque.
Jerry is removed from the back of the deque.
Jess is at the front of the deque.
Jane is at the back of the deque.
Testing clear:
isEmpty() returns true
The next calls will throw an exception
myDeque.removeFront() called on what should be an empty queue
myDeque.removeFront() caught EmptyQueueException
myDeque.removeBack() called on what should be an empty queue
myDeque.removeBack() caught EmptyQueueException


*/
