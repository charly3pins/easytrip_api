package com.easytrip.rest.services.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easytrip.rest.models.hotels.HotelsRequest;
import com.easytrip.rest.models.hotels.response.Hotel;
import com.easytrip.rest.models.hotels.response.autosuggest.HotelAutoSuggestResponse;
import com.easytrip.rest.services.CommonServices;
import com.easytrip.rest.services.HotelsService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("hotelsService")
@Transactional
public class HotelsServiceImpl implements HotelsService {
		
	public String getSuggestHotels(String query) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();

//		{market}/{currency}/{locale}/{query}?apikey={apikey}
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

		return jsonResponse;
	}
	
	public String getHotels(HotelsRequest hotelsRequest) throws Exception {
//		http://partners.api.skyscanner.net/apiservices/hotels/liveprices/v3
//		/{market}/{currency}/{locale}/{entityid}/{checkindate}/{checkoutdate}/{guests}/{rooms}?apiKey={apiKey}[&pageSize={pageSize}][&imageLimit={imageLimit}]

		ObjectMapper mapper = new ObjectMapper();
//		HotelsRequest hRequest = mapper.readValue(input, HotelsRequest.class);
		
		String urlParameters = "/" + hotelsRequest.getMarket() 
	    		+ "/" + hotelsRequest.getCurrency()
	    		+ "/" + hotelsRequest.getLocale() 
	    		+ "/" + hotelsRequest.getEntityId() // exemple: 27539733
//	    		+ "/" + hRequest.getCheckinDate()
//	    		+ "/" + hRequest.getCheckoutDate()
	    		+ "/2016-09-30/2016-10-04" //TODO dates hardcoded fins que les tractem
	    		+ "/" + hotelsRequest.getGuests()
	    		+ "/" + hotelsRequest.getRooms()
	    		+ "?apiKey=" + HotelsRequest.API_KEY
	    		//+ "&pageSize=" + hRequest.getPageSize() //TODO estudiar que fa
	    		+ "&imageLimit=" + hotelsRequest.getImageLimit();
		
		URL url = new URL( HotelsRequest.HOTELS_URL + "" + urlParameters );
		
	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "GET");
		
		StringBuffer response = new StringBuffer();
		
		response = cService.getResponseFromConnection(conn);
			
		String requestPoll = HotelsRequest.BASE_URL + conn.getHeaderFields().get("Location").get(0);
		String sessionId = requestPoll.replace(HotelsRequest.HOTELS_URL, "");
		System.out.println(requestPoll);
		System.out.println(sessionId);
		conn.disconnect();
			
		URL urlPoll = new URL (requestPoll);
	    conn = cService.doConnection(urlPoll, "GET");

		response = cService.getResponseFromConnection(conn);
		
		JsonNode rootNode = mapper.readValue(response.toString(), 
				JsonNode.class);     
		JsonNode hotels = rootNode.get("hotels");
		
		List<Hotel> hotelsList = Arrays.asList(mapper.readValue(hotels.toString(), 
				Hotel[].class));
		String hotelListString = mapper.writeValueAsString(hotelsList);
		String hotelIds = "";
		for(Hotel h : hotelsList){
			hotelIds += h.getHotel_id().toString() + ",";
		}
		hotelIds = hotelIds.length() > 0 ? hotelIds.substring(0, hotelIds.length() - 1): "";
		
		urlPoll = new URL ( HotelsRequest.HOTELS_DETAILS + sessionId + "&hotelIds=" + hotelIds);
		System.out.println( HotelsRequest.HOTELS_DETAILS + sessionId + "&hotelIds=" + hotelIds);
	    conn = cService.doConnection(urlPoll, "GET");

		response = cService.getResponseFromConnection(conn);
		
		requestPoll = HotelsRequest.BASE_URL + conn.getHeaderFields().get("Location").get(0);
		System.out.println(requestPoll);
		conn.disconnect();
			
		urlPoll = new URL (requestPoll);
	    conn = cService.doConnection(urlPoll, "GET");

		response = cService.getResponseFromConnection(conn);
		
		System.out.println(response.toString());
		
//		return Response.status(200).entity(hotels.toString()).build();
		return hotelListString.toString();
	}
}