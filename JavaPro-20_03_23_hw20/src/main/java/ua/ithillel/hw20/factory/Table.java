package ua.ithillel.hw20.factory;

public class Table implements Furniture {
	@Override
	public void using() {
		System.out.println("Table - put on me");	
	}
}
