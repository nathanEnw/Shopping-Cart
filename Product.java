package Milestone;
import Interfaces.Purchasable;
public abstract class Product implements Purchasable, Comparable<Product>{
	// four private fields
	private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /* the code below has getters and setters for the private fields initialized above
     * this allows us to retrieve the values in the private fields and update them
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    private int productID;
    
    public int getProductID() {
    	return productID;
    }

    // Overrides and returns a String representation of the Product
    @Override
    public String toString() {
        return name + " - " + description + " - $" + price + " x " + quantity;
    }
    
    // An override to compare names of the products
    @Override
    public int compareTo(Product other) {
    	return this.name.compareTo(other.name);
    }

}