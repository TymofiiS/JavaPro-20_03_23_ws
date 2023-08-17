package ua.ithillel.hw24.SpringCore.Beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ua.ithillel.hw24.SpringCore.Models.BaseStorage;
import ua.ithillel.hw24.SpringCore.Models.Product;

@Scope("singleton")
@Component
public class ProductRepository extends BaseStorage {

	public ProductRepository () {
		this.name = "ProductRepository singleton";
		init();
	}
	
	private void init() {		
		for (int i = 0; i < 5; i++) {
			add(new Product("Product" + i, (double) i));
		}
	}
}
