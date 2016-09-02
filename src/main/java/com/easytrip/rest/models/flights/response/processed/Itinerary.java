package com.easytrip.rest.models.flights.response.processed;

import java.util.List;

public class Itinerary {
	Flight outboundFlight;
	Flight inboundFlight;
	List<Price> prices;
	String bookingDetailsLink;
	
	public Flight getOutboundFlight() {
		return outboundFlight;
	}
	public void setOutboundFlight(Flight outboundFlight) {
		this.outboundFlight = outboundFlight;
	}
	public Flight getInboundFlight() {
		return inboundFlight;
	}
	public void setInboundFlight(Flight inboundFlight) {
		this.inboundFlight = inboundFlight;
	}
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	public String getBookingDetailsLink() {
		return bookingDetailsLink;
	}
	public void setBookingDetailsLink(String bookingDetailsLink) {
		this.bookingDetailsLink = bookingDetailsLink;
	}
}
