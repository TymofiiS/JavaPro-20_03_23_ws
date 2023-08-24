package ua.ithillel.hw25_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(
		value = "ua.ithillel.hw25_1",
		excludeFilters = {
				@ComponentScan.Filter(type = FilterType.REGEX, pattern = "ua.ithillel.hw25_1.web"),
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebConfig.class)
			}
		)
public class AppConfig{

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
}