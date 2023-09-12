package ua.ithillel.hw25.persistence.entity;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("ORDER")
@Data
public class OrderEntity {
	@Id
	@Column("ORDER_ID")
	private Long orderId;
	@Column("ORDER_DATE")
	private Timestamp date;
	@Column("ORDER_COST")
	private Double cost=0.0;
	@MappedCollection(idColumn = "ORDER_ID")
	private Set<ProductEntityRef> products = new HashSet<>();
	  
	 public void addProduct(ProductEntity product) {
		 if(product == null) {return;}
		 this.cost+=product.getCost();
	     products.add(new ProductEntityRef(product.getProductId()));
	 }
}
