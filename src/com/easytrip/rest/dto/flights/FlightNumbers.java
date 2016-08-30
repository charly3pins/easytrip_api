package com.easytrip.rest.dto.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightNumbers {
	@JsonProperty("FlightNumber")
	String flightNumber;
	@JsonProperty("CarrierId")
	String carrierId;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
}
