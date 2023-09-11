package ua.ithillel.hw25.helpers;

import ua.ithillel.hw25.controller.ProductDto;
import ua.ithillel.hw25.persistence.ProductEntity;

public class ProductMapper {
	
	public static ProductEntity fromDto(ProductDto productDto) {
		if(productDto == null) {return null;}
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCost(productDto.getCost());
		productEntity.setName(productDto.getName());
		
		return productEntity;
	}
	
	public static ProductDto toDto(ProductEntity productEntity) {
		if(productEntity == null) {return null;}
		
		ProductDto productDto = new ProductDto();
		productDto.setCost(OrderMapper.round( productEntity.getCost()));
		productDto.setName(productEntity.getName());
		productDto.setId(productEntity.getProductId());
		
		return productDto;
	}
		
}
