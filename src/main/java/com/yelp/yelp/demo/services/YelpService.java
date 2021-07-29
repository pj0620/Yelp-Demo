package com.yelp.yelp.demo.services;

import java.util.List;
import java.util.Map;

public interface YelpService {
	/**
	 * Returns reviews as list
	 *
	 * @param  start  review to start on
	 * @param  numResults maximum number of reviews to return
	 * @return      list of reviews
	 */
	List<Map<String,Object>> getReviews(int start, int numResults) throws Exception;
}
