package ua.ithillel.hw25.persistence;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table("ORDER_PRODUCT")
@Data
@AllArgsConstructor
public class ProductEntityRef {
	@Column("PRODUCT_ID")
	Long productId;
}
