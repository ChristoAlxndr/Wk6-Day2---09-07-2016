package com.wk6day2api;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.wk6day2api.*;

/*
 * Sample class that builds a database of employees via APIs
 */

public class ImplementDelete {
	
	//	Employee ID number
	private static String id = null;
	
	//	URL of the API to which we will connect
	protected static String endPoint = "http://localhost:1337/employee/";
	
	//	Character set to use when encoding URL parameters
	protected static String charset = "UTF-8";
	

	public static void deleteAndPrint() {
		
		Scanner scan = new Scanner(System.in);
	
	try {
		
		
//	Receives user input to set the following local variables
	System.out.println("What is the employee's ID number for deletion?");
	id = scan.nextLine();
	
	String queryString = String.format(id, URLEncoder.encode(id, charset));
	

//	Creates a new URL out of the end-point, returnType, and queryString
	URL localURL = new URL(endPoint + id);
	HttpURLConnection connection = (HttpURLConnection) 
	localURL.openConnection();
	connection.setRequestMethod("DELETE");
	
//	if we did not get a 200 (success) throw an exception
	if(connection.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : " +
		connection.getResponseMessage());
	}
	
	System.out.println("Employee # " + id + " has been deleted.");
	
	} catch (MalformedURLException a) {
		a.printStackTrace();
	} catch (IOException b) {
		b.printStackTrace();
	}
	
	ImplementGet.getAndPrint();
	
	scan.close();
	
	} //Close Method

} // Class Close
