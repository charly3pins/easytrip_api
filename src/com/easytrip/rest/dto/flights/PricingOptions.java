package com.easytrip.rest.dto.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PricingOptions {
	@JsonProperty("Agents")
	String[] agents;
	@JsonProperty("QuoteAgeInMinutes")
	String quoteAgeInMinutes;
	@JsonProperty("Price")
	String price;
	@JsonProperty("DeeplinkUrl")
	String deeplinkUrl;
	
	public String[] getAgents() {
		return agents;
	}
	public void setAgents(String[] agents) {
		this.agents = agents;
	}
	public String getQuoteAgeInMinutes() {
		return quoteAgeInMinutes;
	}
	public void setQuoteAgeInMinutes(String quoteAgeInMinutes) {
		this.quoteAgeInMinutes = quoteAgeInMinutes;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDeeplinkUrl() {
		return deeplinkUrl;
	}
	public void setDeeplinkUrl(String deeplinkUrl) {
		this.deeplinkUrl = deeplinkUrl;
	}
}
