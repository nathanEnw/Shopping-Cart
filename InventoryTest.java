package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Milestone.Inventory;
import Milestone.Product;

public class InventoryTest {

	@Test
	public void testAddProduct() {
		Inventory<Product> inventory = new Inventory<Product>();
		assertEquals(1, inventory.getProducts().size());
	}

	@Test
	public void testGetProducts() {
		Inventory<Product> inventory = new Inventory<Product>();
		assertEquals(2, inventory.getNumProducts());
	}

	@Test
	public void testRemoveProduct() {
		Inventory<Product> inventory = new Inventory<Product>();
		assertEquals(1, inventory.getProducts().size());
	}

	@Test
	public void testGetProduct() {
		Inventory<Product> inventory = new Inventory<Product>();
		assertEquals(1, inventory.getProducts());
	}

	@Test
	public void testGetNumProducts() {
		Inventory<Product> inventory = new Inventory<Product>();
		assertEquals(2, inventory.getNumProducts());
	}

}
