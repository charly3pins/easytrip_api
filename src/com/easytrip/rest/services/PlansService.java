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
import com.easytrip.rest.dto.HotelsRequest;
import com.easytrip.rest.dto.PlansRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.Recommendation;
import fi.foyt.foursquare.api.entities.RecommendationGroup;
import fi.foyt.foursquare.api.entities.Recommended;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

@Path("/plans")
public class PlansService {


	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
	@Path("/venues")
	public Response postVenues(String input) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		PlansRequest pRequest = mapper.readValue(input, PlansRequest.class);
		
	    String urlParameters = 
	    		"venues/explore" + "?" 
	    		+ "near=" + pRequest.getNear()
	    		+ "&section=" + pRequest.getSection() 
	    		+ "&oauth_token=" + PlansRequest.OAuth
	    		+ "&v=20163008"
	    	//	+ "&m=foursquare" 
	    		;
	    
		URL url = new URL( PlansRequest.BASE_URL + "" + urlParameters );
	//    URL url = new URL ("https://api.foursquare.com/v2/venues/explore?near=Barcelona&section=sights&oauth_token=1PGZEAUTMYNUQ4HTUQOKKDBDCTQG1OQEJCBEOV1JMKGOSHYL&v=20160830");
	    
	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "GET");
	    
		StringBuffer response = new StringBuffer();
		response = cService.getResponseFromConnection(conn);

		return Response.status(200).entity(response.toString()).build();
	}
	
	
//	@POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.TEXT_PLAIN})
//	@Path("/venues")
//	public Response postVenues(String input) throws Exception {
//
//		ObjectMapper mapper = new ObjectMapper();
//		PlansRequest pRequest = mapper.readValue(input, PlansRequest.class);
//		
//		StringBuffer response = new StringBuffer();
//		
//		// First we need a initialize FoursquareApi.
//		FoursquareApi foursquareApi = new FoursquareApi(PlansRequest.CLIENT_ID, PlansRequest.CLIENT_SECRET, PlansRequest.REDIRECT_CALLBACK);
//		try {
//			// After client has been initialized we can make queries.
//			Result<VenuesSearchResult> result = foursquareApi.venuesSearch(pRequest.getLatitudeLongitude(), null, null, null, null, null, null,
//					null, null, null, null, null, null);
//
//			if (result.getMeta().getCode() == 200) {
//				// if query was ok we can finally we do something with the data
//				for (CompactVenue venue : result.getResult().getVenues()) {
//					// TODO: Do something we the data
//					response.append(venue.getName());
//					response.append(venue.getLocation());
//					response.append("||");
//				}
//			} else {
//				// TODO: Proper error handling
//				System.out.println("Error occured: ");
//				System.out.println("  code: " + result.getMeta().getCode());
//				System.out.println("  type: " + result.getMeta().getErrorType());
//				System.out.println("  detail: " + result.getMeta().getErrorDetail());
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		return Response.status(200).entity(response.toString()).build();
//	}
}