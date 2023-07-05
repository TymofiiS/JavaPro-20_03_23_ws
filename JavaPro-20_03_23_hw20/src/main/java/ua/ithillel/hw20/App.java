/*
Реалізувати шаблон проектування "Фабрика" для створення різних типів меблів
Реалізувати шаблон проектування "Будівельник" для створення автомобіля з багатьох частин
Реалізувати шаблон проектування "Стратегія" для обчислення площі фігур: Прямокутник, Трикутник
 */

package ua.ithillel.hw20;

import ua.ithillel.hw20.builder.BuilderDemo;
import ua.ithillel.hw20.factory.FurnitureDemo;
import ua.ithillel.hw20.strategy.StrategyDemo;

public class App {
    
    public static void main(String[] args) {
    	
    	System.out.println("\nhw20. Factory pattern.\n");
    	FurnitureDemo.run();
    	
    	System.out.println("\nhw20. Builder pattern.\n");
    	BuilderDemo.run();
    	
    	System.out.println("\nhw20. Strategy pattern.\n");
    	StrategyDemo.run();
    }
    
}
