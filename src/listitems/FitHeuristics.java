package listitems;

public class FitHeuristics {

	public static void main(String[] args) {
		// example input data
		// create the example items
		Item[] items = new Item[9];
		items[0] = new Item("flour", 0.92, 6000);
		items[1] = new Item("mozzarella", 6.5, 5400);
		items[2] = new Item("olive oil", 5, 720);
		items[3] = new Item("oregano", 16.22, 5);
		items[4] = new Item("salt", 1.88, 96);
		items[5] = new Item("sugar", 1.42, 42);
		items[6] = new Item("tomatoes", 1.868, 5040);
		items[7] = new Item("water", 0.002, 3600);
		items[8] = new Item("yeast", 0.005, 504);
		
		// get sorted list
		System.out.println("Result of Decreasing:");
		System.out.println("-------------------");
		printItem(sortDescending(items));
	}

	// selection sort
	public static Item[] sortDescending(Item[] items) {
		//deep copy the array
		Item[] sorted = new Item[items.length];
		for(int i = 0; i < items.length; i++) {
			sorted[i] = items[i];
		}
	
		// selection sort
		for(int i = 0; i < sorted.length; i++) {
			// find item with largest consumption
			int maxConsumption = i; // index of the element with the highest weight
			for(int j = i + 1; j < sorted.length; j++) {
				if(sorted[j].calcItemConsumption(sorted[j].getUnitPrice(), sorted[j].getQuantity()) > sorted[maxConsumption].calcItemConsumption(sorted[maxConsumption].getUnitPrice(), sorted[maxConsumption].getQuantity())) 
					maxConsumption = j;
				}
			
			// swap the element with the highest index into position i
			Item swap = sorted[i];
			sorted[i] = sorted[maxConsumption];
			sorted[maxConsumption] = swap;
		}
		
		// return the sorted array
		return sorted;	
	}
	
	// assign class depending on value
	public static Item[] assignClass(Item[] items) {
		// get cumulated consumption
		double cumulatedConsumption = 0;
		for(Item item : items) {
			cumulatedConsumption += item.calcItemConsumption(item.getUnitPrice(), item.getQuantity());
		}
		
		// do work to construct A, B and C customer array
		double currentValue = 0;
		
		for(int i = 0; i < items.length; i++) {
			currentValue += items[i].calcItemConsumption(items[i].getUnitPrice(), items[i].getQuantity());
			items[i].setAbcClass("A");
			
			if(currentValue / cumulatedConsumption >= 0.95) {
				items[i].setAbcClass("C");
			} else if(currentValue / cumulatedConsumption >= 0.8) {
				items[i].setAbcClass("B");
			} 
		}
		return items;
	}
	
	// print name of items and class
	public static void printItem(Item[] items) {
		// assign abc class to items
		assignClass(items);
		
		// print
		for(Item item : items) {
			System.out.print(item.getName() + ": " + item.getAbcClass() + " ");
		}
	}
}
