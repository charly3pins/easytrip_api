package com.easytrip.rest.services;

import com.easytrip.rest.models.plans.PlansRequest;

public interface PlansService {

	public String getVenuesSearch(PlansRequest plansRequest) throws Exception;

	public String getVenuesExplore(PlansRequest plansRequest) throws Exception;

	public String getVenueByIdToString(String id) throws Exception;
}