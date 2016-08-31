package com.easytrip.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easytrip.rest.models.flights.FlightsRequest;
import com.easytrip.rest.services.FlightsService;

@RestController
public class FlightsRestController {
 
    @Autowired
    FlightsService flightsService;
 
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