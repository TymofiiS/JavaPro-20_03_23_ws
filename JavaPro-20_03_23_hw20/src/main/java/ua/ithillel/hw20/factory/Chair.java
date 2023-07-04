package ua.ithillel.hw20.factory;

public class Chair implements Furniture {
	@Override
	public void using() {
		System.out.println("Chair - seat on me");	
	}
}
