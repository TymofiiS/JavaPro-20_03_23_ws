package ua.ithillel.hw24.SpringCore.Beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ua.ithillel.hw24.SpringCore.Models.BaseStorage;

@Scope("prototype")
@Component
public class Cart extends BaseStorage {
	
	private static int nameIndex = 1;
	
	public Cart () {
		this.name = "Cart" + nameIndex++;
	}
}
