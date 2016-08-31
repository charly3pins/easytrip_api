package com.easytrip.rest.services;

import com.easytrip.rest.models.plans.PlansRequest;

public interface PlansService {


	public String getVenues(PlansRequest plansRequest) throws Exception;
}