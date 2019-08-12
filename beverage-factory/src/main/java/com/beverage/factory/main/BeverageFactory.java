package com.beverage.factory.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.beverage.factory.entity.Beverage;

/**
 * 
 * @author rahul
 *
 */
public class BeverageFactory {

	public static void main(String[] args) {
		BeverageFactory factory = new BeverageFactory();
		String[] order = { "Chai, -sugar", "Chai", "Coffee, -milk" };
		String result = factory.placeOrder(order);
		System.out.println(" final result :: " + result);
	}

	/**
	 * Method to place order and calculate the bill
	 * 
	 * @param inputOrder
	 */
	public String placeOrder(String[] inputOrder) {
		List<String> orderList = Arrays.asList(inputOrder);
		Float finalTotal = 0.0f;

		if (orderList.size() < 1) {
			return "Each order should have at least one menu item....";
		}
		for (String order : orderList) {
			System.out.println(order);
			String item = order.split(",")[0];

			String[] exclusion = Arrays.copyOfRange(order.split(","), 1, order.split(",").length);
			Set exclusionSet = new HashSet(Arrays.asList(exclusion));
			if (verifyExclustion(item, exclusionSet)) {
				return "An order cannot have all the ingredients in exclusion for a menu item...";
			}
			finalTotal = finalTotal + calculateTotalPerItem(item, exclusionSet);
		}
		return finalTotal.toString() + "$";
	}

	/**
	 * An order cannot have all the ingredients in exclusion for a menu item
	 * 
	 * @param item
	 * @param exclusion
	 * @return
	 */
	private boolean verifyExclustion(String item, Set<String> exclusion) {
		if (exclusion.size() == getMenu().get(item).getIngredients().size()) {
			return true;
		}
		return false;
	}

	/**
	 * Calculate the total per item
	 * 
	 * @param item
	 * @param exclusion
	 * @return
	 */
	private Float calculateTotalPerItem(String item, Set<String> exclusion) {
		System.out.println(" menu : " + item + "  exclusion: " + exclusion.toString());

		Beverage beverage = getMenu().get(item);
		Float itemPrice = beverage.getPrice();
		for (String exlude : exclusion) {
			itemPrice = itemPrice - getPrice(exlude.trim());
		}

		System.out.println("itemPrice :: " + itemPrice);
		return itemPrice;

	}

	/**
	 * Method to get menu
	 * 
	 * @return
	 */
	private Map<String, Beverage> getMenu() {
		Map<String, Beverage> menu = new HashMap<String, Beverage>();
		menu.put("Coffee", new Beverage("Coffee", new ArrayList<String>() {
			{
				add("Coffee");
				add("milk");
				add("sugar");
				add("water");
			}
		}, 5.0f));
		menu.put("Chai", new Beverage("Chai", new ArrayList<String>() {
			{
				add("Tea");
				add("milk");
				add("sugar");
				add("water");
			}
		}, 4.0f));
		menu.put("Banana Smoothie", new Beverage("Banana Smoothie", new ArrayList<String>() {
			{
				add("banana");
				add("milk");
				add("sugar");
				add("water");
			}
		}, 6.0f));
		menu.put("Strawberry Shake", new Beverage("Strawberry Shake", new ArrayList<String>() {
			{
				add("Strawberries");
				add("milk");
				add("sugar");
				add("water");
			}
		}, 7.0f));
		menu.put("Mojito", new Beverage("Mojito", new ArrayList<String>() {
			{
				add("Lemon");
				add("sugar");
				add("water");
				add("soda");
				add("mint");
			}
		}, 7.5f));
		return menu;

	}

	/**
	 * Method to get ingredient price
	 * 
	 * @param ingredient
	 * @return
	 */
	private Float getPrice(String ingredient) {
		return getIngredients().get(ingredient);

	}

	/**
	 * Method to get ingredients map
	 * 
	 * @return
	 */
	private Map<String, Float> getIngredients() {
		Map<String, Float> ingredients = new HashMap<String, Float>();
		ingredients.put("-milk", 1.0f);
		ingredients.put("-sugar", 0.5f);
		ingredients.put("-soda", 0.5f);
		ingredients.put("-mint", 0.5f);
		ingredients.put("-water", 0.5f);
		return ingredients;
	}
}
