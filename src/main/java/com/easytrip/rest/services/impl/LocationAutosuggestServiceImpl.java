package com.easytrip.rest.services.impl;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easytrip.rest.models.commons.LocationAutosuggest;
import com.easytrip.rest.models.commons.LocationAutosuggestResponse;
import com.easytrip.rest.services.CommonServices;
import com.easytrip.rest.services.LocationAutosuggestService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("locationAutosuggestService")
@Transactional
public class LocationAutosuggestServiceImpl implements LocationAutosuggestService{

	public String getSuggestLocation(String query) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
//http://partners.api.skyscanner.net/apiservices/autosuggest/v1.0/{market}/{currency}/{locale}?query={query}&apiKey={apiKey}

		String urlParameters = "ES/EUR/es-ES?query=" + query + "&apiKey=" + LocationAutosuggest.API_KEY;
		
		URL url = new URL( LocationAutosuggest.LOCATION_AUTOSUGGEST_URL + urlParameters );
		
	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "GET");
		
		StringBuffer response = new StringBuffer();
		
		response = cService.getResponseFromConnection(conn);
		
		JsonFactory factory = mapper.getFactory(); // since 2.1 use mapper.getFactory() instead
		JsonParser jp = factory.createParser(response.toString());
		LocationAutosuggestResponse locationAutoSuggestResponse = mapper.readValue(jp, LocationAutosuggestResponse.class);
		
		String jsonResponse = mapper.writeValueAsString(locationAutoSuggestResponse.getPlaces());

		return jsonResponse;
	}

}
