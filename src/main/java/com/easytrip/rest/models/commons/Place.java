package com.easytrip.rest.models.commons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
	@JsonProperty("PlaceId")
	String placeId;
	@JsonProperty("PlaceName")
	String placeName;
	@JsonProperty("CountryId")
	String countryId;
	@JsonProperty("RegionId")
	String regionId;
	@JsonProperty("CityId")
	String cityId;
	@JsonProperty("CountryName")
	String countryName;
	
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
