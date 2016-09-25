package com.easytrip.rest.models.commons;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class LocationAutosuggestResponse {
	@JsonProperty("Places")
	List<Place> places;

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
}