package com.yelp.yelp.demo.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIYelpServiceImpl implements YelpService {
	public static final String BASE_URL = "https://api.yelp.com/v3/businesses/95AEBd5Nd9lC_zymaIL9ZA/reviews";

	@Value("${yelp.api.key}")
	String apiKey;

	@Override
	public List<Map<String,Object>> getReviews(int start, int numResults) throws Exception {
		HttpClient client = HttpClients.custom().build();
		HttpUriRequest request = RequestBuilder.get()
		                                       .setUri(BASE_URL)
		                                       .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
		                                       .addHeader("Authorization", "Bearer " + apiKey)
		                                       .build();
		HttpResponse response = client.execute(request);

		BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));

		String output = "";
		for (String line; (line = br.readLine()) != null; output += line);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> json = objectMapper.readValue(output, LinkedHashMap.class);

		return ((List<Map<String,Object>>) json.get("reviews")).stream()
		                                                 .skip(start)
		                                                 .limit(numResults)
		                                                 .collect(Collectors.toList());
	}
}
