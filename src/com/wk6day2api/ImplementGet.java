package com.wk6day2api;

import java.io.*;
import java.net.*;

/*
 * Sample class that builds a database of employees via APIs
 */

public class ImplementGet {
	
//	URL of the API to which we will connect
	protected static String endPoint = "http://localhost:1337/employee/";
	
	
	public static void getAndPrint() {
	
	try {
	
//	Creates a new URL out of the end-point, returnType, and queryString
	URL localURL = new URL(endPoint);
	HttpURLConnection connection = (HttpURLConnection)
	localURL.openConnection();
	connection.setRequestMethod("GET");
	
//	if we did not get a 200 (success) throw an exception
	if(connection.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : " +
		connection.getResponseMessage());
	}
	
//	read response into buffer
	BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
    String read;
    
    // loop of buffer line by the line until it return null, meaning
    // there are no more lines
    while ((read = br.readLine()) != null) {
        // print out each line to the screen
        
        String[] split = read.split(",");
        System.out.println(read);
	}
	
//	close of connection to API
	connection.disconnect();
	
	} catch (MalformedURLException a) {
		a.printStackTrace();
	} catch (IOException b) {
		b.printStackTrace();
	}
	
	
	} //Close Method

} // Class Close
