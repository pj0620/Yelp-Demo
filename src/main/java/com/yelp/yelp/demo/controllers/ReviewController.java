package com.yelp.yelp.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yelp.yelp.demo.data.Review;
import com.yelp.yelp.demo.services.YelpService;

@RestController
public class ReviewController {
	@Autowired
	YelpService yelpService;

	@GetMapping("/reviews")
	List<Review> getReviews(
			@RequestParam(value = "num", defaultValue = "10") int num,
			@RequestParam(value = "start", defaultValue = "0") int start
	) throws IOException {
		return yelpService.getReviews(start, num);
	}
}
