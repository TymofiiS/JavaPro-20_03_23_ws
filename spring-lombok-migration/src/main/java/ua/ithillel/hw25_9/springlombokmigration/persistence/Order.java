package ua.ithillel.hw25_9.springlombokmigration.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("orders")
@Data
public class Order {
	
	@Id
	private Long id;
	
	private LocalDateTime date;
	
	private Double cost;
	
	private List<Product> products;
}
