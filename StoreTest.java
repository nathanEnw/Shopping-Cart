package test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;

import org.junit.Test;

import Milestone.Inventory;
import Milestone.Product;
import Milestone.Store;
import Milestone.TShirt;

public class StoreTest {

	@Test
	public void testRemoveProduct() {
		Inventory<Product> inventory = new Inventory<Product>();
		Product product = new TShirt ("T-Shirt","A short sleeve graphic shirt", 19.99, 15, "Red");
		inventory.removeProduct(product);
		assertEquals(0, inventory.getNumProducts());
	}

}
