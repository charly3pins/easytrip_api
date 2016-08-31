package com.easytrip.rest.models.hotels.response.autosuggest;

public class HotelResult {
	String display_name;
	String parent_place_id;
	String individual_id;
	String geo_type;
	String localised_geo_type;
	Boolean is_bookable;
	
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getParent_place_id() {
		return parent_place_id;
	}
	public void setParent_place_id(String parent_place_id) {
		this.parent_place_id = parent_place_id;
	}
	public String getIndividual_id() {
		return individual_id;
	}
	public void setIndividual_id(String individual_id) {
		this.individual_id = individual_id;
	}
	public String getGeo_type() {
		return geo_type;
	}
	public void setGeo_type(String geo_type) {
		this.geo_type = geo_type;
	}
	public String getLocalised_geo_type() {
		return localised_geo_type;
	}
	public void setLocalised_geo_type(String localised_geo_type) {
		this.localised_geo_type = localised_geo_type;
	}
	public Boolean getIs_bookable() {
		return is_bookable;
	}
	public void setIs_bookable(Boolean is_bookable) {
		this.is_bookable = is_bookable;
	}
	
}
