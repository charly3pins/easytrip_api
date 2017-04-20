package com.easytrip.rest.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easytrip.rest.models.hotels.HotelsRequest;
import com.easytrip.rest.services.HotelsService;

@RestController
@RequestMapping("/hotels")
public class HotelsRestController {
 
    @Autowired
    HotelsService hotelsService;
 
    @RequestMapping(value = {"/getSuggestHotels/{query}"}, method = RequestMethod.GET)
    public  @ResponseBody String getSuggestHotels( @PathVariable String query )   {		
    	try {
			return hotelsService.getSuggestHotels(query);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
    
    @RequestMapping(value = {"/getHotels"}, method = RequestMethod.POST)
    public  @ResponseBody String getHotels( @RequestBody HotelsRequest hotelsRequest )   {		
    	try {
			return hotelsService.getHotels(hotelsRequest);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Error";
    }
 
}