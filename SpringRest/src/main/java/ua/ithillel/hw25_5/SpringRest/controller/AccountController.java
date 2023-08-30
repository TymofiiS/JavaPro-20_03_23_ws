package ua.ithillel.hw25_5.SpringRest.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.ithillel.hw25_5.SpringRest.model.Account;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@GetMapping(
			value = "/all", 
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Account> getAccount () {
		List<Account> accounts = Arrays.asList(
			new Account[] {
			new Account("123", "Name 1", BigDecimal.valueOf(123.456)),
			new Account("456", "Name 2", BigDecimal.valueOf(456.789))
		});
		
		return accounts;
	}
	
}
