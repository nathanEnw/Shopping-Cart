// creating a Weapon class that extends from the Product class
package Milestone;
public class Weapon extends Product {
	
	// create a boolean Double
	private boolean Double;
	
	// created a constructor that takes 4 parameters. this is then passed on the superclass' constructor
	public Weapon(String name, String description, double price, int quantity, boolean Double) {
		super(name, description, price, quantity);	
		this.Double = Double;
	}
	
	//overrides the getPrice()
	@Override
	public double getPrice() {
		return super.getPrice();
	}
	
	// getter for Double
	public boolean isDouble() {
		return Double;
	}
	
	// overrides the original print out
	@Override
	public String toString() {
		return super.toString() + " Double weild: " + Double;
	}
}