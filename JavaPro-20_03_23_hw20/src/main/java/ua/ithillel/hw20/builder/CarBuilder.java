package ua.ithillel.hw20.builder;

public class CarBuilder {
		
   public Car buildSmartCar (){
	      Car car = new Car();
	      car.addItem(new Item("small weels", 400));
	      car.addItem(new Item("two seats", 200));
	      car.addItem(new Item("two doors", 300));
	      car.addItem(new Item("small engine", 1000));
	      return car;
	   }  
   
   public Car buildFamilyCar (){
	      Car car = new Car();
	      car.addItem(new Item("middle weels", 600));
	      car.addItem(new Item("six seats", 600));
	      car.addItem(new Item("five doors", 700));
	      car.addItem(new Item("middle engine", 1500));
	      car.addItem(new Item("gps navigator", 500));
	      return car;
	   }  

}
