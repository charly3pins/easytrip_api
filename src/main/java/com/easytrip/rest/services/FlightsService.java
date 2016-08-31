package com.easytrip.rest.services;

import com.easytrip.rest.models.flights.FlightsRequest;


public interface FlightsService {
		
	public String getFlights(FlightsRequest flightsRequest) throws Exception;
}