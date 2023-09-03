package ua.ithillel.hw25_1.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(
		value = "ua.ithillel.hw25_1.web.*")
public class WebConfig{
	
}