package com.easytrip.rest.dto;

public class FlightsRequest {
	private String apiKey;
	private String adults;
	private String children;
	private String country;
	private String currency;
	private String destPlace;
	private String groupPricing;
	private String infants;
	private String locale;
	private String originPlace;
	private String outboundDate;
	private String locationSchema;
	private String cabinClass;

	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
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
	public String getDestPlace() {
		return destPlace;
	}
	public void setDestPlace(String destPlace) {
		this.destPlace = destPlace;
	}
	public String getGroupPricing() {
		return groupPricing;
	}
	public void setGroupPricing(String groupPricing) {
		this.groupPricing = groupPricing;
	}
	public String getInfants() {
		return infants;
	}
	public void setInfants(String infants) {
		this.infants = infants;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}
	public String getOutboundDate() {
		return outboundDate;
	}
	public void setOutboundDate(String outboundDate) {
		this.outboundDate = outboundDate;
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
	@Override
	public String toString() {
		return "FlightsRequest [apiKey=" + apiKey + ", adults=" + adults + ", children=" + children + ", country="
				+ country + ", currency=" + currency + ", destPlace=" + destPlace + ", groupPricing=" + groupPricing
				+ ", infants=" + infants + ", locale=" + locale + ", originPlace=" + originPlace + ", outboundDate="
				+ outboundDate + ", locationSchema=" + locationSchema + ", cabinClass=" + cabinClass + "]";
	}

}
