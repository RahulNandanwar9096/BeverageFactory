package com.beverage.factory.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author rahul
 *
 */
public class BeverageFactoryTest {

	@Test
	public void testSingleOrder() {
		String[] order = { "Chai" };
		String result = new BeverageFactory().placeOrder(order);
		assertEquals("4.0$", result);
	}

	@Test
	public void testSingleOrderExclusion() {
		String[] order = { "Chai, -sugar" };
		String result = new BeverageFactory().placeOrder(order);
		assertEquals("3.5$", result);
	}

	@Test
	public void testSingleOrderMultipleExclusion() {
		String[] order = { "Chai, -sugar, -milk" };
		String result = new BeverageFactory().placeOrder(order);
		assertEquals("2.5$", result);
	}

	@Test
	public void testMultipleOrder() {
		String[] order = { "Chai", "Coffee" };
		String result = new BeverageFactory().placeOrder(order);
		assertEquals("9.0$", result);
	}

	@Test
	public void testMultipleOrderExclusion() {
		String[] order = { "Chai, -sugar", "Chai", "Coffee, -milk" };
		String result = new BeverageFactory().placeOrder(order);
		assertEquals("11.5$", result);
	}

	@Test
	public void testOrder() {
		String[] order = {};
		String result = new BeverageFactory().placeOrder(order);
		assertEquals("Each order should have at least one menu item....", result);
	}

	@Test
	public void testOrderExclustion() {
		String[] order = { "Chai, -sugar, -milk,-Tea,-water" };
		String result = new BeverageFactory().placeOrder(order);
		assertEquals("An order cannot have all the ingredients in exclusion for a menu item...", result);
	}
}
