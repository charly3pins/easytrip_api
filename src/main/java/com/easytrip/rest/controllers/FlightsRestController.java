package com.easytrip.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easytrip.rest.models.flights.FlightsRequest;
import com.easytrip.rest.services.FlightsService;
import com.easytrip.rest.services.LocationAutosuggestService;

@RestController
public class FlightsRestController {
 
    @Autowired
    FlightsService flightsService;
    @Autowired
    LocationAutosuggestService locationAutosuggestService;
    
    @RequestMapping(value = {"/getSuggestLocation/{query}"}, method = RequestMethod.GET)
    public  @ResponseBody String getSuggestLocation( @PathVariable String query )   {		
    	try {
			return locationAutosuggestService.getSuggestLocation(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
    
    @RequestMapping(value = {"/flights"}, method = RequestMethod.POST)
    public  @ResponseBody String getFlights( @RequestBody FlightsRequest flightsRequest )   {		
    	try {
			return flightsService.getFlights(flightsRequest);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
 
}