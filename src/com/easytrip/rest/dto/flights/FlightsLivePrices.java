package com.easytrip.rest.dto.flights;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightsLivePrices {
	@JsonProperty("SessionKey")
	String sessionKey;
	@JsonProperty("Query")
	QueryParams query;
	@JsonProperty("Status")
	String status;
	@JsonProperty("Itineraries")
	List<Itineraries> itineraries;
	@JsonProperty("Legs")
	List<Legs> legs;
	@JsonProperty("Segments")
	List<Segments> segments;
	@JsonProperty("Carriers")
	List<Carriers> carriers;
	@JsonProperty("Agents")
	List<Agents> agents;
	@JsonProperty("Places")
	List<Places> places;
	@JsonProperty("Currencies")
	List<Currencies> currencies;
	
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public QueryParams getQuery() {
		return query;
	}
	public void setQuery(QueryParams query) {
		this.query = query;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Itineraries> getItineraries() {
		return itineraries;
	}
	public void setItineraries(List<Itineraries> itineraries) {
		this.itineraries = itineraries;
	}
	public List<Legs> getLegs() {
		return legs;
	}
	public void setLegs(List<Legs> legs) {
		this.legs = legs;
	}
	public List<Segments> getSegments() {
		return segments;
	}
	public void setSegments(List<Segments> segments) {
		this.segments = segments;
	}
	public List<Carriers> getCarriers() {
		return carriers;
	}
	public void setCarriers(List<Carriers> carriers) {
		this.carriers = carriers;
	}
	public List<Agents> getAgents() {
		return agents;
	}
	public void setAgents(List<Agents> agents) {
		this.agents = agents;
	}
	public List<Places> getPlaces() {
		return places;
	}
	public void setPlaces(List<Places> places) {
		this.places = places;
	}
	public List<Currencies> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Currencies> currencies) {
		this.currencies = currencies;
	}
	
}
