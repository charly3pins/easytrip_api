package com.easytrip.rest.services.impl;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easytrip.rest.models.flights.FlightsRequest;
import com.easytrip.rest.models.flights.response.Agents;
import com.easytrip.rest.models.flights.response.BookingDetailsLink;
import com.easytrip.rest.models.flights.response.Carriers;
import com.easytrip.rest.models.flights.response.FlightsLivePrices;
import com.easytrip.rest.models.flights.response.Itineraries;
import com.easytrip.rest.models.flights.response.Legs;
import com.easytrip.rest.models.flights.response.Places;
import com.easytrip.rest.models.flights.response.PricingOptions;
import com.easytrip.rest.models.flights.response.processed.Agent;
import com.easytrip.rest.models.flights.response.processed.Airport;
import com.easytrip.rest.models.flights.response.processed.Carrier;
import com.easytrip.rest.models.flights.response.processed.Flight;
import com.easytrip.rest.models.flights.response.processed.FlightsResponse;
import com.easytrip.rest.models.flights.response.processed.Itinerary;
import com.easytrip.rest.models.flights.response.processed.Price;
import com.easytrip.rest.services.CommonServices;
import com.easytrip.rest.services.FlightsService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("flightsService")
@Transactional
public class FlightsServiceImpl implements FlightsService{
		
