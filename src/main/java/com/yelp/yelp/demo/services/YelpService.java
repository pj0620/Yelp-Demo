package com.yelp.yelp.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yelp.yelp.demo.data.Review;

@Service
public interface YelpService {
	List<Review> getReviews(int start, int numResults) throws IOException;
}
