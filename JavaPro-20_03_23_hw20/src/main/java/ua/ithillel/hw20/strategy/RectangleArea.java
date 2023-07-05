package ua.ithillel.hw20.strategy;

public class RectangleArea implements Strategy {
	
	@Override
	public double calculateArea(int a, int b) {
		return a*b;
	}
}
