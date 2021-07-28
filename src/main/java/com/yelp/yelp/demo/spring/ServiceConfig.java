package com.yelp.yelp.demo.spring;

import org.springframework.context.annotation.Bean;

import com.yelp.yelp.demo.services.WebScrapperYelpService;
import com.yelp.yelp.demo.services.YelpService;

public class ServiceConfig {
	@Bean
	public YelpService yelpService() {
		return new WebScrapperYelpService();
	}
}
