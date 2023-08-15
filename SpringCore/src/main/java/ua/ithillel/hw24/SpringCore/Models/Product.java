package ua.ithillel.hw24.SpringCore.Models;

public class Product {
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	private static int totalId = 0;
	
	public Product(String name, Double price) {
		this.id = ++totalId;
		this.name = name;
		this.price = price;
	}
	
	private int id;
	public int getId() {
		return id;
	}

	private String name;
	private Double price;

}
