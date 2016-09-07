package com.wk6day2api;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.wk6day2api.*;

/*
 * Sample class that builds a database of employees via APIs
 */

public class ImplementCreate {
	
//	URL of the API to which we will connect
	protected static String endPoint = "http://localhost:1337/employee/";
	
//	Character set to use when encoding URL parameters
	protected static String charset = "UTF-8";
	
//	Employee First Name Variable
	private static String firstName = null;
	
//	Employee Last Name Variable
	private static String lastName = null;
	
//	Employee Email Address
	private static String email = null;
	
//	Employee Home Telephone #
	private static String homePhone = null;
	
//	Employee Cellular Telephone #
	private static String cellPhone = null;
	
//	Employee's Password
	private static String password = null;
	
//	Employee account indicator as active "1", or inactive "0"
	private static String activeCode = null; 
	
	
	public static void postAndPrint() {
		
		Scanner scan = new Scanner(System.in);
	
	try {
		
//	Receives user input to set the following local variables
	System.out.println("What is the employee's first name?");
	firstName = scan.nextLine();
	
	System.out.println("What is the employee's last name?");
	lastName = scan.nextLine();
	
	System.out.println("What is the employee's email address?");
	email = scan.nextLine();
	
	System.out.println("What is the employee's home phone?");
	homePhone = scan.nextLine();
	
	System.out.println("What is the employee's cell phone?");
	cellPhone = scan.nextLine();
	
	System.out.println("\n\n Please have the employee enter a password. \n" +
			"Password must be 8 characters. \n" +
			"Password must contain at least 1 upper and 1 lower case letter. \n" +
			"Password must contain at least 1 number.");
	password = scan.nextLine();
	
	System.out.println("\n\n Is the employee currently active? \n" +
			"Enter '1' if the employee is CURRENTLY active. \n" +
			"Enter '0' if the employee is currently INACTIVE.");
	activeCode = scan.nextLine();
	
//	Creates the URL parameters as a string encoding them with
//	defined charset
	String queryString = String.format("firstName=%s&lastName=%s&email=%s&homePhone=%s&cellPhone=%s&password=%s&active=%s/",
		URLEncoder.encode(firstName, charset),
		URLEncoder.encode(lastName, charset),
		URLEncoder.encode(email, charset),
		URLEncoder.encode(homePhone, charset),
		URLEncoder.encode(cellPhone, charset),
		URLEncoder.encode(password, charset),
		URLEncoder.encode(activeCode, charset));
	
//	Creates a new URL out of the end-point, returnType, and queryString
	URL localURL = new URL(endPoint + "?" + queryString);
	
	System.out.println(endPoint + queryString);
	
	HttpURLConnection connection = (HttpURLConnection)
	localURL.openConnection();
	connection.setRequestMethod("POST");
	
//	if we did not get a 201 (success) throw an exception
	if(connection.getResponseCode() != 201) {
		throw new RuntimeException("Failed : HTTP error code : " +
		connection.getResponseMessage());
	}

	
	ImplementGet.getAndPrint();
	
	} catch (MalformedURLException a) {
		a.printStackTrace();
	} catch (IOException b) {
		b.printStackTrace();
	}
	
	scan.close();
	
	} //Close Method

} // Class Close
