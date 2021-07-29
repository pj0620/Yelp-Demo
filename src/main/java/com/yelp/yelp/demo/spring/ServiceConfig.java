package com.yelp.yelp.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.yelp.yelp.demo.services.APIYelpServiceImpl;
import com.yelp.yelp.demo.services.WebScrapperYelpServiceImpl;
import com.yelp.yelp.demo.services.YelpService;

@Configuration
@PropertySource("classpath:yelp-api.properties")
public class ServiceConfig {
	@Bean
	public YelpService yelpService() {
		return new WebScrapperYelpServiceImpl();
//		return new APIYelpServiceImpl();
	}
}
