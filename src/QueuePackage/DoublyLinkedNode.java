package QueuePackage;

/**
 * From Carrano et al
 * 
 * Subclass of Node adding a previous Node to the data.
 * @author mhrybyk
 *
 * @param <T>
 */
public class DoublyLinkedNode<T> extends Node<T> {

	private DoublyLinkedNode<T> previous; // Link to previous node

	/**
	 * Create a node with next and previous set to null
	 * @param dataPortion
	 */
	public DoublyLinkedNode(T dataPortion) {
		super(dataPortion); // sets next to null as well
		previous = null;
	}

	/**
	 * Create a node with previous set to null.
	 * @param dataPortion
	 * @param nextNode
	 */
	public DoublyLinkedNode(T dataPortion, Node<T> nextNode) {
		super(dataPortion, nextNode);  // set next
		previous = null;
	}

	/**
	 * Create a node with previous and next set by args
	 * @param previousNode
	 * @param dataPortion
	 * @param nextNode
	 */
	public DoublyLinkedNode(DoublyLinkedNode<T> previousNode, T dataPortion, DoublyLinkedNode<T> nextNode) {
		super(dataPortion, nextNode); // set next
		previous = previousNode;
	}

	/**
	 * Gets the previous node
	 * @return
	 */
	public DoublyLinkedNode<T> getPreviousNode() {
		return previous;
	} 

	/**
	 * Sets the previous node
	 * @param previousNode
	 */
	public void setPreviousNode(DoublyLinkedNode<T> previousNode) {
		previous = previousNode;
	} 
	
	/**
	 * Gets the next node
	 * 
	 * @return nextNode
	 */
	public DoublyLinkedNode<T> getNextNode() {
		return (DoublyLinkedNode<T>) super.getNextNode();		
	}
}
