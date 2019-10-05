package GroceryDistribution;

/**
 * @author Jeamin Shin
 *
 */
public class GroceryItem {
	
	//create each fields.
	private String itemName;
	private int itemWeight;
	private String destination;
	private String origin;
	
	//constructor
	public GroceryItem(){
		itemName = "";
		itemWeight = 0;
		destination="";
		origin="";
	}
	public GroceryItem(String itemName, int itemWeight,String des,String origin) {
		this.itemName = itemName;
		this.itemWeight = itemWeight;
		this.destination = des;
		this.origin = origin;
	}
	
	//get some ideas.
//	public GroceryItem(String[] tokens) {
//		this.itemName = tokens[0];
//		this.itemWeight = tokens[1];
//		this.destination = tokens[2];
//		this.origin = tokens[3];
//	}
	//getter and setter.
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	//toString.
	@Override
	public String toString() {
		return "GroceryItem [itemName=" + itemName + ", itemWeight=" + itemWeight + ", destination=" + destination
				+ ", origin=" + origin + "]";
	}
	

}
