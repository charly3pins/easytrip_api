package com.easytrip.rest.models.hotels.response.autosuggest;

public class HotelPlace {
	String place_id;
	String city_name;
	String admin_level1;
	String country_name;
	String admin_level2;
	
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getAdmin_level1() {
		return admin_level1;
	}
	public void setAdmin_level1(String admin_level1) {
		this.admin_level1 = admin_level1;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getAdmin_level2() {
		return admin_level2;
	}
	public void setAdmin_level2(String admin_level2) {
		this.admin_level2 = admin_level2;
	}
	
}
