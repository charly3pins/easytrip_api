package com.easytrip.rest.dto;

public class HotelsRequest {
	///{market}/{currency}/{locale}/{entityid}/{checkindate}/{checkoutdate}/{guests}/{rooms}?apiKey={apiKey}[&pageSize={pageSize}][&imageLimit={imageLimit}]
	String apiKey;
	String pageSize;
	String imageLimit;
	String market;
	String currency;
	String locale;
	String entityId;
	String checkinDate;
	String checkoutDate;
	String guests;
	String rooms;
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getImageLimit() {
		return imageLimit;
	}
	public void setImageLimit(String imageLimit) {
		this.imageLimit = imageLimit;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public String getGuests() {
		return guests;
	}
	public void setGuests(String guests) {
		this.guests = guests;
	}
	public String getRooms() {
		return rooms;
	}
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	@Override
	public String toString() {
		return "HotelsRequest [apiKey=" + apiKey + ", pageSize="+ pageSize +", imageLimit=" + imageLimit +", market=" + market 
				+ ", currency=" + currency + ", locale=" + locale + ", entityId=" + entityId + ", checkinDate=" + checkinDate 
				+ ", checkoutDate=" + checkoutDate + ", guests=" + guests + ", rooms=" + rooms + "]";
	}
}