package com.yelp.yelp.demo.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.yelp.yelp.demo.services.APIYelpServiceImpl;
import com.yelp.yelp.demo.services.WebScrapperYelpServiceImpl;
import com.yelp.yelp.demo.services.YelpService;

@Configuration
@PropertySource("classpath:yelp.properties")
public class ServiceConfig {

	@Bean
	public YelpService yelpService(
			@Value("${review.retrieve.method}") String retrieveMethod
	) {
		switch (retrieveMethod) {
			case "webScrapper":
				return new WebScrapperYelpServiceImpl();
			case "api":
				return new APIYelpServiceImpl();
			default:
				return new APIYelpServiceImpl();
		}
	}
}
