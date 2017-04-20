package com.easytrip.rest.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easytrip.rest.models.plans.PlansRequest;
import com.easytrip.rest.services.PlansService;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

@Service("plansService")
@Transactional
public class PlansServiceImpl implements PlansService {


	public String getVenues(PlansRequest plansRequest) throws Exception {

		StringBuffer response = new StringBuffer();
		
		// First we need a initialize FoursquareApi.
		FoursquareApi foursquareApi = new FoursquareApi(PlansRequest.CLIENT_ID, PlansRequest.CLIENT_SECRET, PlansRequest.REDIRECT_CALLBACK);
		try {
			// After client has been initialized we can make queries.
			Result<VenuesSearchResult> result = foursquareApi.venuesSearch(plansRequest.getLatitudeLongitude(), null, null, null, null, null, null,
					null, null, null, null, null, null);

			if (result.getMeta().getCode() == 200) {
				// if query was ok we can finally we do something with the data
				for (CompactVenue venue : result.getResult().getVenues()) {
					// TODO: Do something we the data
					response.append(venue.getName());
					response.append(venue.getLocation());
					response.append("||");
				}
			} else {
				// TODO: Proper error handling
				System.out.println("Error occured: ");
				System.out.println("  code: " + result.getMeta().getCode());
				System.out.println("  type: " + result.getMeta().getErrorType());
				System.out.println("  detail: " + result.getMeta().getErrorDetail());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return response.toString();
	}
}