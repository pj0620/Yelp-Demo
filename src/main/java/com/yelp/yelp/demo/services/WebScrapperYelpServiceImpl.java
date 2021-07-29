package com.yelp.yelp.demo.services;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WebScrapperYelpServiceImpl implements YelpService {
	public static final String BASE_URL = "https://www.yelp.com/biz/red-oak-grille-basking-ridge";

	private static final Logger logger = LoggerFactory.getLogger(WebScrapperYelpServiceImpl.class);

	@Override
	public List<Map<String,Object>> getReviews(int start, int numResults) throws Exception {
		Document document;
		try {
			document = Jsoup.connect(BASE_URL).get();
		}catch(IOException e){
			logger.error("Error while getting yelp page: url=\"{}\"", BASE_URL, e);
			throw e;
		}

		String jsonText = document.getElementsByTag("script").stream()
		                          .filter(e -> e.hasAttr("type") && e.attributes().get("type").equals("application/ld+json"))
		                          .filter(e -> e.childNodes().size() > 0)
		                          .map(e -> e.childNodes().get(0).toString())
		                          .filter(s -> s.contains("\"@type\":\"Restaurant\""))
		                          .findFirst()
		                          .orElseThrow(
				                          () -> new Exception("Could not find reviews data on page")
		                          );

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> json = objectMapper.readValue(jsonText, LinkedHashMap.class);
		List<Map<String,Object>> reviews = (List<Map<String,Object>>) json.get("review");

		return reviews.stream()
				      .skip(start)
					  .limit(numResults)
					  .collect(Collectors.toList());
	}
}
