package ua.ithillel.hw25.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDto {
	private Long orderId;
	private String date;
	private Double cost;
	private List<ProductDto> products;
}
