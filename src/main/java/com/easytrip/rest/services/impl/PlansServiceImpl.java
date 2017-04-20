package com.easytrip.rest.services.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easytrip.rest.models.plans.FoursquareApi;
import com.easytrip.rest.models.plans.PlansRequest;
import com.easytrip.rest.models.plans.Result;
import com.easytrip.rest.models.plans.entities.Category;
import com.easytrip.rest.models.plans.entities.CompactVenue;
import com.easytrip.rest.models.plans.entities.CompleteVenue;
import com.easytrip.rest.models.plans.entities.VenuesSearchResult;
import com.easytrip.rest.models.plans.response.Item;
import com.easytrip.rest.models.plans.response.PlansResponse;
import com.easytrip.rest.services.CommonServices;
import com.easytrip.rest.services.PlansService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import util.copy.Constants;

@Service("plansService")
@Transactional
public class PlansServiceImpl implements PlansService {

	public CompleteVenue getVenueById(String id) throws Exception {

		System.out.println(id);
		
		FoursquareApi foursquareApi = new FoursquareApi(PlansRequest.CLIENT_ID, PlansRequest.CLIENT_SECRET, PlansRequest.REDIRECT_CALLBACK);
		CompleteVenue completeVenue = foursquareApi.venue(id).getResult();
		return completeVenue;
	}
	
	public String getVenueByIdToString(String id) throws Exception {
		CompleteVenue completeVenue = getVenueById(id);
		ObjectMapper mapperResponse = new ObjectMapper();
		String jsonResponse = mapperResponse.writeValueAsString(completeVenue);
		System.out.println(jsonResponse);
		return jsonResponse;
	}
	
	public String getVenuesSearch(PlansRequest plansRequest) throws Exception { //optimizada
		
		FoursquareApi foursquareApi = new FoursquareApi(PlansRequest.CLIENT_ID, PlansRequest.CLIENT_SECRET, PlansRequest.REDIRECT_CALLBACK);

		String categories = Constants.CategoryID.ArtsAndEnterteinments
					//+ "," + Constants.CategoryID.CollegeAndUniversity
					//+ "," + Constants.CategoryID.Event
					+ "," + Constants.CategoryID.OutdoorsAndRecreation
					//+ "," + Constants.CategoryID.ProfessionalAndOthers
					//+ "," + Constants.CategoryID.Travel
					;

		//CIUDAD 
		Result<VenuesSearchResult> results = foursquareApi.venuesSearch(plansRequest.getCoordenadas(), 		null, 			null,			 null,			null,		plansRequest.getLimit(),			null, 		categories, 			null, 			null, 		null, 				null, 			plansRequest.getNear());
					//REGION AMPLIA (radio 100km)
		//Result<VenuesSearchResult> results = foursquareApi.venuesSearch(null, 		null, 			null,			 null,			null,		null,			"browse", 		"4d4b7104d754a06370d81259,4d4b7104d754a06370d81259", 			null, 			null, 		null, 				100000, 			plansRequest.getNear());
		//public Result<VenuesSearchResult> venuesSearch				(String ll, Double llAcc, Double alt, Double altAcc, String query, Integer limit, String intent, String categoryId, String url, String providerId, String linkedId, Integer radius, String near) throws FoursquareApiException {
		CompactVenue[] venues = results.getResult().getVenues();

		List<CompleteVenue> detailedVenues = getDetailedVenues(venues);
		List<CompleteVenue> detailedFilteredVenues = filterVenues(detailedVenues);
		ObjectMapper mapperResponse = new ObjectMapper();
		String jsonResponse = mapperResponse.writeValueAsString(detailedFilteredVenues);
		System.out.println(jsonResponse);
		return jsonResponse;
	}

	private List<CompleteVenue> filterVenues(List<CompleteVenue> venues) {
		
		List<CompleteVenue> filteredVenues = new ArrayList<CompleteVenue>();
		
		//TODO FILTRAR AQUI POR NEIGHBOURHOOD SI SOLO TIENE ESA CATEGORÍA.
		//HACERLO EN CLASE A PARTE Y BIEN ESTRUCTURADO
		for (CompleteVenue venue : venues) {
			boolean eliminar = false;
			Category[] categories = venue.getCategories();
			for(Category category : categories) {
				if(Constants.CategoryName.City.equals(category.getName())) {
					eliminar = true;
					break;
				} 
			}
			if(eliminar == false) {
					filteredVenues.add(venue);
			}
		}
		return filteredVenues;
	}

	private List<CompleteVenue> getDetailedVenues(CompactVenue[] venues) {
		
		List<CompleteVenue> detailedVenues = new ArrayList<CompleteVenue>();
		for (CompactVenue venue : venues) {
			try {
				detailedVenues.add(getVenueById(venue.getId()));
			} catch (Exception e) {
				System.out.println("Error al obtener venue " + venue.getId());
			}
		}
		return detailedVenues;
	}
	
	public String getVenuesExplore(PlansRequest plansRequest) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
	//	PlansRequest pRequest = mapper.readValue(input, PlansRequest.class);
		
	    String urlParameters = 
	    		"venues/explore" + "?" 
	    		+ "near=" + plansRequest.getNear()
	    		+ "&section=outdoors" // + plansRequest.getSection() 
	    		+ "&oauth_token=" + PlansRequest.OAuth
	    		+ "&limit=50" //numero de venues que devuelve (maximo es 50)
	    	//	+ "&offset="  //para traer los siguientes venues
	    		+ "&day=any"
	    		+ "&time=any"
	    		+ "&v=20163008"
	    	//	+ "&m=foursquare" 
	    		;
	    
		URL url = new URL( PlansRequest.BASE_URL + "" + urlParameters );
	//    URL url = new URL ("https://api.foursquare.com/v2/venues/explore?near=Barcelona&section=sights&oauth_token=1PGZEAUTMYNUQ4HTUQOKKDBDCTQG1OQEJCBEOV1JMKGOSHYL&v=20160830");
	    
	//	 URL url = new URL ("https://api.foursquare.com/v2/venues/search?near=Barcelona&categoryId=4d4b7105d754a06377d81259&oauth_token=1PGZEAUTMYNUQ4HTUQOKKDBDCTQG1OQEJCBEOV1JMKGOSHYL&v=20160902");

	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "GET");
		StringBuffer response = new StringBuffer();
		response = cService.getResponseFromConnection(conn);
	
		JsonFactory factory = mapper.getFactory(); // since 2.1 use mapper.getFactory() instead
		JsonParser jp = factory.createParser(response.toString());
		PlansResponse plansResponse = mapper.readValue(jp, PlansResponse.class);
		List<Item> items = 	plansResponse.getResponse().getGroups().get(0).getItems();
		
		ObjectMapper mapperResponse = new ObjectMapper();
		String jsonResponse = mapperResponse.writeValueAsString(items);
		System.out.println(jsonResponse);
		return jsonResponse;
	}
	


}