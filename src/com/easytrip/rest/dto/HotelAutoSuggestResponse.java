package com.easytrip.rest.dto;

import java.util.List;

public class HotelAutoSuggestResponse {
	List<HotelPlace> places;
	List<HotelResult> results;
	
	public List<HotelPlace> getPlaces() {
		return places;
	}
	public void setPlaces(List<HotelPlace> places) {
		this.places = places;
	}
	public List<HotelResult> getResults() {
		return results;
	}
	public void setResults(List<HotelResult> results) {
		this.results = results;
	}
}
