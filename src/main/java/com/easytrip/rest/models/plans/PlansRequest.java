package com.easytrip.rest.models.plans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PlansRequest {
	@JsonIgnoreProperties(ignoreUnknown = true)	
	public static String CLIENT_ID = "WUFPMDPF4GDXCSJNI0W2KW1PVNP3H50QMWFIXZCGSW2VIP2N";
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static String CLIENT_SECRET = "2SM31BF5VUY05KH4PI4G2L2TH4NWHGWSGBEU0XYA52E2SMWT";
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static String REDIRECT_CALLBACK = "Callback URL";
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static String OAuth = "1PGZEAUTMYNUQ4HTUQOKKDBDCTQG1OQEJCBEOV1JMKGOSHYL";
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static String BASE_URL = "https://api.foursquare.com/v2/";
	
	String method;
	
	String coordenadas;
	String near;
	String placeDate;
	Integer limit;
	String offset;
	
	//explore
	String section;
	
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
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
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Integer getLimit() {
		return limit;
	}
	public String getOffset() {
		return offset;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	} 
}
