package com.easytrip.rest.services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.easytrip.rest.dto.hotels.Hotel;
import com.easytrip.rest.dto.hotels.HotelAutoSuggestResponse;
import com.easytrip.rest.dto.hotels.HotelsRequest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/hotels")
public class HotelsService {
		
	@GET
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
	@Path("/getSuggestHotel/{query}")
	public Response getSuggestHotels(@PathParam("query") String query) throws Exception {
//		{market}/{currency}/{locale}/{query}?apikey={apikey}
		
		ObjectMapper mapper = new ObjectMapper();
//		HotelsRequest hRequest = mapper.readValue(input, HotelsRequest.class);
		
		String urlParameters = "ES/EUR/es-ES/" + query + "?apiKey=" + HotelsRequest.API_KEY;
		
//		String urlParameters = "/" + hRequest.getMarket() 
//	    		+ "/" + hRequest.getCurrency()
//	    		+ "/" + hRequest.getLocale() 
//	    		+ "/" + hRequest.getEntityId() // exemple: 27539733
////	    		+ "/" + hRequest.getCheckinDate()
////	    		+ "/" + hRequest.getCheckoutDate()
//	    		+ "/2016-09-30/2016-10-04" //TODO dates hardcoded fins que les tractem
//	    		+ "/" + hRequest.getGuests()
//	    		+ "/" + hRequest.getRooms()
//	    		+ "?apiKey=" + HotelsRequest.API_KEY
//	    		//+ "&pageSize=" + hRequest.getPageSize() //TODO estudiar que fa
//	    		+ "&imageLimit=" + hRequest.getImageLimit();
		
		URL url = new URL( HotelsRequest.HOTELS_AUTOSUGGEST_URL + "" + urlParameters );
		
	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "GET");
		
		StringBuffer response = new StringBuffer();
		
		response = cService.getResponseFromConnection(conn);
		
		JsonFactory factory = mapper.getFactory(); // since 2.1 use mapper.getFactory() instead
		JsonParser jp = factory.createParser(response.toString());
		HotelAutoSuggestResponse hotelAutoSuggestResponse = mapper.readValue(jp, HotelAutoSuggestResponse.class);
		
		String jsonResponse = mapper.writeValueAsString(hotelAutoSuggestResponse.getResults());

		return Response.status(200).entity(jsonResponse).build();
	}
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
	@Path("/postHotel")
	public Response postHotels(String input) throws Exception {
//		http://partners.api.skyscanner.net/apiservices/hotels/liveprices/v3
//		/{market}/{currency}/{locale}/{entityid}/{checkindate}/{checkoutdate}/{guests}/{rooms}?apiKey={apiKey}[&pageSize={pageSize}][&imageLimit={imageLimit}]

		ObjectMapper mapper = new ObjectMapper();
		HotelsRequest hRequest = mapper.readValue(input, HotelsRequest.class);
		
		String urlParameters = "/" + hRequest.getMarket() 
	    		+ "/" + hRequest.getCurrency()
	    		+ "/" + hRequest.getLocale() 
	    		+ "/" + hRequest.getEntityId() // exemple: 27539733
//	    		+ "/" + hRequest.getCheckinDate()
//	    		+ "/" + hRequest.getCheckoutDate()
	    		+ "/2016-09-30/2016-10-04" //TODO dates hardcoded fins que les tractem
	    		+ "/" + hRequest.getGuests()
	    		+ "/" + hRequest.getRooms()
	    		+ "?apiKey=" + HotelsRequest.API_KEY
	    		//+ "&pageSize=" + hRequest.getPageSize() //TODO estudiar que fa
	    		+ "&imageLimit=" + hRequest.getImageLimit();
		
		URL url = new URL( HotelsRequest.HOTELS_URL + "" + urlParameters );
		
	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "GET");
		
		StringBuffer response = new StringBuffer();
		
		response = cService.getResponseFromConnection(conn);
			
		String requestPoll = HotelsRequest.BASE_URL + conn.getHeaderFields().get("Location").get(0);
		conn.disconnect();
			
		URL urlPoll = new URL (requestPoll);
	    conn = cService.doConnection(urlPoll, "GET");

		response = cService.getResponseFromConnection(conn);
		
		JsonNode rootNode = mapper.readValue(response.toString(), 
				JsonNode.class);     
		JsonNode hotels = rootNode.get("hotels");
		
		List<Hotel> hotelsList = Arrays.asList(mapper.readValue(hotels.toString(), 
				Hotel[].class));
//		for(Hotel h : hotelsList){
//			System.out.println(h.toString());
//		}

		return Response.status(200).entity(hotels.toString()).build();
	}
}