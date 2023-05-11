// creating an Armor class that extends from the Product class
package Milestone;
public class Armor extends Product {

	// create a String called plating
	private String plating;
	// // created a constructor that takes 5 parameters. it contains a unique String, plating
	public Armor(String name, String description, double price, int quantity, String plating) {
		super(name, description, price, quantity);
		this.plating = plating;
	}
	
	// overrides the getPrice() method
	@Override
	public double getPrice() {
		return super.getPrice();
	}
	
	// getter for plating
	public String getPlating() {
		return plating;
	}
	
	// overrides the original print out
	@Override
	public String toString() {
		return super.toString() + " Plating: " + plating;
	}
}