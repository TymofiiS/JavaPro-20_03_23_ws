package ua.ithillel.hw25.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ua.ithillel.hw25.helpers.OrderMapper;
import ua.ithillel.hw25.helpers.ProductMapper;
import ua.ithillel.hw25.persistence.OrderEntity;
import ua.ithillel.hw25.persistence.ProductEntity;
import ua.ithillel.hw25.persistence.service.OrderEntityService;
import ua.ithillel.hw25.persistence.service.ProductEntityService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	  @Autowired
	  private OrderEntityService orderEntityService;
	
	  @Autowired
	  private ProductEntityService productEntityService;
	  
	  @GetMapping
	public List<OrderDto>  allOrders() {
		  
			 // Read all products from DB
			 List<ProductEntity> allProductEntities = 
					 productEntityService.findAll();
			 
		    // Read all orders from DB with converting to orderDto	 
			List<OrderDto> allOrderDtos =   
					orderEntityService.findAll().stream()
					.map(o ->OrderMapper.toDto(o, allProductEntities) ) 
					.collect(Collectors.toList());
		
			return allOrderDtos;
	}
	  
		@PostMapping(
				value = "/add", 
				consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity  create(@RequestBody OrderDto dto) {
			
			// Check initial data
			if(dto == null || dto.getProducts() == null) {
				return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body("Invalid input data");
				}
			
			  // Convert productDto list to productEntity list and save
			  // each product to DB
			  List<ProductEntity> savedProducts = new ArrayList<ProductEntity>();
			  for (ProductDto productDto : dto.getProducts()) {
				ProductEntity entity =  productEntityService.save(
						ProductMapper.fromDto(productDto));
				savedProducts.add(entity);
			  }
			  
			  // Convert OrderDto to OrderEntity
			  OrderEntity incomeOrder = OrderMapper.fromDto(dto,  savedProducts);
			  
			  // Save order in DB		  
			 OrderEntity savedOrder =  orderEntityService.save(incomeOrder);
			 
			 // Convert OrderEntity to OrderDto
			OrderDto orderDto = OrderMapper.toDto(savedOrder, savedProducts);
			
			return ResponseEntity.ok(orderDto);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity  findById(
				@PathVariable("id") Long id){
			
			// Check initial data
			if(id == null) {
				return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body("Invalid input data");
			}
			
			// Try find OrderEntity by id
			Optional<OrderEntity> result = orderEntityService.getById(id);
			if(result.isEmpty()) {
				return ResponseEntity
			            .status(HttpStatus.BAD_REQUEST)
			            .body("Not found");
			}
			
			 // Read all products from DB
			 List<ProductEntity> allProductEntities = 
					 productEntityService.findAll();
			
			 // Convert OrderEntity to OrderDto
			OrderDto orderDto = OrderMapper.toDto(result.get(), allProductEntities);
			
			return ResponseEntity.ok(orderDto);
		}
}
