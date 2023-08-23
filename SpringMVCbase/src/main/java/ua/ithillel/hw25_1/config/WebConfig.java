package ua.ithillel.hw25_1.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
		value = "ua.ithillel.hw25_1.web.*")
public class WebConfig{
	
}