package QueueDemoPackage;

/**
 * Customer class
 * For use in simulation of customers waiting in line.
 * 
 * Each customer has an arrival time, and the amount of time the transaction is to take
 * 
 * Each customer is identified by what should be a unique number, but this is not
 * enforced.
 * 
 * @author mhrybyk
 *
 */
public class Customer {
	private int arrivalTime;
	private int transactionTime;
	private int customerNumber;
	
	/**
	 * Create a customer
	 * @param arrivalTime
	 * @param transactionTime
	 * @param customerNumber
	 */
	public Customer(int arrivalTime, int transactionTime, int customerNumber) {
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		this.customerNumber = customerNumber;
	}

	/**
	 * Get the arrival time of the customer
	 * @return
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Get the amount of time for the transaction
	 * @return
	 */
	public int getTransactionTime() {
		return transactionTime;
	}

	/**
	 * Get the customer number
	 * @return
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

}
