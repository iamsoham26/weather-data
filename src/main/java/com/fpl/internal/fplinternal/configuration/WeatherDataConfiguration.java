package com.fpl.internal.fplinternal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherDataConfiguration {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
