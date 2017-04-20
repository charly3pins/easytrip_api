package com.easytrip.rest.models.plans.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

String id;
String name;
Location location;
List<Category> categories;
String rating;

public String getName() {
	return name;
}

public Location getLocation() {
	return location;
}

public List<Category> getCategories() {
	return categories;
}

public String getRating() {
	return rating;
}

public void setName(String name) {
	this.name = name;
}

public void setLocation(Location location) {
	this.location = location;
}

public void setCategories(List<Category> categories) {
	this.categories = categories;
}

public void setRating(String rating) {
	this.rating = rating;
}



public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

}


