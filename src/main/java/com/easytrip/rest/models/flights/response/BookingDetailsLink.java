package com.easytrip.rest.models.flights.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDetailsLink {
	@JsonProperty("Uri")
	String uri;
	@JsonProperty("Body")
	String body;
	@JsonProperty("Method")
	String method;
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
}
