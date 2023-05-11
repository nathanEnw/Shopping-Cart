package Milestone;
public class Clothes extends Product {

	// constructor with 4 parameters
	public Clothes(String name, String description, double price, int quantity) {
		super(name, description, price, quantity);
	}
	
	// overrides the getPrice method
	@Override
	public double getPrice() {
		return super.getPrice();
	}
	
	// overrides the toString method
	@Override
	public String toString() {
		return super.toString();
	}
}
