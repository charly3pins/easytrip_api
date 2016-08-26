package com.easytrip.rest.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonServices {

	public HttpURLConnection doConnection(URL url , String method){
	    HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		    conn.setDoOutput(true);
		    conn.setRequestMethod(method);
		    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		    conn.setRequestProperty("Accept", "application/json"); 
		    conn.setInstanceFollowRedirects( false );
		    conn.setRequestProperty( "charset", "utf-8");
		    conn.setUseCaches( false );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public StringBuffer getResponseFromConnection(HttpURLConnection conn) {
		StringBuffer response = new StringBuffer();

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
}

