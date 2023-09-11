package ua.ithillel.hw25.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("PRODUCT")
@Data
public class ProductEntity {
	@Id
	@Column("PRODUCT_ID")
	private Long productId;
	@Column("PRODUCT_NAME")
	private String name = "Unonim product";
	@Column("PRODUCT_COST")
	private Double cost = 0.0;
}
