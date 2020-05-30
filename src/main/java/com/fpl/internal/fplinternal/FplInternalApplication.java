package com.fpl.internal.fplinternal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpl.internal.fplinternal.configuration.WeatherDataConfiguration;

@SpringBootApplication
@RestController
@RequestMapping("/geocode")
public class FplInternalApplication {

	private static final Logger LOG = LoggerFactory.getLogger(FplInternalApplication.class);

	@Autowired
	WeatherDataConfiguration configuration;
	
	public static void main(String[] args) {
		SpringApplication.run(FplInternalApplication.class, args);
	}

}
