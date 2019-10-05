package QueueDemoPackage;

import QueuePackage.*;

/**
 * A driver that demonstrates various implementations of QueueInterface.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @author mhrybyk
 * 
 * Many modifications. Added displayQueue(). Empty queue exceptions caught.
 */
public class QueueTestDriver {
	public static void main(String[] args) {

		System.out.println("Create a queue: ");
		
		QueueInterface<String> myQueue;

		// uncomment the implementation to test
//		myQueue = new CompletedLinkedQueue<>();
		myQueue = new TwoPartCircularLinkedQueue<>();
//		myQueue = new CompletedArrayQueue<>();
		
//		myQueue = new LinkedQueue<>();
//		myQueue = new ArrayQueue<>();
//		myQueue = new TwoPartCircularLinkedQueue<>();	
//		myQueue = new QueueUsingLibraryQueue<>();
		
		System.out.println("isEmpty() returns " + myQueue.isEmpty());
		displayQueue(myQueue);
		System.out.println("Adding to Queue: Joe Jess Jim Jill Jane Jerry");
		myQueue.enqueue("Joe");
		myQueue.enqueue("Jess");
		myQueue.enqueue("Jim");
		myQueue.enqueue("Jill");
		myQueue.enqueue("Jane");
		myQueue.enqueue("Jerry");

		displayQueue(myQueue);
		System.out.println("isEmpty() returns " + myQueue.isEmpty());

		System.out.println("Testing getFront and dequeue:");
		while (!myQueue.isEmpty()) {
			String front = myQueue.getFront();
			System.out.println(front + " is at the front of the queue.");

			front = myQueue.dequeue();
			System.out.println(front + " is removed from the front of the queue.");
		}

		System.out.print("The queue should be empty: ");
		System.out.println("isEmpty() returns " + myQueue.isEmpty());

		System.out.println("Adding to Queue: Joe Jess Jim");
		myQueue.enqueue("Joe");
		myQueue.enqueue("Jess");
		myQueue.enqueue("Jim");
		
		displayQueue(myQueue);

		System.out.println("Testing clear:");
		myQueue.clear();

		System.out.println("isEmpty() returns " + myQueue.isEmpty());

		System.out.println("Adding to Queue: Joe Jess Jim");
		myQueue.enqueue("Joe");
		myQueue.enqueue("Jess");
		myQueue.enqueue("Jim");
		
		displayQueue(myQueue);

		while (!myQueue.isEmpty()) {
			String front = myQueue.getFront();
			System.out.println(front + " is at the front of the queue.");

			front = myQueue.dequeue();
			System.out.println(front + " is removed from the front of the queue.");
		} 

		System.out.print("The queue should be empty: ");
		System.out.println("isEmpty() returns " + myQueue.isEmpty());

		System.out.println("The next calls will throw an exception");

		try {
			System.out.println("myQueue.getFront() called on what should be an empty queue");
			String front = myQueue.getFront();
			System.out.println(front + " is at the front of the queue.");
		} catch (EmptyQueueException e) {
			System.out.println("myQueue.getFront() caught EmptyQueueException: ");
		}
		
		try {
			System.out.println("myQueue.dequeue() called on what should be an empty queue");
			String front = myQueue.dequeue();
			System.out.println(front + " is removed from the front of the queue.");
		} catch (EmptyQueueException e) {
			System.out.println("myQueue.dequeue() caught EmptyQueueException");
		}
	} 
	
	/**
	 * Display all of the items in a queue
	 * @param queue
	 */
	static <T> void displayQueue(QueueInterface<T> queue) {
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
Create a queue: 
isEmpty() returns true
displayQueue(): size 0 items size 0

Adding to Queue: Joe Jess Jim Jill Jane Jerry
displayQueue(): size 6 items size 6
 Joe Jess Jim Jill Jane Jerry
isEmpty() returns false
Testing getFront and dequeue:
Joe is at the front of the queue.
Joe is removed from the front of the queue.
Jess is at the front of the queue.
Jess is removed from the front of the queue.
Jim is at the front of the queue.
Jim is removed from the front of the queue.
Jill is at the front of the queue.
Jill is removed from the front of the queue.
Jane is at the front of the queue.
Jane is removed from the front of the queue.
Jerry is at the front of the queue.
Jerry is removed from the front of the queue.
The queue should be empty: isEmpty() returns true
Adding to Queue: Joe Jess Jim
displayQueue(): size 3 items size 3
 Joe Jess Jim
Testing clear:
isEmpty() returns true
Adding to Queue: Joe Jess Jim
displayQueue(): size 3 items size 3
 Joe Jess Jim
Joe is at the front of the queue.
Joe is removed from the front of the queue.
Jess is at the front of the queue.
Jess is removed from the front of the queue.
Jim is at the front of the queue.
Jim is removed from the front of the queue.
The queue should be empty: isEmpty() returns true
The next calls will throw an exception
myQueue.getFront() called on what should be an empty queue
myQueue.getFront() caught EmptyQueueException
myQueue.dequeue() called on what should be an empty queue
myQueue.dequeue() caught EmptyQueueException


*/
