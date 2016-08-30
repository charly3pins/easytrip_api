package com.easytrip.rest.dto.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Segments {
	@JsonProperty("Id")
	String id;
	@JsonProperty("OriginStation")
	String originStation;
	@JsonProperty("DestinationStation")
	String destinationStation;
	@JsonProperty("DepartureDateTime")
	String departureDateTime;
	@JsonProperty("ArrivalDateTime")
	String arrivalDateTime;
	@JsonProperty("Carrier")
	String carrier;
	@JsonProperty("OperatingCarrier")
	String operatingCarrier;
	@JsonProperty("Duration")
	String duration;
	@JsonProperty("FlightNumber")
	String flightNumber;
	@JsonProperty("JourneyMode")
	String journeyMode;
	@JsonProperty("Directionality")
	String directionality;
	
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
	public String getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public String getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getOperatingCarrier() {
		return operatingCarrier;
	}
	public void setOperatingCarrier(String operatingCarrier) {
		this.operatingCarrier = operatingCarrier;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getJourneyMode() {
		return journeyMode;
	}
	public void setJourneyMode(String journeyMode) {
		this.journeyMode = journeyMode;
	}
	public String getDirectionality() {
		return directionality;
	}
	public void setDirectionality(String directionality) {
		this.directionality = directionality;
	}
}
