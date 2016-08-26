package com.easytrip.rest.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/flights")
public class FlightsService {
	
	@GET
	@Path("/{originplace}/{destinationplace}")
	public Response getFlights(@PathParam("originplace") String origin, @PathParam("destinationplace") String destination) throws IOException {
		String request        = "http://partners.api.skyscanner.net/apiservices/pricing/v1.0/";
		URL    url            = new URL( request );
		
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		conn.setDoOutput(true);
		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST" );
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("charset", "utf-8");
		
		String urlParameters = "apiKey=prtl6749387986743898559646983194&country=BR&currency=BRL&locale=pt-BR&originplace=SDU&destinationplace=GRU&outbounddate=2016-09-23&locationschema=Iata&adults=1";   
		byte[] postData       = urlParameters.getBytes(StandardCharsets.UTF_8);
		int    postDataLength = postData.length;
		
		conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
		conn.setUseCaches( false );
		
		StringBuffer response = new StringBuffer();
		
		try{
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(postData);
			wr.flush();
			wr.close();
			
			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			System.out.println("Header Fields : " + conn.getHeaderFields());
			System.out.println("Location : " + conn.getHeaderFields().get("Location").get(0));
			
			String requestPoll = conn.getHeaderFields().get("Location").get(0) + "?apiKey=prtl6749387986743898559646983194";
			conn.disconnect();
			URL urlPoll = new URL ( requestPoll );
			conn = (HttpURLConnection) urlPoll.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty( "charset", "utf-8");
			responseCode = conn.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + urlPoll);
			System.out.println("Response Code : " + responseCode);
			System.out.println("Header Fields : " + conn.getHeaderFields());
				
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			
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