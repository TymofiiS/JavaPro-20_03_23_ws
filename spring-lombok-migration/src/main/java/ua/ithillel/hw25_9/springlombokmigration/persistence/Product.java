package ua.ithillel.hw25_9.springlombokmigration.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("products")
@Data
public class Product {

	@Id
	private Long id;
	
	private String name;
	
	private Double cost;

}
