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
 
    @RequestMapping(value = {"/plans"}, method = RequestMethod.POST)
    public  @ResponseBody String getVenues( @RequestBody PlansRequest plansRequest )   {		
    	try {
			return plansService.getVenues(plansRequest);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
    
}