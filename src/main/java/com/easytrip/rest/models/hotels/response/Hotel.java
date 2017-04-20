package com.easytrip.rest.models.hotels.response;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static String IMAGE_BASE_URL = "http://d16eaqi26omzol.cloudfront.net/available/";
	
	private String name;
	private List<String> types;
	private Integer hotel_id;
	private String address;
	private Integer district;
	private Integer number_of_rooms;
	private Integer popularity;
	private String popularity_desc;
	private List<String> amenities;
	private Double latitude;
	private Double longitude;
	private List<String> image_urls;
	private Integer score;
    private String tag;
    private Integer star_rating;
    private Float distance_from_search;
    private List<String> origPictureUrls;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public Integer getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getDistrict() {
		return district;
	}
	public void setDistrict(Integer district) {
		this.district = district;
	}
	public Integer getNumber_of_rooms() {
		return number_of_rooms;
	}
	public void setNumber_of_rooms(Integer number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	public String getPopularity_desc() {
		return popularity_desc;
	}
	public void setPopularity_desc(String popularity_desc) {
		this.popularity_desc = popularity_desc;
	}
	public List<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public List<String> getImage_urls() {
		return image_urls;
	}
	public void setImage_urls(List<String> image_urls) {
		List<String> urls = new LinkedList<String>();
		for(String image : image_urls){
			//urls.add(IMAGE_BASE_URL + image.replaceAll(".*available\\{\\/", "").replaceAll("\\/:.*", "\\/") + HotelImages.ORIG);
		}
		this.origPictureUrls = urls;
		this.image_urls = image_urls;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(Integer star_rating) {
		this.star_rating = star_rating;
	}
	public Float getDistance_from_search() {
		return distance_from_search;
	}
	public void setDistance_from_search(Float distance_from_search) {
		this.distance_from_search = distance_from_search;
	}
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", types=" + types + ", hotel_id=" + hotel_id + ", address=" + address
				+ ", district=" + district + ", number_of_rooms=" + number_of_rooms + ", popularity=" + popularity
				+ ", popularity_desc=" + popularity_desc + ", amenities=" + amenities + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", image_urls=" + image_urls + ", score=" + score + ", tag=" + tag
				+ ", star_rating=" + star_rating + ", distance_from_search=" + distance_from_search + "]";
	}
	public List<String> getOrigPictureUrls() {
		return origPictureUrls;
	}
	public void setOrigPictureUrls(List<String> pictureUrls) {
		this.origPictureUrls = pictureUrls;
	}
    
}
