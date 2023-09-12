package ua.ithillel.hw25.persistence.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25.persistence.entity.ProductEntity;

@Repository
public interface ProductEntityRepository 
	extends ListCrudRepository<ProductEntity, Long> {
	
	@Query("""
			SELECT p.*
			FROM product AS p, order_product AS op
			WHERE op.ORDER_ID= :orderId  AND p.PRODUCT_ID=op.PRODUCT_ID
			""")
	  public List<ProductEntity>  allByOrderId( @Param("orderId") Long orderId);
}
