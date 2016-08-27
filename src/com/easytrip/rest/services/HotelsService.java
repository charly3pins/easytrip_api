package com.easytrip.rest.services;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.easytrip.rest.dto.HotelsRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/hotels")
public class HotelsService {
		
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
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

		return Response.status(200).entity(response.toString()).build();
	}
}