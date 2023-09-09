package ua.ithillel.hw25_9.springlombokmigration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import ua.ithillel.hw25_9.springlombokmigration.persistence.Order;
import ua.ithillel.hw25_9.springlombokmigration.persistence.Product;
import ua.ithillel.hw25_9.springlombokmigration.persistence.repository.OrderRepository;
import ua.ithillel.hw25_9.springlombokmigration.persistence.repository.ProductRepository;

@Data
@Service
@Transactional
public class SeederDb {
	
	private OrderRepository orderRepository;
	
	private ProductRepository productRepository;
	
	public void seeding() {
		
		Product p1 = new Product();
		p1.setName("Product1");
		p1.setCost(12.34);
		
		
		
		Product p2 = new Product();
		p2.setName("Product2");
		p2.setCost(22.54);
		
		
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		
		Order order = new Order();
		order.setProducts(products);
		
		
		
		productRepository.save(p1);
		productRepository.save(p2);
		orderRepository.save(order);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(order);
	}
	
}
