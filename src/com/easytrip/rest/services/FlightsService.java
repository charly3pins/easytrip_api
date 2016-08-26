package com.easytrip.rest.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.easytrip.rest.dto.FlightsRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/flights")
public class FlightsService {
	
	private static String apiKey = "prtl6749387986743898559646983194";
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})

	public Response postFlights(String input) throws Exception {		
		ObjectMapper mapper = new ObjectMapper();
		FlightsRequest fRequest = mapper.readValue(input, FlightsRequest.class);
		
		StringBuffer response = new StringBuffer();

		URL url = new URL( "http://partners.api.skyscanner.net/apiservices/pricing/v1.0/" );	    
	    String urlParameters = "apiKey=" + apiKey
	    		+ "&country=" + fRequest.getCountry() 
	    		+ "&cabinclass=" + fRequest.getCabinClass() 
	    		+ "&currency=" + fRequest.getCurrency() 
	    		+ "&locale=" + fRequest.getLocale() 
	    		+ "&originplace=" + fRequest.getOriginPlace() 
	    		+ "&destinationplace=" + fRequest.getDestPlace()
	    		+ "&outbounddate=2016-09-28"
	    		+ "&locationschema=" + fRequest.getLocationSchema() 
	    		+ "&adults=" + fRequest.getAdults() ;   

	    byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
	    
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();           
	    conn.setDoOutput(true);
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
	    conn.setRequestProperty("Accept", "application/json");    
	    
	    try{
	    	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(postData);
			wr.flush();
			wr.close();
			
			conn.getResponseCode();
			
			String requestPoll = conn.getHeaderFields().get("Location").get(0) + "?apiKey=" + apiKey;
			conn.disconnect();
			URL urlPoll = new URL (requestPoll);
			conn = (HttpURLConnection) urlPoll.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		    conn.setRequestProperty("Accept", "application/json");
			conn.getResponseCode();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
						
			in.close();

	    } catch (Exception e){
			e.printStackTrace();
	    }
		
		return Response.status(200).entity(response.toString()).build();
	}
}