package ua.ithillel.hw25_4.SpringStart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.ithillel.hw25_4.SpringStart.config.AppConfig;
import ua.ithillel.hw25_4.SpringStart.services.CourseService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = 
    			new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	CourseService courseServise = 
    			applicationContext.getBean("courseService", CourseService.class);
    	
    	System.out.println(courseServise.list());
    }
}
