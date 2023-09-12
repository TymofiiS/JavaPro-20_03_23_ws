package ua.ithillel.hw25.controller.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.text.SimpleDateFormat;
import ua.ithillel.hw25.controller.dto.OrderDto;
import ua.ithillel.hw25.controller.dto.ProductDto;
import ua.ithillel.hw25.persistence.entity.OrderEntity;
import ua.ithillel.hw25.persistence.entity.ProductEntity;
import ua.ithillel.hw25.persistence.entity.ProductEntityRef;

public class OrderMapper {
	
	private static final SimpleDateFormat sdf3 = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Double round(Double a) {
		return Math.round(a * 100.0) / 100.0;
	}
	
	public static OrderEntity fromDto(
			OrderDto orderDto, List<ProductEntity> savedProducts) {
		
		OrderEntity order = new OrderEntity();
		order.setDate(new Timestamp(System.currentTimeMillis()));
		
		if(savedProducts == null ) {return order;}
		
		for (ProductEntity productEntity : savedProducts) {
			order.addProduct(productEntity);
		}
		return order;
	}
	
	public static OrderDto toDto(
			OrderEntity order, List<ProductEntity> allSavedProducts) {
	
		if(order == null) {return null;}
		
		// Matching properties
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(order.getOrderId());
		orderDto.setDate( sdf3.format(order.getDate()));
		orderDto.setCost(round(order.getCost()));
		
		// Check if order contains products
		if(order.getProducts() == null || allSavedProducts == null)
		{return orderDto;}
		
		// Convert list productEntity to list productDto
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (ProductEntityRef productRef : order.getProducts()) {
			
			Optional<ProductEntity> matchingObject = 
					allSavedProducts.stream()
				    .filter(p -> p.getProductId() .equals(productRef.getProductId()))
				    .findFirst();
			if(matchingObject.isEmpty()) {continue;}
			
			productDtos.add(ProductMapper.toDto(matchingObject.get()));
		}
		
		// Matching list of products
		orderDto.setProducts(productDtos);
		
		// Return result
		return orderDto;	
	}
		
}
