package ua.ithillel.hw25.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("products")
@Data
public class ProductEntity {
	@Id
	private Long id;
	private String name;
	private Double cost;
}
