package Milestone;
public class Shorts extends Clothes{

	// creating a unique "size" field
	private String size;

	// created a constructor that takes 5 parameters, with size being unique to this subclass
	public Shorts(String name, String description, double price, int quantity, String size) {
		super(name, description, price, quantity);
		this.size = size;
	}
	
	// getter for the size field
	public String getSize() {
		return size;
	}
	
	// overrides the original print out
	@Override
	public String toString() {
		return super.toString() + " Size: " + size;
	}
}
