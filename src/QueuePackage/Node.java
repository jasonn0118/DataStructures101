package QueuePackage;

/**
 * Node in a linked list. Each node
 * contains data and a link to the next node in the
 * list.
 * 
 * @author mhrybyk
 *
 * @param <T> data type
 */
public class Node<T> {
	private T data; // Entry in bag
	private Node<T> next; // Link to next node

	/**
	 * Create a new node containing data
	 * @param dataPortion
	 */
	public Node(T dataPortion) {
		this(dataPortion, null);
	} 

	/**
	 * Create a new node containing data
	 * and set the next node.
	 * @param dataPortion
	 * @param nextNode
	 */
	public Node(T dataPortion, Node<T> nextNode) {
		data = dataPortion;
		next = nextNode;
	} 

	/**
	 * Get the data from the node
	 * @return
	 */
	public T getData() {
		return data;
	} 

	/**
	 * Set the data in the node
	 * @param newData
	 */
	public void setData(T newData) {
		data = newData;
	} 

	/**
	 * Get the next node
	 * @return
	 */
	public Node<T> getNextNode() {
		return next;
	} 

	/**
	 * Set the next node
	 * @param nextNode
	 */
	public void setNextNode(Node<T> nextNode) {
		next = nextNode;
	} 
} 
