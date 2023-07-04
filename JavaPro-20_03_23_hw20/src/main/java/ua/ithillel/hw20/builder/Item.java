package ua.ithillel.hw20.builder;

public class Item {
	
	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String name() {
		return name;
	}

	public float price() {
		return price;
	}
	
	protected String name;
	protected float price;
}
