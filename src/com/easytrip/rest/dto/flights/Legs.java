package com.easytrip.rest.dto.flights;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Legs {
	@JsonProperty("Id")
	String id;
	@JsonProperty("SegmentIds")
	String[] segmentIds;
	@JsonProperty("OriginStation")
	String originStation;
	@JsonProperty("DestinationStation")
	String destinationStation;
	@JsonProperty("Departure")
	String departure;
	@JsonProperty("Arrival")
	String arrival;
	@JsonProperty("Duration")
	String duration;
	@JsonProperty("JourneyMode")
	String journeyMode;
	@JsonProperty("Stops")
	String[] stops;
	@JsonProperty("Carriers")
	String[] carriers;
	@JsonProperty("OperatingCarriers")
	String[] operatingCarriers;
	@JsonProperty("Directionality")
	String directionality;
	@JsonProperty("FlightNumbers")
	List<FlightNumbers> flightNumbers;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getSegmentIds() {
		return segmentIds;
	}
	public void setSegmentIds(String[] segmentIds) {
		this.segmentIds = segmentIds;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getJourneyMode() {
		return journeyMode;
	}
	public void setJourneyMode(String journeyMode) {
		this.journeyMode = journeyMode;
	}
	public String[] getStops() {
		return stops;
	}
	public void setStops(String[] stops) {
		this.stops = stops;
	}
	public String[] getCarriers() {
		return carriers;
	}
	public void setCarriers(String[] carriers) {
		this.carriers = carriers;
	}
	public String[] getOperatingCarriers() {
		return operatingCarriers;
	}
	public void setOperatingCarriers(String[] operatingCarriers) {
		this.operatingCarriers = operatingCarriers;
	}
	public String getDirectionality() {
		return directionality;
	}
	public void setDirectionality(String directionality) {
		this.directionality = directionality;
	}
	public List<FlightNumbers> getFlightNumbers() {
		return flightNumbers;
	}
	public void setFlightNumbers(List<FlightNumbers> flightNumbers) {
		this.flightNumbers = flightNumbers;
	}
}
