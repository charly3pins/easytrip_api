package com.easytrip.rest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easytrip.rest.models.plans.PlansRequest;
import com.easytrip.rest.services.PlansService;

@RestController
public class PlansRestController {
 
    @Autowired
    PlansService plansService;
 
    @RequestMapping(value = {"/plans/explore"}, method = RequestMethod.POST)
    public  @ResponseBody String getVenuesExplore( @RequestBody PlansRequest plansRequest )   {		
    	try {
			return plansService.getVenuesExplore(plansRequest);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
    
    @RequestMapping(value = {"/plans/search"}, method = RequestMethod.POST)
    public  @ResponseBody String getVenuesSearch( @RequestBody PlansRequest plansRequest )   {		
    	try {
			return plansService.getVenuesSearch(plansRequest);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
    
    @RequestMapping(value = {"/plans/venueById"}, method = RequestMethod.POST)
    public  @ResponseBody String getVenues( @RequestBody String id )   {		
    	try {
			return plansService.getVenueByIdToString(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
}