package com.easytrip.rest.models.flights.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carriers {
	@JsonProperty("Id")
	String id;
	@JsonProperty("Code")
	String code;
	@JsonProperty("Name")
	String name;
	@JsonProperty("ImageUrl")
	String imageUrl;
	@JsonProperty("DisplayCode")
	
	String displayCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDisplayCode() {
		return displayCode;
	}
	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}
}
