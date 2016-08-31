package com.easytrip.rest.services.impl;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easytrip.rest.models.flights.FlightsRequest;
import com.easytrip.rest.models.flights.response.FlightsLivePrices;
import com.easytrip.rest.services.CommonServices;
import com.easytrip.rest.services.FlightsService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("flightsService")
@Transactional
public class FlightsServiceImpl implements FlightsService{
		
	public String getFlights(FlightsRequest flightsRequest) throws Exception {		
		StringBuffer response = new StringBuffer();

		URL url = new URL( FlightsRequest.BASE_URL );	    
	    String urlParameters = "apiKey=" + FlightsRequest.API_KEY
	    		+ "&country=" + flightsRequest.getCountry() 
	    		+ "&cabinclass=" + flightsRequest.getCabinClass() 
	    		+ "&currency=" + flightsRequest.getCurrency() 
	    		+ "&locale=" + flightsRequest.getLocale() 
	    		+ "&originplace=" + flightsRequest.getOriginPlace() 
	    		+ "&destinationplace=" + flightsRequest.getDestPlace()
	    		+ "&outbounddate=2016-09-28" //TODO dates hardcoded fins que les tractem
	    		+ "&locationschema=" + flightsRequest.getLocationSchema() 
	    		+ "&adults=" + flightsRequest.getAdults() ;   

	    byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
	    
	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "POST");
	    
    	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(postData);
		wr.flush();
		wr.close();
		
		conn.getResponseCode();
		
		String requestPoll = conn.getHeaderFields().get("Location").get(0) + "?apiKey=" + FlightsRequest.API_KEY;
		conn.disconnect();
		URL urlPoll = new URL (requestPoll);
	    conn = cService.doConnection(urlPoll, "GET");
		
		response = cService.getResponseFromConnection(conn);
		
		ObjectMapper mapperResponse = new ObjectMapper();
		JsonFactory factory = mapperResponse.getFactory();
		JsonParser jp = factory.createParser(response.toString());
		FlightsLivePrices flightsLivePrices = mapperResponse.readValue(jp, FlightsLivePrices.class);
		
		String jsonResponse = mapperResponse.writeValueAsString(flightsLivePrices);
		System.out.println(jsonResponse);
		return response.toString();
	}
}