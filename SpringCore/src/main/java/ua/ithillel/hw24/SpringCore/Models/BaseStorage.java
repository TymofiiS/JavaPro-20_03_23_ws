package ua.ithillel.hw24.SpringCore.Models;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseStorage {
	
	public static final Logger logger = 
			LoggerFactory.getLogger(BaseStorage.class);

	private List<Product> products = new ArrayList<>();
	
	protected String name = "";
	
	public void print() {
		logger.info(name);
		for (Product product : products) {
			logger.info(product.toString());
		}
	}
	
	public List<Product> getAll() {
		return products;
	}
	
	public Product getById(int id) {
		return products.stream()
				.filter(p -> p.getId() == id)
			    .findFirst()
			    .orElse(null);
	}
	
	public void add(Product p) {
		if(p == null) {return;}
		products.add(p);
	}
	
	public void removeById(int id) {	
		Product p = getById(id);	
		if(p == null) {return;}
		products.remove(p);
	}

}
