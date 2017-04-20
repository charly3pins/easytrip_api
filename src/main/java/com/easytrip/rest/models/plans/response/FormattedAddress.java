package com.easytrip.rest.models.plans.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FormattedAddress {

String address;
String lat;
String lng;
String postalCode;
String cc;
String city;
String state;
String country;
List<FormattedAddress> formattedAddress;

public String getAddress() {
	return address;
}
public String getLat() {
	return lat;
}
public String getLng() {
	return lng;
}
public String getPostalCode() {
	return postalCode;
}
public String getCc() {
	return cc;
}
public String getCity() {
	return city;
}
public String getState() {
	return state;
}
public String getCountry() {
	return country;
}
public List<FormattedAddress> getFormattedAddress() {
	return formattedAddress;
}
public void setAddress(String address) {
	this.address = address;
}
public void setLat(String lat) {
	this.lat = lat;
}
public void setLng(String lng) {
	this.lng = lng;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public void setCc(String cc) {
	this.cc = cc;
}
public void setCity(String city) {
	this.city = city;
}
public void setState(String state) {
	this.state = state;
}
public void setCountry(String country) {
	this.country = country;
}
public void setFormattedAddress(List<FormattedAddress> formattedAddress) {
	this.formattedAddress = formattedAddress;
}

}