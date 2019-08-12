package com.beverage.factory.entity;

import java.util.List;

/**
 * 
 * @author rahul
 *
 */
public class Beverage {

	private String name;
	private List<String> ingredients;
	private Float price;

	public Beverage(String name, List<String> ingredients, Float price) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Beverage [name=" + name + ", ingredients=" + ingredients + ", price=" + price + "]";
	}

}
