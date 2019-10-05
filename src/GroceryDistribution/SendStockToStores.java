package GroceryDistribution;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import QueuePackage.*;
import StackPackage.ArrayStack;
import StackPackage.LinkedStack;
import StackPackage.StackInterface;
import StackPackage.VectorStack;

/**
 * 
 * @author Jeamin Shin
 *
 */
public class SendStockToStores {

	public static void main(String[] args) {

		String fileName = "GroceryItems.csv";
		Scanner textReader = null;

		// your code here

		// create file variable.
		File myFile = new File(fileName);
		String[] myLine = null;
		
		//Create trucks.
		Truck truckFromToronto = new Truck<>("Calgary", "Warehouse");
		Truck truckFromCalgary = new Truck<>("Toronto", "Warehouse");
		Truck truckFromCalifornia = new Truck<>("California", "Warehouse");
		Truck truckToSurrey = new Truck<>("Warehouse", "Surrey");
		Truck truckToNewWestminster = new Truck<>("Warehouse", "New Westminster");
		Truck truckToVancouver = new Truck<>("Warehouse", "Vancouver");
		Truck tempTruck = new Truck<>();//This is temp variable for reversing stack items to display.

		
		//create warehouse(Queue)
		QueueInterface<GroceryItem> wareHouse = new ArrayQueue<GroceryItem>();
//		QueueInterface<GroceryItem> wareHouse = new LinkedQueue<GroceryItem>();
//		QueueInterface<GroceryItem> wareHouse = new TwoPartCircularLinkedQueue<GroceryItem>();

		int weight = 0;//weight for items.

		try {
			//read the csv file.
			textReader = new Scanner(myFile);
			while (textReader.hasNext()) {
				String tempString = textReader.nextLine();
				myLine = tempString.split(",");
				
				//checking source place - Toronto, Calgary, California and put items into proper truck respectively.
				switch (myLine[3]) {
				case "Toronto":
					truckFromToronto.addGroceryItem(
							new GroceryItem(myLine[0], Integer.parseInt(myLine[1]), myLine[2], myLine[3]));
					break;
				case "Calgary":
					truckFromCalgary.addGroceryItem(
							new GroceryItem(myLine[0], Integer.parseInt(myLine[1]), myLine[2], myLine[3]));
					break;
				case "California":
					truckFromCalifornia.addGroceryItem(
							new GroceryItem(myLine[0], Integer.parseInt(myLine[1]), myLine[2], myLine[3]));
					break;
				default:
					break;
				}

			}
			textReader.close();

			//checking the size of truck.
			int i = truckFromCalgary.sizeOfItems();
			System.out.println(
					"=============== Displaying contents of loaded trucks travelling from origin to warehouse");
			System.out.println();
			System.out.println(
					"============== Truck with " + i + " items going from Calgary to BC Warehouse=============");
			
			//processing of reversing stack.
			while (i != 0) {
				tempTruck.addGroceryItem(truckFromCalgary.popGroceryItems());
				i--;
			}
			i = tempTruck.sizeOfItems();
			
			//put it back to the original truck.
			while (i != 0) {
				tempTruck.displayItems();
				truckFromCalgary.addGroceryItem(tempTruck.popGroceryItems());
				//calculate the total weight of items to each source.
				weight += truckFromCalgary.peekGroceryItem().getItemWeight();
				i--;
			}

			i = truckFromCalgary.sizeOfItems();
			while (i != 0) {
				//drop into warehouse
				wareHouse.enqueue(truckFromCalgary.popGroceryItems());
				i--;
			}

			System.out.println("=== Truck Weight " + weight + " kilograms =================================");
			System.out.println();
			//initialize weight.
			weight = 0;

			i = truckFromToronto.sizeOfItems();
			
			System.out.println();
			System.out.println(
					"============== Truck with " + i + " items going from Toronto to BC Warehouse=============");
			while (i != 0) {
				tempTruck.addGroceryItem(truckFromToronto.popGroceryItems());
				i--;
			}
			i = tempTruck.sizeOfItems();
			while (i != 0) {
				tempTruck.displayItems();
				truckFromToronto.addGroceryItem(tempTruck.popGroceryItems());
				weight += truckFromToronto.peekGroceryItem().getItemWeight();
				wareHouse.enqueue(truckFromToronto.popGroceryItems());
				i--;

			}
			i = truckFromToronto.sizeOfItems();
			while (i != 0) {
				wareHouse.enqueue(truckFromToronto.popGroceryItems());
				i--;
			}

			System.out.println("=== Truck Weight " + weight + " kilograms =================================");
			System.out.println();
			weight = 0;

			i = truckFromCalifornia.sizeOfItems();
			
			System.out.println();
			System.out.println(
					"============== Truck with " + i + " items going from California to BC Warehouse=============");
			while (i != 0) {
				tempTruck.addGroceryItem(truckFromCalifornia.popGroceryItems());
				i--;
			}
			i = tempTruck.sizeOfItems();
			while (i != 0) {
				tempTruck.displayItems();
				truckFromCalifornia.addGroceryItem(tempTruck.popGroceryItems());
				weight += truckFromCalifornia.peekGroceryItem().getItemWeight();
				i--;

			}
			i = truckFromCalifornia.sizeOfItems();
			while (i != 0) {
				wareHouse.enqueue(truckFromCalifornia.popGroceryItems());
				i--;
			}

			System.out.println("=== Truck Weight " + weight + " kilograms =================================");
			System.out.println();
			weight = 0;

			//show warehouse total size.
			i = wareHouse.size();
			System.out.println("################ Unloading trucks at warehouse");
			System.out.println("################ Displaying warehouse with " + i + " items");
			//Display method for the queue.
			displayQueue(wareHouse);
			System.out.println("################");
			System.out.println();

			
			int sizeOfWareHouse = wareHouse.size();

			for (int j = 0; j < sizeOfWareHouse; j++) {
				//checking the destination and put the items into a proper truck(destination)
				switch (wareHouse.getFront().getDestination()) {
				case "New Westminster":
					truckToNewWestminster.addGroceryItem(
							new GroceryItem(wareHouse.getFront().getItemName(), wareHouse.getFront().getItemWeight(),
									wareHouse.getFront().getDestination(), wareHouse.getFront().getOrigin()));
					break;
				case "Surrey":
					truckToSurrey.addGroceryItem(
							new GroceryItem(wareHouse.getFront().getItemName(), wareHouse.getFront().getItemWeight(),
									wareHouse.getFront().getDestination(), wareHouse.getFront().getOrigin()));
					break;
				case "Vancouver":
					truckToVancouver.addGroceryItem(
							new GroceryItem(wareHouse.getFront().getItemName(), wareHouse.getFront().getItemWeight(),
									wareHouse.getFront().getDestination(), wareHouse.getFront().getOrigin()));
					break;
				default:
					break;
				}
				//remove the item from warehouse.
				wareHouse.dequeue();

			}

			//checking the size of truck of destination.
			i = truckToNewWestminster.sizeOfItems();

			System.out.println(
					"=============== Displaying contents of loaded trucks travelling from warehouse to destination");
			System.out.println();
			System.out.println("============== Truck with " + i
					+ " items going  from BC Warehouse to New Westminster=============");
			//put into tempTruck for the reversing.
			while (i != 0) {
				tempTruck.addGroceryItem(truckToNewWestminster.popGroceryItems());
				i--;
			}
			i = tempTruck.sizeOfItems();
			while (i != 0) {
				tempTruck.displayItems();
				truckToNewWestminster.addGroceryItem(tempTruck.popGroceryItems());
				//calculate the total weight of items to each destination.
				weight += truckToNewWestminster.peekGroceryItem().getItemWeight();
				i--;

			}

			System.out.println("=== Truck Weight " + weight + " kilograms =================================");
			System.out.println();
			//initialize weight as 0
			weight = 0;

			i = truckToSurrey.sizeOfItems();

			System.out.println();
			System.out.println(
					"============== Truck with " + i + " items going from BC Warehouse to Surrey=============");
			while (i != 0) {
				tempTruck.addGroceryItem(truckToSurrey.popGroceryItems());
				i--;
			}
			i = tempTruck.sizeOfItems();
			while (i != 0) {
				tempTruck.displayItems();
				truckToSurrey.addGroceryItem(tempTruck.popGroceryItems());
				weight += truckToSurrey.peekGroceryItem().getItemWeight();
				i--;

			}

			System.out.println("=== Truck Weight " + weight + " kilograms =================================");
			System.out.println();
			weight = 0;

			i = truckToVancouver.sizeOfItems();

			System.out.println();
			System.out.println(
					"============== Truck with " + i + " items going from BC Warehouse to Vancouver=============");
			while (i != 0) {
				tempTruck.addGroceryItem(truckToVancouver.popGroceryItems());
				i--;
			}
			i = tempTruck.sizeOfItems();
			while (i != 0) {
				tempTruck.displayItems();
				truckToVancouver.addGroceryItem(tempTruck.popGroceryItems());
				weight += truckToVancouver.peekGroceryItem().getItemWeight();
				i--;

			}

			System.out.println("=== Truck Weight " + weight + " kilograms =================================");
			System.out.println();
			weight = 0;

			i = truckToNewWestminster.sizeOfItems();

			System.out.println();
			System.out.println(">>>>>>>>>>>> Unloading Truck with " + i
					+ " items going from BC Warehouse arriving at New Westminster<<<<<<<<<<<<<");
			while (i != 0) {
				truckToNewWestminster.displayItems();
				//unloding items to the each destination.
				truckToNewWestminster.popGroceryItems();
				i--;
			}

			System.out.println();

			i = truckToSurrey.sizeOfItems();

			System.out.println();
			System.out.println(">>>>>>>>>>>> Unloading Truck with " + i
					+ " items going from BC Warehouse arriving at Surrey<<<<<<<<<<<<<");
			while (i != 0) {
				truckToSurrey.displayItems();

				truckToSurrey.popGroceryItems();
				i--;
			}

			System.out.println();

			i = truckToVancouver.sizeOfItems();

			System.out.println();
			System.out.println(">>>>>>>>>>>> Unloading Truck with " + i
					+ " items going from BC Warehouse arriving at Vancouver<<<<<<<<<<<<<");
			while (i != 0) {
				truckToVancouver.displayItems();

				truckToVancouver.popGroceryItems();
				i--;
			}

			System.out.println("Program is end.");
			System.out.println("code by: Jeamin Shin, 300300058");

		} catch (IOException e) {
			e.getMessage();//error catch.
		}

	}

	static <T> void displayQueue(QueueInterface<T> queue) {
		T[] items = queue.toArray();

		if (items == null) {
			System.out.println("displayQueue(): queue is empty");
			return;
		}

		for (T item : items)
			System.out.println(" " + item);
		System.out.println();
	}
}