	public String getFlights(FlightsRequest flightsRequest) throws Exception {		
		StringBuffer response = new StringBuffer();

		URL url = new URL( FlightsRequest.BASE_URL );	    
	    String urlParameters = "apiKey=" + FlightsRequest.API_KEY
	    		+ "&country=" + flightsRequest.getCountry() 
	    		+ "&cabinclass=" + flightsRequest.getCabinClass() 
	    		+ "&currency=" + flightsRequest.getCurrency() 
	    		+ "&locale=" + flightsRequest.getLocale() 
	    		+ "&originplace=" + flightsRequest.getOriginPlace() 
	    		+ "&destinationplace=" + flightsRequest.getDestPlace()
	    		+ "&outbounddate=2016-09-15" //TODO dates hardcoded fins que les tractem
	    		+ "&inbounddate=2016-09-28" //TODO dates hardcoded fins que les tractem
	    		+ "&locationschema=" + flightsRequest.getLocationSchema() 
	    		+ "&adults=" + flightsRequest.getAdults() ;   

	    byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
	    
	    CommonServices cService = new CommonServices();
	    HttpURLConnection conn = cService.doConnection(url, "POST");
	    
    	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(postData);
		wr.flush();
		wr.close();
		
		conn.getResponseCode();
		
		String requestPoll = conn.getHeaderFields().get("Location").get(0) + "?apiKey=" + FlightsRequest.API_KEY;
		conn.disconnect();
		URL urlPoll = new URL (requestPoll);
	    conn = cService.doConnection(urlPoll, "GET");
		
		response = cService.getResponseFromConnection(conn);
		
		ObjectMapper mapperResponse = new ObjectMapper();
		JsonFactory factory = mapperResponse.getFactory();
		JsonParser jp = factory.createParser(response.toString());
		FlightsLivePrices flightsLivePrices = mapperResponse.readValue(jp, FlightsLivePrices.class);
		
		// INICIO TRATAMIENTO RESPUESTA DE VUELOS
		FlightsResponse flightsResponse = new FlightsResponse();
		List<Itinerary> itineraryList = new ArrayList<Itinerary>();
		
		//1. Recorrer los itinerarios de la respuesta
		for(Itineraries itinieraries : flightsLivePrices.getItineraries()){
			// Objeto basico de un itinerario que tiene vuelo de ida, vuelo de vuelta, precios y link para recuperar detalles del itinerario
			Itinerary itinerary = new Itinerary();
			
			String outboundLegId = itinieraries.getOutboundLegId();
			String inboundLegId = itinieraries.getInboundLegId(); // TODO CHECK NOT NULL
			
			//2. Seteamos el vuelo de ida
			Flight outboundFlight = new Flight();
			outboundFlight.setId(outboundLegId);
			//3. Seteamos el vuelo de vuelta
			Flight inboundFlight = new Flight();
			inboundFlight.setId(inboundLegId); // TODO CHECK NOT NULL
			
			//4. Buscamos las propiedades en las Legs de la respuesta
			for(Legs leg : flightsLivePrices.getLegs()){
				// IDA
				if(outboundLegId.equals(leg.getId())){
					Airport origin = new Airport();
					origin.setId(leg.getOriginStation());
					Airport destination = new Airport();
					destination.setId(leg.getDestinationStation());
					outboundFlight.setOriginStation(origin);
					outboundFlight.setDestinationStation(destination);
					outboundFlight.setDeparture(leg.getDeparture()); // TODO formatear fecha y hora
					outboundFlight.setArrival(leg.getArrival()); // TODO formatear feacha y hora
					outboundFlight.setStops(leg.getStops().length);
					outboundFlight.setDurationInMinutes(leg.getDuration()); // TODO formatear para mostrar en hora + minutos
					outboundFlight.setJourneyMode(leg.getJourneyMode());
					List<Carrier> marketingCarriersList = new ArrayList<Carrier>();
					outboundFlight.setMarketingCarriers(marketingCarriersList);
					for(String carrierId : leg.getCarriers()){
						Carrier carrier = new Carrier();
						carrier.setId(carrierId);
						outboundFlight.getMarketingCarriers().add(carrier);
					}
				} 
				// VUELTA
				else if(inboundLegId.equals(leg.getId())){ // TODO CHECK NOT NULL
					Airport origin = new Airport();
					origin.setId(leg.getOriginStation());
					Airport destination = new Airport();
					destination.setId(leg.getDestinationStation());
					inboundFlight.setOriginStation(origin);
					inboundFlight.setDestinationStation(destination);
					inboundFlight.setDeparture(leg.getDeparture());// TODO formatear fecha y hora
					inboundFlight.setArrival(leg.getArrival());// TODO formatear feacha y hora
					inboundFlight.setStops(leg.getStops().length);
					inboundFlight.setDurationInMinutes(leg.getDuration());// TODO formatear para mostrar en hora + minutos
					inboundFlight.setJourneyMode(leg.getJourneyMode());
					List<Carrier> marketingCarriersList = new ArrayList<Carrier>();
					inboundFlight.setMarketingCarriers(marketingCarriersList);
					for(String carrierId : leg.getCarriers()){
						Carrier carrier = new Carrier();
						carrier.setId(carrierId);
						inboundFlight.getMarketingCarriers().add(carrier);
					}
				}
			}
			
			//5. Buscamos los ids de los sitios y cogemos su codigo y nombre
			for(Places place : flightsLivePrices.getPlaces()){
				// IDA
				if(outboundFlight.getOriginStation().getId().equals(place.getId())){
					outboundFlight.getOriginStation().setCode(place.getCode());
					outboundFlight.getOriginStation().setName(place.getName());
				} else if(outboundFlight.getDestinationStation().getId().equals(place.getId())){
					outboundFlight.getDestinationStation().setCode(place.getCode());
					outboundFlight.getDestinationStation().setName(place.getName());
				} 
				// VUELTA
				//TODO CHECK NOT NULL
				if(inboundFlight.getOriginStation().getId().equals(place.getId())){
					inboundFlight.getOriginStation().setCode(place.getCode());
					inboundFlight.getOriginStation().setName(place.getName());
				} else if(inboundFlight.getDestinationStation().getId().equals(place.getId())){
					inboundFlight.getDestinationStation().setCode(place.getCode());
					inboundFlight.getDestinationStation().setName(place.getName());
				}
			}
			
			//6. Buscamos los ids de los operadores y cogemos su codigo, descripcion, urlImagen y codigo a mostrar
			// IDA
			Iterator<Carrier> outboundIterator = outboundFlight.getMarketingCarriers().listIterator();
			List<Carrier> auxCarrierList = new ArrayList<Carrier>();
			while(outboundIterator.hasNext()){
				Carrier carrier = outboundIterator.next();
				for(Carriers carriers : flightsLivePrices.getCarriers()){
					if(carrier.getId().equals(carriers.getId())){
						carrier.setCode(carriers.getCode());
						carrier.setName(carriers.getName());
						carrier.setImageUrl(carriers.getImageUrl());
						carrier.setDisplayCode(carriers.getDisplayCode());
						auxCarrierList.add(carrier);
						break; // FIXME revisar como hacer para que al encontrarlo salga del bucle. Como lo tendremos en BD tampoco creo que haga falta hacer esto luego...
					}
				}
			}
			outboundFlight.setMarketingCarriers(auxCarrierList);
			
			// VUELTA 
			//TODO CHECK NOT NULL
			Iterator<Carrier> inboundIterator = inboundFlight.getMarketingCarriers().listIterator();
			auxCarrierList.clear();
			while(inboundIterator.hasNext()){
				Carrier carrier = inboundIterator.next();
				for(Carriers carriers : flightsLivePrices.getCarriers()){
					if(carrier.getId().equals(carriers.getId())){
						carrier.setCode(carriers.getCode());
						carrier.setName(carriers.getName());
						carrier.setImageUrl(carriers.getImageUrl());
						carrier.setDisplayCode(carriers.getDisplayCode());
						auxCarrierList.add(carrier);
						break; // FIXME revisar como hacer para que al encontrarlo salga del bucle. Como lo tendremos en BD tampoco creo que haga falta hacer esto luego...
					}
				}
			}
			inboundFlight.setMarketingCarriers(auxCarrierList);
			
			itinerary.setOutboundFlight(outboundFlight);
			itinerary.setInboundFlight(inboundFlight); // TODO CHECK NOT NULL
			
			//7. Seteamos los precios
			List<PricingOptions> pricingOptions = itinieraries.getPricingOptions();
			List<Price> prices = new ArrayList<Price>();
			for(PricingOptions priceOption : pricingOptions){
				Price price = new Price();
				for(String agentCode : priceOption.getAgents()){
					//8. Buscamos las agencias a partir de los ids que tenemos
					for(Agents agents : flightsLivePrices.getAgents()){
						if(agentCode.equals(agents.getId())){
							Agent agent = new Agent();
							agent.setId(agents.getId());
							agent.setName(agents.getName());
							agent.setImageUrl(agents.getImageUrl());
							agent.setBookingNumber(agents.getBookingNumber());
							price.setAgent(agent);
						}
					}
				}
				price.setAmount(priceOption.getPrice());
				price.setDeeplink(priceOption.getDeeplinkUrl());
				
				prices.add(price);
			}
			itinerary.setPrices(prices);
			
			
			//9. Seteamos el link para recoger los detalles de la reserva
			BookingDetailsLink bookingDetailsLink = itinieraries.getBookingDetailsLink();
			itinerary.setBookingDetailsLink(bookingDetailsLink.getUri() + "/" + outboundLegId + ";" + inboundLegId + "?apikey=" + FlightsRequest.API_KEY ); // TODO revisar la URL cuando se haga el polling para los details!
			
			//10. Anadimos el itinerario creado a la lista
			itineraryList.add(itinerary);
		}
		
		//11. Guardamos la lista de itinerarios en el objeto principal
		flightsResponse.setItineraryList(itineraryList);
		
		// FIN TRATAMIENTO RESPUESTA DE VUELOS
		
		ObjectMapper mapperResponseProcessed = new ObjectMapper();
		String jsonResponse = mapperResponseProcessed.writeValueAsString(flightsResponse);

		return jsonResponse;
	}
}