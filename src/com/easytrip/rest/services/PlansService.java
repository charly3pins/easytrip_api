package com.easytrip.rest.services;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

@Path("/plans")
public class PlansService {

	private String clientId = "WUFPMDPF4GDXCSJNI0W2KW1PVNP3H50QMWFIXZCGSW2VIP2N";

	private String clientSecret = "2SM31BF5VUY05KH4PI4G2L2TH4NWHGWSGBEU0XYA52E2SMWT";

	@GET
	@Path("/{searchplace}")
	public Response getPlaces(@PathParam("searchplace") String search) throws IOException, FoursquareApiException {

		StringBuffer response = new StringBuffer();
		
		System.out.println("Llamada a la API Foursquare.");
		
		//Hacer llamada a api de google para encontrar coordenadas o lo que sea;
		
		search = "41.396985, 2.148277";
		
		// http://partners.api.skyscanner.net/apiservices/hotels/liveprices/v3
		// /{market}/{currency}/{locale}/{entityid}/{checkindate}/{checkoutdate}/{guests}/{rooms}?apiKey={apiKey}[&pageSize={pageSize}][&imageLimit={imageLimit}]

		// First we need a initialize FoursquareApi.
		FoursquareApi foursquareApi = new FoursquareApi(clientId, clientSecret, "Callback URL");
		try {
			// After client has been initialized we can make queries.
			Result<VenuesSearchResult> result = foursquareApi.venuesSearch(search, null, null, null, null, null, null,
					null, null, null, null, null, null);

			if (result.getMeta().getCode() == 200) {
				// if query was ok we can finally we do something with the data
				for (CompactVenue venue : result.getResult().getVenues()) {
					// TODO: Do something we the data
					System.out.println(venue.getName());

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

			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

		return Response.status(200).entity(response.toString()).build();

	}

	// public void searchVenues(String ll) throws FoursquareApiException {
	// // First we need a initialize FoursquareApi.
	// FoursquareApi foursquareApi = new FoursquareApi(clientId, clientSecret,
	// "Callback URL");
	//
	// // After client has been initialized we can make queries.
	// Result<VenuesSearchResult> result = foursquareApi.venuesSearch(ll, null,
	// null, null, null, null, null, null, null, null, null, null, null);
	//
	// if (result.getMeta().getCode() == 200) {
	// // if query was ok we can finally we do something with the data
	// for (CompactVenue venue : result.getResult().getVenues()) {
	// // TODO: Do something we the data
	// System.out.println(venue.getName());
	// }
	// } else {
	// // TODO: Proper error handling
	// System.out.println("Error occured: ");
	// System.out.println(" code: " + result.getMeta().getCode());
	// System.out.println(" type: " + result.getMeta().getErrorType());
	// System.out.println(" detail: " + result.getMeta().getErrorDetail());
	// }
	// }

}