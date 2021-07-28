package com.yelp.yelp.demo.services;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.yelp.yelp.demo.data.Review;

@Service
public class WebScrapperYelpService implements YelpService {
	public static final String BASE_URL = "https://www.yelp.com/biz/red-oak-grille-basking-ridge?start=10";

	private static final Logger logger = LoggerFactory.getLogger(WebScrapperYelpService.class);

	@Override
	public List<Review> getReviews(int start, int numResults) throws IOException {
		Document document;
		try {
			document = Jsoup.connect(BASE_URL).get();
		}catch(IOException e){
			logger.error("Error while getting yelp page: url=\"{}\"", BASE_URL, e);
			throw e;
		}

		Elements scriptElements = document.getElementsByTag("script");

		return Collections.emptyList();
	}
}
