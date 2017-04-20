package com.easytrip.rest.models.plans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlansResponse {

	ExploreResponse response;

	public ExploreResponse getResponse() {
		return response;
	}

	public void setResponse(ExploreResponse response) {
		this.response = response;
	}


	
}
