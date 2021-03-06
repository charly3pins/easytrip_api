package com.easytrip.rest.models.flights.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Itineraries {
	@JsonProperty("OutboundLegId")
	String outboundLegId;
	@JsonProperty("InboundLegId")
	String inboundLegId;
	@JsonProperty("PricingOptions")
	List<PricingOptions> pricingOptions;
	@JsonProperty("BookingDetailsLink")
	BookingDetailsLink bookingDetailsLink;
	
	public String getOutboundLegId() {
		return outboundLegId;
	}
	public void setOutboundLegId(String outboundLegId) {
		this.outboundLegId = outboundLegId;
	}
	public String getInboundLegId() {
		return inboundLegId;
	}
	public void setInboundLegId(String inboundLegId) {
		this.inboundLegId = inboundLegId;
	}
	public List<PricingOptions> getPricingOptions() {
		return pricingOptions;
	}
	public void setPricingOptions(List<PricingOptions> pricingOptions) {
		this.pricingOptions = pricingOptions;
	}
	public BookingDetailsLink getBookingDetailsLink() {
		return bookingDetailsLink;
	}
	public void setBookingDetailsLink(BookingDetailsLink bookingDetailsLink) {
		this.bookingDetailsLink = bookingDetailsLink;
	}
	
	
}
