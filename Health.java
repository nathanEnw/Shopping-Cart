// // creating a Health class that extends from the Product class
package Milestone;
public class Health extends Product {

	// creates int dose
	private int dose;
	// created a constructor that takes 5 parameters. it contains a unique dose field
	public Health(String name, String description, double price, int quantity, int dose) {
		super(name, description, price, quantity);
		this.dose = dose;
	}
	
	// overrides the getPrice() method
	@Override
	public double getPrice() {
		return super.getPrice();
	}
	
	//getter for Dose
	public double getDose() {
		return dose;
	}
	
	// overrides the original print out
	@Override
	public String toString() {
		return super.toString()+ " Dose: " + dose;
	}
}