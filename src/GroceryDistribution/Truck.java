/**
 * 
 */
package GroceryDistribution;

import StackPackage.*;

/**
 * @author Jeamin Shin
 *
 */
public class Truck<T> {

	//Two String source and destination as request.
	private String destination;
	private String source;
	
	//build stack implementation.
	private StackInterface<GroceryItem> temp = new ArrayStack<GroceryItem>();
//	private StackInterface<GroceryItem> temp = new LinkedStack<GroceryItem>();
//	private StackInterface<GroceryItem> temp = new VectorStack<GroceryItem>();
	
	
	
	
	public Truck() {
		
		this.destination ="";
		this.source = "";
	
	}
	
	public Truck(String des, String sour) {
	
		this.destination = des;
		this.source = sour;
	}
	
	//addGroceryItem to the truck.
	public void addGroceryItem(GroceryItem gr) {
		this.temp.push(gr);
		
	}
	//pull GroceryItem from the truck
	public GroceryItem popGroceryItems() {
		return this.temp.pop();
	}
	//check the last-in item in truck.
	public GroceryItem peekGroceryItem() {
		return this.temp.peek();
	}
	
	//get grocery items in each truck as an array.
	public T[] getArrayOfGroceryItems() {
		return (T[]) this.temp.toArray();
	}
	
	//check the size of Grocery item in the truck.
	public int sizeOfItems() {
		return this.temp.size();
	}
		
	public void displayItems() {
		System.out.println(this.temp.peek().toString());

	}		
	
}

