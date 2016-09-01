package com.easytrip.rest.models.flights.response.processed;

import java.util.List;

public class FlightsResponse {
	List<Itinerary> itineraryList;

	public List<Itinerary> getItineraryList() {
		return itineraryList;
	}

	public void setItineraryList(List<Itinerary> itineraryList) {
		this.itineraryList = itineraryList;
	}

}
