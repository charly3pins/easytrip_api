package com.easytrip.rest.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hotels")
public class HotelsService {
	
	@GET
	@Path("/{originplace}")
	public Response getHotels(@PathParam("originplace") String origin) throws IOException {
		
//		http://partners.api.skyscanner.net/apiservices/hotels/liveprices/v3
//		/{market}/{currency}/{locale}/{entityid}/{checkindate}/{checkoutdate}/{guests}/{rooms}?apiKey={apiKey}[&pageSize={pageSize}][&imageLimit={imageLimit}]

		String baseUrl        	= "http://partners.api.skyscanner.net/";
		String request = baseUrl + "apiservices/hotels/liveprices/v3/";
		String urlParameters 	= "/ES/EUR/en-ES/27539733/2016-09-30/2016-10-04/2/1";
		String apiKey 			= "?apiKey=prtl6749387986743898559646983194";
		urlParameters += apiKey;
		request += urlParameters;
		URL    url            = new URL( request );
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		conn.setDoOutput( true );
		conn.setInstanceFollowRedirects( false );
		conn.setRequestMethod( "GET" );
		conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty( "charset", "utf-8");
		conn.setUseCaches( false );
		
		StringBuffer response = new StringBuffer();
		
		try{
			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			System.out.println("Response Message : " + conn.getResponseMessage());
			System.out.println("Header Fields : " + conn.getHeaderFields());
			System.out.println("Location : " + conn.getHeaderFields().get("Location").get(0));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			
			String requestPoll = baseUrl + conn.getHeaderFields().get("Location").get(0);
			conn.disconnect();
			URL urlPoll = new URL ( requestPoll );
			conn = (HttpURLConnection) urlPoll.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("charset", "utf-8");
			responseCode = conn.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + urlPoll);
			System.out.println("Response Code : " + responseCode);
			System.out.println("Header Fields : " + conn.getHeaderFields());
				
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} catch (Exception e){
			System.out.println(e);
		}
		
		return Response.status(200).entity(response.toString()).build();
	}
}