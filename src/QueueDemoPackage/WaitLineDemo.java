package QueueDemoPackage;

/**
 * From the text 7.9, modified slightly to show all inputs first.
 * @author mhrybyk
 *
 */
public class WaitLineDemo {

	public static void main(String[] args) {
		
		int duration = 20;
		double probability = 0.5;
		int maxTransactionTime = 5;
		
		WaitLine customerLine = new WaitLine();
		System.out.println("Beginning simulation - duration: " + duration +
				" probability: " + probability +
				" maxTransactionTime: " + maxTransactionTime);
		
		customerLine.simulate(duration, probability, maxTransactionTime);
		customerLine.displayResults();
	}

}
