package QueueDemoPackage;

import QueuePackage.*;

/**
 * Simulates a waiting line.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class WaitLine {
	private QueueInterface<Customer> line;
	private int numberOfArrivals;
	private int numberServed;
	private int totalTimeWaited;

	public WaitLine() {
		
		// modified to use QueueUsingLibraryQueue, which is based on the java library Queue interface
		// other ADTs can be substituted here, as long as they implement the QueueInterface
		
//		line = new CompletedLinkedQueue<>();
//		line = new CompletedArrayQueue<>();
//		line = new CompletedTwoPartCircularLinkedQueue<Customer>();
		
		line = new QueueUsingLibraryQueue<Customer>();
//		line = new LinkedQueue<>();		
//		line = new TwoPartCircularLinkedQueue<Customer>();
//		line = new ArrayQueue<>();		

		reset();
	} 

	/**
	 * Simulates a waiting line with one serving agent.
	 * 
	 * @param duration           The number of simulated minutes.
	 * @param arrivalProbability A real number between 0 and 1, and the probability
	 *                           that a customer arrives at a given time
	 * @param maxTransactionTime The longest transaction time for a customer
	 */
	public void simulate(int duration, double arrivalProbability, int maxTransactionTime) {
		int transactionTimeLeft = 0;

		// the clock ticks away
		
		for (int clock = 0; clock < duration; clock++) {
			
			// pick a random number. If it is less than the probability, let them in
			if (Math.random() < arrivalProbability) {
				numberOfArrivals++;
				
				// set the transaction time (time the customer waits in the queue)
				
				int transactionTime = (int) (Math.random() * maxTransactionTime + 1);
				Customer nextArrival = new Customer(clock, transactionTime, numberOfArrivals);
				
				line.enqueue(nextArrival);
				System.out.println("Customer " + numberOfArrivals + " enters line at time " + clock
						+ ". Transaction time is " + transactionTime);
				
				
			} 

			// if nobody is waiting just loop back around
			
			if (transactionTimeLeft > 0)
				transactionTimeLeft--;	
			else if (!line.isEmpty()) {
				
				// timer for the customer waiting expired, so dequeue them, and 
				// 
				Customer nextCustomer = line.dequeue();
				transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
				int timeWaited = clock - nextCustomer.getArrivalTime();
				totalTimeWaited = totalTimeWaited + timeWaited;
				numberServed++;
				System.out.println("Customer " + nextCustomer.getCustomerNumber() + " begins service at time " + clock
						+ ". Transaction time left is " + transactionTimeLeft + ". Time waited is " + timeWaited);
			} 
		} 
	} 

	/**
	 * Displays summary results of the simulation.
	 */
	public void displayResults() {
		System.out.println();
		System.out.println("Number served = " + numberServed);
		System.out.println("Total time waited = " + totalTimeWaited);
		double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
		System.out.println("Average time waited = " + averageTimeWaited);
		int leftInLine = numberOfArrivals - numberServed;
		System.out.println("Number left in line = " + leftInLine);
	} // end displayResults

	/** Initializes the simulation. */
	public final void reset() {
		line.clear();
		numberOfArrivals = 0;
		numberServed = 0;
		totalTimeWaited = 0;
	} 
} 
