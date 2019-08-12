package com.beverage.factory.entity;

/**
 * 
 * @author rahul
 *
 */
public class Ingredient {
	private String name;
	private Float price;

	/**
	 * Constructor
	 * @param name
	 * @param price
	 */
	public Ingredient(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ingredients [name=" + name + ", price=" + price + "]";
	}

}
