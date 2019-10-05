package QueuePackage;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This implements the Queue Interface using the java library Queue interface
 * 
 * Note use of poll/peek/offer methods, which do not throw exceptions when empty
 * @author mhrybyk
 *
 * @param <T>
 */
public class QueueUsingLibraryQueue<T> implements QueueInterface<T> {

	// internal space for queue entries
	
	private Queue<T> queue;

	public QueueUsingLibraryQueue() {
		// need to use one of the classes that implements Queue interface
		queue = new ArrayDeque<>();
//		queue = new LinkedList<>();
	}

	@Override
	public void enqueue(T newEntry) {
		// does not throw an exception if no capacity
		queue.offer(newEntry); 
	}

	@Override
	public T dequeue() {
		if(isEmpty())
			throw new EmptyQueueException();
		return queue.poll();
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		return queue.peek();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void clear() {
		queue.clear();

	}

	@Override
	public int size() {
		return queue.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		return (T[]) queue.toArray();
	}
}
