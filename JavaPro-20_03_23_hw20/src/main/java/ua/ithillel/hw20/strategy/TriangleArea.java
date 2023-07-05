package ua.ithillel.hw20.strategy;

public class TriangleArea implements Strategy {

	@Override
	public double calculateArea(int base, int height) {
		return base*height/2.0;
	}

}
