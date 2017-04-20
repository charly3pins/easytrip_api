package com.easytrip.rest.models.plans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PlansRequest {
	@JsonIgnoreProperties(ignoreUnknown = true)	
	public static String CLIENT_ID = "WUFPMDPF4GDXCSJNI0W2KW1PVNP3H50QMWFIXZCGSW2VIP2N";
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static String CLIENT_SECRET = "2SM31BF5VUY05KH4PI4G2L2TH4NWHGWSGBEU0XYA52E2SMWT";
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static String REDIRECT_CALLBACK = "Callback URL";
	
	String latitudeLongitude;
	String near;
	String placeDate;
	
	public String getLatitudeLongitude() {
		return latitudeLongitude;
	}
	public void setLatitudeLongitude(String latitudeLongitude) {
		this.latitudeLongitude = latitudeLongitude;
	}
	public String getNear() {
		return near;
	}
	public void setNear(String near) {
		this.near = near;
	}
	public String getPlaceDate() {
		return placeDate;
	}
	public void setPlaceDate(String placeDate) {
		this.placeDate = placeDate;
	} 
}
