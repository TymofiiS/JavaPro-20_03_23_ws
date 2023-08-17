package ua.ithillel.hw24.SpringCore.Beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class CartManager {
	
	public CartManager(Cart cart, ProductRepository productRepository) {
		this.cart = cart;
		this.productRepository = productRepository;
	}
	
	private Cart cart;
	private ProductRepository productRepository;
	
	public void addProductToCartById(int id) {
		cart.add(productRepository.getById(id));
	}

	public void removeProductFromCartById(int id) {
		cart.removeById(id);
	}
	
	public void print() {
		productRepository.print();
		cart.print();
	}
}
