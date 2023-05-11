package Milestone;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Store {
	
	/* declare static field Inventory
	 * initialize inventory with a list of products
	 * addProduct adds the product with name, description, price and quantity to a list
	 */
	private static Inventory<Product> inventory = new Inventory<Product>();
	  
	  static {
	    inventory.addProduct(new TShirt("T-shirt", "A short sleeve graphic shirt", 19.99, 15, "Red"));
	    inventory.addProduct(new Sweater("Sweater", "A long sleeve plain shirt", 29.99, 10, "Cotton"));
	    inventory.addProduct(new Pants("Pants", "A pair of jeans", 49.99, 5, "34X36"));
	    inventory.addProduct(new Shorts("Shorts", "A pair of black gym shorts", 19.99, 10, "Medium"));
	    inventory.addProduct(new Weapon("Sword", "A long sharp blade", 99.99, 5, false));
	    inventory.addProduct(new Weapon("Bow and Arrow", "A bow and 12 arrows", 119.99, 5, true));
	    inventory.addProduct(new Armor("Gold Armor", "A full set of gold armor", 299.99, 3, "Gold"));
	    inventory.addProduct(new Armor("Diamond Armor", "A full set of diamond armor", 399.99, 1, "Diamond"));
	    inventory.addProduct(new Health("Health Potion", "Restores health to full", 19.99, 15, 100));
	  }

	  // create a shopping cart object
	  public static void main(String[] args) throws IOException{
	    ShoppingCart<Product> cart = new ShoppingCart<>();
	    //Sorts the products in alphabetical order
	    Collections.sort(inventory.getProducts());
	    // displays inventory & cart
	    displayInventory();
	    displayCart(cart);

	    // reads input
	    Scanner scanner = new Scanner(System.in);

	    /* this loop allows the user to continue to add products to the cart
	     * it asks for a -1 input to complete and go to checkout or -2 to remove
	     * a product from the cart
	     */
	    while (true) {
	      System.out.println("Enter the number of the product you would like to add to the cart."
	          + " Enter -1 when ready to checkout or -2 to remove an item from the cart:");
	      int productNumber = scanner.nextInt();
	      // check if user wants to end checkout
	      if (productNumber == -1) {
	        checkout(cart);
	        writeCartToFile("outputFile.json",cart);
	        break;
	      }
	      
	      // checks whether the value user entered is -2 to remove a product from the cart
	      if (productNumber == -2) {
	    	  System.out.println("Enter the product # of the item you want to remove:");
	    	  int productIndex = scanner.nextInt();
	    	  removeProduct(cart, productIndex);
	      }

	      // finds the product in the cart, adds 1 of product to cart, removes one from inventory
	      Product product = inventory.getProduct(productNumber);
	      int quantity = inventory.getQuantity(product);
	      if (quantity > 0) {
	        cart.addProduct(product);
	        inventory.setQuantity(product, quantity - 1);
	      // If user enters a product # with a product with 0 in inventory
	      } else {
	        System.out.println("Sorry, that product is out of stock.");
	      }
	      displayCart(cart);
	    }
	    writeCartToFile("outputFile.json", cart);
	  }
	  

	  // displays contents of inventory
	  private static void displayInventory() {
	    System.out.println("Inventory:");
	    for (int i = 0; i < inventory.getNumProducts(); i++) {
	      System.out.println(i + ": " + inventory.getProduct(i));
	    }
	  }

	  // displays contents of cart
	  private static<T extends Product> void displayCart(ShoppingCart<T> cart) {
	    System.out.println("Cart:");
	    for (int i = 0; i < cart.getSize(); i++) {
	      System.out.println(cart.getProduct(i));
	    }

	    // prints total to the 2nd decimal place
	    System.out.printf("Total: $%.2f ", cart.getTotal());
	  }
	  
	  // method for removing a product from the cart
	  public static<T extends Product> void removeProduct(ShoppingCart<T> cart, int productIndex) {
		    T product = cart.getProduct(productIndex);
		    if(product != null){
		    	// remove product from cart
		        cart.removeProduct(productIndex);
		        // adds product to inventory
		        inventory.addProduct(product);
		    }else{
		        System.out.println("Product not found in cart.");
		    }
		    
		}

	  // returns to the stores inventory
	  private static<T extends Product> void checkout(ShoppingCart<T> cart) {
	    for (int i = 0; i < cart.getSize(); i++) {
	      T product = cart.getProduct(i);
	      int quantity = inventory.getQuantity(product);
	      inventory.setQuantity(product, quantity + 1);
	    }
	    // total cost and thank you when complete
	    System.out.printf("Total: $%.2f ", cart.getTotal());
	    System.out.println("Thank you for shopping with us!");
	  }
	  
	  private static <T> ArrayList<T> readFromFile(String filename){
		  // Creates a new Array List
		  ArrayList<T> products = new ArrayList<T>();
		  try {
			  // new file object
			  File file = new File(filename);
			  // new scanner
			  Scanner s = new Scanner(file);
			  
			  while(s.hasNext()) {
				  // reads a line of text
				  String json = s.nextLine();
				  // create a new ObjectMapper
				  ObjectMapper objectMapper = new ObjectMapper();
				  // uses the objectMapper to convert the JSON string to product
				  T product = (T) objectMapper.readValue(json, Product.class);
			  }
			  // close scanner
			  s.close();
			  // prints stack trace if an IO error occurs
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  return products;
	  }
			 
	  // method to print total and products of cart to an output file
	  private static<T extends Product> void writeCartToFile(String fileName, ShoppingCart<T> cart) {
		  // adding PrintWriter variable
		  PrintWriter pw;
		  try {
			  // creates a file object
			  File file = new File (fileName);
			  // creates a file writer object
			  FileWriter fw = new FileWriter(file);
			  // initialize PrintWriter with FileWriter
			  pw = new PrintWriter(fw);
			  // gets the list of products in the cart
			  ArrayList<T> products = cart.getProducts();
			  
			  // for loop that goes through the products in the cart
			  for (Product product : products) {
				  // creating ObjectMapper
			  ObjectMapper objectMapper = new ObjectMapper();
			  //  converts the product to a JSON string
			  String json = objectMapper.writeValueAsString(product);
			  // writes the string to the file
			  pw.println(json);
			  }
			  // creating ObjectMapper
			  ObjectMapper objectMapper = new ObjectMapper();
			  // create a HashMap
			  Map<String, Object> totalMap = new HashMap<>();
			  // adds the total of the cart
			  totalMap.put("total", cart.getTotal());
			  // writes in JSON format
			  String totalJson = objectMapper.writeValueAsString(totalMap);
			  // prints the total
			  pw.println(totalJson);
			  // flush and close the PrintWriter
			  pw.flush();
			  pw.close();
			  
		  } catch (IOException e) {
			  // this would print the stack trace of the exception
			  e.printStackTrace();
		  }
	  }
}