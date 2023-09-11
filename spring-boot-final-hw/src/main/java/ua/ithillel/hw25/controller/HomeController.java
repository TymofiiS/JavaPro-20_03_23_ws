package ua.ithillel.hw25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {
	
	  @GetMapping
	public String home() {
		  String s = 
				"""
		  		Welcome 
		  		to get all orders: /orders 	  		
		  		to get an order by id: /orders/{id} 	  		
		  		to add order: /orders/add 
			  		with data: 
			  		 {
				        "products": [
				            {
				                "name": "Product_AAA",
				                "cost": 11.11
				            },
				            {
				                "name": "Product_BBB",
				                "cost": 22.22
				            }
			  		    ]
			  		}
		  		""";
		return s;
	}
	
	@GetMapping("ping")
	public String ping() {
		return "OK";
	}

}
