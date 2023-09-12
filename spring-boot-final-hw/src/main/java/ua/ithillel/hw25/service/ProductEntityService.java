package ua.ithillel.hw25.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.ithillel.hw25.persistence.entity.ProductEntity;
import ua.ithillel.hw25.persistence.repository.ProductEntityRepository;

@Service
@Transactional
public class ProductEntityService {
	
	@Autowired
	private ProductEntityRepository productEntityRepository;
	
	public ProductEntity save(ProductEntity productEntity) {
		return productEntityRepository.save(productEntity);
	}
	
	public List<ProductEntity> findAll() {
		return productEntityRepository.findAll();
	}
	
	 public List<ProductEntity>  allByOrderId( Long orderId){
		 return productEntityRepository.allByOrderId(orderId);
	 }

}
