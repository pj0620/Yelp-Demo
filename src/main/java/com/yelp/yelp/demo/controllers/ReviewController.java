package com.yelp.yelp.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yelp.yelp.demo.services.YelpService;
import com.yelp.yelp.demo.spring.ServiceConfig;

@RestController
@Import({ServiceConfig.class})
public class ReviewController {
	@Autowired
	YelpService yelpService;

	@GetMapping("/reviews")
	List<Map<String,Object>> getReviews(
			@RequestParam(value = "num", defaultValue = "10") int num,
			@RequestParam(value = "start", defaultValue = "0") int start
	) throws Exception {
		return yelpService.getReviews(start, num);
	}
}
