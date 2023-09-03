package ua.ithillel.hw25_4.SpringStart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ua.ithillel.hw25_4.SpringStart")
public class AppConfig {
	
/*
	@Bean("courseRepository")
	public CourseRepository getCourseRepository() {
		return new CourseRepository();
	}
	
	@Bean("courseService")
	public CourseService getCourseService() {
		return new CourseService(getCourseRepository());
	}
*/
}
