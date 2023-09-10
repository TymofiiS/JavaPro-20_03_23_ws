package ua.ithillel.hw25.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Table("orders")
@Data
public class OrderEntity {
	@Id
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;
	
	private Double cost;
	
	private List<ProductEntity> products;
}
