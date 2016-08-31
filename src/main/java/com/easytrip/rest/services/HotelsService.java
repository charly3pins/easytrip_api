package com.easytrip.rest.services;

import com.easytrip.rest.models.hotels.HotelsRequest;

public interface HotelsService {
		
	public String getSuggestHotels(String query) throws Exception;
	
	public String getHotels(HotelsRequest hotelsRequest) throws Exception;
}