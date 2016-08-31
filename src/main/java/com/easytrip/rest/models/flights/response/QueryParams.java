package com.easytrip.rest.models.flights.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryParams {
	@JsonProperty("Country")
	String country;
	@JsonProperty("Currency")
	String currency;
	@JsonProperty("Locale")
	String locale;
	@JsonProperty("Adults")
	String adults;
	@JsonProperty("Children")
	String children;
	@JsonProperty("Infants")
	String infants;
	@JsonProperty("OriginPlace")
	String originPlace;
	@JsonProperty("DestinationPlace")
	String destinationPlace;
	@JsonProperty("OutboundDate")
	String outboundDate;
	@JsonProperty("IutboundDate")
	String inboundDate;
	@JsonProperty("LocationSchema")
	String locationSchema;
	@JsonProperty("CabinClass")
	String cabinClass;
	@JsonProperty("GroupPricing")
	Boolean groupPricing;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getAdults() {
		return adults;
	}
	public void setAdults(String adults) {
		this.adults = adults;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public String getInfants() {
		return infants;
	}
	public void setInfants(String infants) {
		this.infants = infants;
	}
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public String getOutboundDate() {
		return outboundDate;
	}
	public void setOutboundDate(String outboundDate) {
		this.outboundDate = outboundDate;
	}
	public String getInboundDate() {
		return inboundDate;
	}
	public void setInboundDate(String inboundDate) {
		this.inboundDate = inboundDate;
	}
	public String getLocationSchema() {
		return locationSchema;
	}
	public void setLocationSchema(String locationSchema) {
		this.locationSchema = locationSchema;
	}
	public String getCabinClass() {
		return cabinClass;
	}
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}
	public Boolean getGroupPricing() {
		return groupPricing;
	}
	public void setGroupPricing(Boolean groupPricing) {
		this.groupPricing = groupPricing;
	}
}
