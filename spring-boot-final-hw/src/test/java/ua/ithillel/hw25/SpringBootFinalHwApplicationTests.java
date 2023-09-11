package ua.ithillel.hw25;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ua.ithillel.hw25.controller.OrderDto;
import ua.ithillel.hw25.controller.ProductDto;
import ua.ithillel.hw25.helpers.OrderMapper;
import ua.ithillel.hw25.helpers.ProductMapper;
import ua.ithillel.hw25.persistence.OrderEntity;
import ua.ithillel.hw25.persistence.ProductEntity;
import ua.ithillel.hw25.persistence.service.OrderEntityService;
import ua.ithillel.hw25.persistence.service.ProductEntityService;

@SpringBootTest
class SpringBootFinalHwApplicationTests {

	  @Autowired
	  private OrderEntityService orderEntityService;
	
	  @Autowired
	  private ProductEntityService productEntityService;
	  
	  @Test
	  @DisplayName("save-income-order-test")
	  void saveIncomeOrderTest() {
		  
		  // Prepare productDto list
		  List<ProductDto> productDtos = new ArrayList<ProductDto>();
		  for (int i = 0; i < 5; i++) {
			  int randomNum = ThreadLocalRandom.current().nextInt(0, 10000);
			  ProductDto productDto = new ProductDto();
			  productDto.setCost(randomNum*1.0/100);
			  productDto.setName("Product_" + randomNum);
			  productDtos.add(productDto);
		  }
		  
		  // Create orderDto with properties
		  OrderDto orderDto = new OrderDto();
		  orderDto.setProducts(productDtos);
		  
		  
		  // Convert productDto list to productEntity list and save
		  // each product to DB
		  List<ProductEntity> savedProducts = new ArrayList<ProductEntity>();
		  for (ProductDto productDto : productDtos) {
			ProductEntity entity =  productEntityService.save(
					ProductMapper.fromDto(productDto));
			savedProducts.add(entity);
		}
		  
		  // Convert OrderDto to OrderEntity
		  OrderEntity incomeOrder = 
				  OrderMapper.fromDto(orderDto,  savedProducts);
		  
		  // Save order in DB		  
		 OrderEntity savedOrder =  orderEntityService.save(incomeOrder);
		 Assertions.assertNotNull(savedOrder); 
		 
		 // Read all products from DB
		 List<ProductEntity> allProductEntities = 
				 productEntityService.findAll();
		 
	    // Read all orders from DB with converting to orderDto	 
		List<OrderDto> allOrderDtos =   
				orderEntityService.findAll().stream()
				.map(o ->OrderMapper.toDto(o, allProductEntities) ) 
				.collect(Collectors.toList());
	 
		allOrderDtos.forEach(b -> System.err.println(b));
	  }
	  	  
	  @Test
	  @DisplayName("many-to-many-mapping-test")
	  void embeddedMappingTest() {
		
		  // Create products and save them in DB
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10000);		  
	    ProductEntity  subj1 = productEntityService.save(getProduct("Product_" + randomNum+1, 12.34));
	    ProductEntity  subj2 = productEntityService.save(getProduct("Product_"+ randomNum+2, 22.44));
	    ProductEntity  subj3 = productEntityService.save(getProduct("Product_" + randomNum+3, 33.55));
	    
	    // Create new order with products
	    OrderEntity order1 = getOrder();
	    order1.addProduct(subj1);
	    order1.addProduct(subj2);
	    
	    // Save new order in DB
	    OrderEntity createdOrder1 = orderEntityService.save(order1);
	    Assertions.assertNotNull(createdOrder1);   
	    
	 // Create new order with products
	    OrderEntity order2 = getOrder();
	    order2.addProduct(subj1);
	    order2.addProduct(subj3);
	    
	 // Save new order in DB
	    OrderEntity createdOrder2 = orderEntityService.save(order2);
	    Assertions.assertNotNull(createdOrder2);   
	    
	    // Get one order from DB
	    OrderEntity orderForDelete = orderEntityService.getById(order1.getOrderId()).get();
	    Assertions.assertNotNull(orderForDelete);
	    
	    // Delete from DB one order
	    orderEntityService.delete(orderForDelete);
	    Assertions.assertTrue(!orderEntityService.existsById(order1.getOrderId()));
	    
	    // Read all orders from DB
	    orderEntityService.findAll().forEach(b -> System.err.println(b));
	  }
	  
		  private ProductEntity getProduct(String name, Double cost) {
			  ProductEntity productEntity = new ProductEntity();
			  productEntity.setCost(cost);
			  productEntity.setName(name);
			  return productEntity;
		}
	  
		private OrderEntity getOrder() {		
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setDate(new Timestamp(System.currentTimeMillis()));		
			return orderEntity;
		}
	  
}
