package com.easytrip.rest.models.flights.response.processed;

public class Flight {
	String id;
	String originStation;
	String destinationStation;
	String departure;
	String arrival;
	int stops;
	String durationInMinutes;
	String journeyMode;
	String marketingCarriers;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginStation() {
		return originStation;
	}
	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
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
	public String getMarketingCarriers() {
		return marketingCarriers;
	}
	public void setMarketingCarriers(String marketingCarriers) {
		this.marketingCarriers = marketingCarriers;
	}
}
