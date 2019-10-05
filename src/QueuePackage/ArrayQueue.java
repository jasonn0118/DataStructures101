package QueuePackage;
/**
 * A class that implements a queue of objects by using an array.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Jeamin Shin
 * @version 5.0
 */
public final class ArrayQueue<T> implements QueueInterface<T> {
	private T[] queue; // Circular array of queue entries and one unused element
	private int frontIndex;
	private int backIndex;

	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrayQueue(int initialCapacity) {

		checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;

	} 

	/**
	 * Throws an exception if the client requests a capacity that is too large.
	 * @param capacity
	 */
	private void checkCapacity(int initialCapacity) {
		if(initialCapacity>MAX_CAPACITY)
			throw new IllegalStateException(					
					"Attempt to create a queue "+"whose capacity exceeds "+"allowed maximum.");
			

	}
	
	private void ensureCapacity() {
		
		//first check to see if array is full which means
		//	we need an additional slot besides the one we need to fill
		//	(hence backIndex+1)
		
		if(frontIndex==nextIndex(backIndex+1)) {
			
			//double size of array
			int oldSize = queue.length;
			int newSize = 2*oldSize;
			checkCapacity(newSize);
			
			//create the larger queue
			//The cast is safe because the new array contains null entries.
			
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			
			//copy the queue contents to the new array.
			copyToArray(tempQueue);
			queue = tempQueue;//set the queue to the array.
			
			//reset front and back indices. front starts at zero again.
			frontIndex = 0;
			//we wanted two slots back from end, so reset this.
			backIndex = oldSize-2;
			
		}
	}
	
	private int nextIndex(int index) {
		return (index+1)%queue.length;
	}

	@Override
	public void enqueue(T newEntry) {
		ensureCapacity();
		
		//increment back index, then set new entry to its slot.
		backIndex = nextIndex(backIndex);
		queue[backIndex] = newEntry;

	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		
		//get the front of the queue
		T front =queue[frontIndex];
		
		//set the current front to null, clearing it
		queue[frontIndex] = null;
		//increment the front
		frontIndex = nextIndex(frontIndex);
		return front;
		
		
		
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return queue[frontIndex];
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == nextIndex(backIndex);
	}

	@Override
	public void clear() {
		if(!isEmpty()) {
			for(int index=frontIndex;index!=nextIndex(backIndex);index=nextIndex(index)) {
				queue[index]=null;
			}
		}
		
		frontIndex=0;
		backIndex=queue.length-1;

	}

	@Override
	public int size() {
		int size = nextIndex(backIndex)-frontIndex;
		if(size<0) {
			size=size+queue.length;
		}
		return size;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] items = (T[]) new Object[size()];
		copyToArray(items);
		return items;
	}
	
	private void copyToArray(T[] array) {
		if(array==null) {
			return;
		}
		if(array.length<size())
			return;
		
		int tempIndex=0;
		for(int currentIndex=frontIndex;currentIndex!=nextIndex(backIndex);currentIndex=nextIndex(currentIndex)) {
			array[tempIndex]=queue[currentIndex];
			tempIndex++;
		}
	}

} 
