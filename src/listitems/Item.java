package listitems;

public class Item {
	
	// the item's name
	private String name;
	
	// the item's unit price
	private double unitPrice;
	
	// the item's quantity
	private int quantity;
	
	// the item's class (later assigned)
	private String abcClass;
	
	// constructor
	public Item(String name, double unitPrice, int quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	// getters
	public String getName() {
		return name;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getAbcClass() {
		return abcClass;
	}
	
	// setters
	public void setAbcClass(String abcClass) {
		this.abcClass = abcClass;
	}

	// calculate consumption of item
	public double calcItemConsumption(double unitPrize, int quantity) {
		double consumption = 0;
		consumption = unitPrize * quantity;
		return consumption;				
	}
}
