package com.easytrip.rest.dto.flights;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Agents {
	@JsonProperty("Id")
	String id;
	@JsonProperty("Name")
	String name;
	@JsonProperty("ImageUrl")
	String imageUrl;
	@JsonProperty("Status")
	String status;
	@JsonProperty("OptimisedForMobile")
	String optimisedForMobile;
	@JsonProperty("BookingNumber")
	String bookingNumber;
	@JsonProperty("Type")
	String type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOptimisedForMobile() {
		return optimisedForMobile;
	}
	public void setOptimisedForMobile(String optimisedForMobile) {
		this.optimisedForMobile = optimisedForMobile;
	}
	public String getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
