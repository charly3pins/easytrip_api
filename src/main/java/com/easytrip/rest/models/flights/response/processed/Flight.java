package com.easytrip.rest.models.flights.response.processed;

import java.util.List;

public class Flight {
	String id;
	Airport originStation;
	Airport destinationStation;
	String departure;
	String arrival;
	int stops;
	String durationInMinutes;
	String journeyMode;
	List<Carrier> marketingCarriers;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Airport getOriginStation() {
		return originStation;
	}
	public void setOriginStation(Airport originStation) {
		this.originStation = originStation;
	}
	public Airport getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(Airport destinationStation) {
		this.destinationStation = destinationStation;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	public String getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(String durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	public String getJourneyMode() {
		return journeyMode;
	}
	public void setJourneyMode(String journeyMode) {
		this.journeyMode = journeyMode;
	}
	public List<Carrier> getMarketingCarriers() {
		return marketingCarriers;
	}
	public void setMarketingCarriers(List<Carrier> marketingCarriers) {
		this.marketingCarriers = marketingCarriers;
	}
}
