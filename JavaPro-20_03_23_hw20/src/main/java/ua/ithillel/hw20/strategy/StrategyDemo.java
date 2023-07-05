package ua.ithillel.hw20.strategy;

public class StrategyDemo {
	
	public static void run() {
		
      Context context = new Context(new RectangleArea());		
      System.out.println("RectangleArea : " + context.executeStrategy(10, 5));

      context = new Context(new TriangleArea());		
      System.out.println("TriangleArea : " + context.executeStrategy(10, 5));
	}
}
