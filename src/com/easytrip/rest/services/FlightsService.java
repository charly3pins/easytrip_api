package com.easytrip.rest.services;

import java.io.DataOutputStream;
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
		
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
	public Response postFlights(String input) throws Exception {		
		ObjectMapper mapper = new ObjectMapper();
		FlightsRequest fRequest = mapper.readValue(input, FlightsRequest.class);
		
		StringBuffer response = new StringBuffer();

		URL url = new URL( FlightsRequest.BASE_URL );	    
	    String urlParameters = "apiKey=" + FlightsRequest.API_KEY
	    		+ "&country=" + fRequest.getCountry() 
	    		+ "&cabinclass=" + fRequest.getCabinClass() 
	    		+ "&currency=" + fRequest.getCurrency() 
	    		+ "&locale=" + fRequest.getLocale() 
	    		+ "&originplace=" + fRequest.getOriginPlace() 
	    		+ "&destinationplace=" + fRequest.getDestPlace()
	    		+ "&outbounddate=2016-09-28" //TODO dates hardcoded fins que les tractem
	    		+ "&locationschema=" + fRequest.getLocationSchema() 
	    		+ "&adults=" + fRequest.getAdults() ;   

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

		return Response.status(200).entity(response.toString()).build();
	}
}