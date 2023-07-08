package ua.ithillel.hw20.builder;

public class BuilderDemo {
	
	public static void run() {
		
	  CarBuilder cb = new CarBuilder();
		
      Car smart = cb.buildSmartCar();
      System.out.println("Smart car");
      smart.showItems();
      System.out.println("Total Cost: " + smart.getCost());

      Car family = cb.buildFamilyCar();
      System.out.println("\nFamily car");
      family.showItems();
      System.out.println("Total Cost: " + family.getCost());
      
	}
}
