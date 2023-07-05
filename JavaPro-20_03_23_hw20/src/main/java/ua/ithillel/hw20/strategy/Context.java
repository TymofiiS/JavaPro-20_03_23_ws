package ua.ithillel.hw20.strategy;

public class Context {
	
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public double executeStrategy(int num1, int num2){
      return strategy.calculateArea(num1, num2);
   }
}
