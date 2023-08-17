/*
1. Реалізувати клас Product які складається з: id, назва, ціна
2. Товари зберігаються у класі-біні ProductRepository, у вигляді списку. 
	Цей список ініціалізується даними при старті програми.
3. ProductRepository дозволяє отримати весь список або один товар за ID. 
4. Реалізувати клас-бін Cart для, в який можна додавати та видаляти товари за id.
5. Реалізувати консольну програму для керування кошиком.
5.1 Додавання товару до кошика
5.2 Видалення товару з кошика
6. Щоразу при запиті екземпляра-біна кошика з контексту додатка 
	повинен повертатися новий екземпляр кошика.
ВАЖЛИВО! БД підключати не треба.
 */


package ua.ithillel.hw24.SpringCore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.ithillel.hw24.SpringCore.Beans.Cart;
import ua.ithillel.hw24.SpringCore.Beans.CartManager;
import ua.ithillel.hw24.SpringCore.Beans.ProductRepository;

public class App {
	
	public static final Logger logger = 
			LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		logger.info("Without Spring");
		ProductRepository productRepository = 
				new ProductRepository();				
		Cart cart1 = new Cart();
		Cart cart2 = new Cart();
				
		CartManager cartManager1 = 
				new CartManager(cart1, productRepository);
		cartManager1.addProductToCartById(2);
		cartManager1.addProductToCartById(3);
		cartManager1.addProductToCartById(4);
		cartManager1.removeProductFromCartById(3);		
		
		CartManager cartManager2 = 
				new CartManager(cart2, productRepository);
		cartManager2.addProductToCartById(1);
		cartManager2.addProductToCartById(2);
		cartManager2.addProductToCartById(5);
		cartManager2.removeProductFromCartById(2);
		
		cartManager1.print();
		cartManager2.print();		
		
		
		logger.info("With Spring");
		ApplicationContext ac = 
				new AnnotationConfigApplicationContext(
						"ua.ithillel.hw24.SpringCore.Beans");
		
		CartManager cartManager4 = 
				(CartManager)ac.getBean("cartManager");
		cartManager4.addProductToCartById(7);
		cartManager4.addProductToCartById(8);
		cartManager4.addProductToCartById(9);
		cartManager4.removeProductFromCartById(8);		
		
		CartManager cartManager3 = 
				(CartManager)ac.getBean("cartManager");
		cartManager3.addProductToCartById(6);
		cartManager3.addProductToCartById(7);
		cartManager3.addProductToCartById(10);
		cartManager3.removeProductFromCartById(7);
		
		cartManager4.print();
		cartManager3.print();	
	}
}
