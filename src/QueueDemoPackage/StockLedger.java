package QueueDemoPackage;

import QueuePackage.*;

/**
 * A class that records the purchase and sale of stocks, and provides the
 * capital gain or loss.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */

public class StockLedger  {
	private QueueInterface<StockPurchase> ledger;

	public StockLedger() {
		// can use any other class that implements QueueInterface here
		
//		ledger = new CompletedLinkedQueue<StockPurchase>();
//		ledger = new CompletedArrayQueue<StockPurchase>();
//		ledger = new CompletedTwoPartCircularLinkedQueue<StockPurchase>();
		ledger = new QueueUsingLibraryQueue<StockPurchase>();
//		ledger = new LinkedQueue<StockPurchase>();
//		ledger = new ArrayQueue<StockPurchase>();
//		ledger = new TwoPartCircularLinkedQueue<StockPurchase>();
	}

	/**
	 * Records a stock purchase in this ledger.
	 * 
	 * @param sharesBought  The number of shares purchased.
	 * @param pricePerShare The price per share.
	 */
	public void buy(int sharesBought, double pricePerShare) {
		while (sharesBought > 0) {
			StockPurchase purchase = new StockPurchase(pricePerShare);
			ledger.enqueue(purchase);
			sharesBought--;
		} 
	} 

	/**
	 * Removes from this ledger any shares that were sold and computes the capital
	 * gain or loss.
	 * 
	 * @param sharesSold    The number of shares sold.
	 * @param pricePerShare The price per share.
	 * @return The capital gain (loss).
	 */
	public double sell(int sharesSold, double pricePerShare) {
		double saleAmount = sharesSold * pricePerShare;
		double totalCost = 0;

		while (sharesSold > 0) {
			StockPurchase share = ledger.dequeue();
			double shareCost = share.getCostPerShare();
			totalCost = totalCost + shareCost;
			sharesSold--;
		} 

		return saleAmount - totalCost; // Gain or loss
	}
	
	/**
	 * Show all stocks in the ledger
	 */
	public void display() {
		Object[] stocks = ledger.toArray();
		
		System.out.println("Stocks held");
		for(Object stock : stocks)
			System.out.println("Stock Price " + ((StockPurchase) stock).getCostPerShare());
	}
} 
