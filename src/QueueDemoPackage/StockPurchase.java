package QueueDemoPackage;

/**
 * StockPurchase class, used in StockLedger.
 * 
 * This simply has a cost per share
 * 
 * @author mhrybyk
 *
 */
public class StockPurchase {
	private double cost;

	public StockPurchase(double cost) {
		this.cost = cost;
	}

	public double getCostPerShare() {
		return cost;
	}
}
