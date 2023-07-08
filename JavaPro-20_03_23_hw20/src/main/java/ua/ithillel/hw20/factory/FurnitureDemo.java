package ua.ithillel.hw20.factory;

import ua.ithillel.hw20.factory.FurnitureFactory.byUsing;

public class FurnitureDemo {
	
	public static void run() {
		
		Furniture f1 = FurnitureFactory.getByUsing(byUsing.PutOn);
		f1.using();
		
		Furniture f2 = FurnitureFactory.getByUsing(byUsing.SeatOn);
		f2.using();
	}
}
