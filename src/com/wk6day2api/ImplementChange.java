package com.wk6day2api;

import com.wk6day2api.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.wk6day2api.*;

/*
 * Sample class that builds a database of employees via APIs
 */

public class ImplementChange {
	
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
	
	
	public static void putAndPrint() {
		
		Scanner scan = new Scanner(System.in);
		
//		Instantiation of variables for use in the method
		String userInput = null;
		boolean updateContinue = true;
	
//	Try & Catch statement for the method
	try {
	
//	Do-while loop allowing users to make changes to multiple aspects of an employee's data until the user chooses to exit.
	do {
		
	System.out.println("Please select the employee field to update. \n" +
			"Enter '1' for employee's FIRST NAME. \n" +
			"Enter '2' for employee's LAST NAME. \n" +
			"Enter '3' for employee's EMAL address. \n" +
			"Enter '4' for employee's HOME phone. \n" +
			"Enter '5' for employee's CELL phone. \n" +
			"Enter '6' for the employee to update their PASSWORD. \n" +
			"Enter '7' to update the employee's active or inactive status. \n" +
			"Enter 'exit' to end employee updates.");
	
	userInput = scan.nextLine();
	
	switch (userInput) {
	case "1":
		System.out.println("What is the employee's first name?");
		firstName = scan.nextLine();
		String queryStringFirstName = String.format("firstName=%s/", URLEncoder.encode(firstName, charset));
		
//		Creates a new URL out of the end-point, returnType, and queryString
		URL localURLFirstName = new URL(endPoint + "?" + queryStringFirstName);
		HttpURLConnection connectionFirstName = (HttpURLConnection)
		localURLFirstName.openConnection();
		connectionFirstName.setRequestMethod("PUT");
		
//		if we did not get a 201 (success) throw an exception
		if(connectionFirstName.getResponseCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " +
			connectionFirstName.getResponseMessage());
		}
		connectionFirstName.disconnect();
		break;
	
	case "2":
		System.out.println("What is the employee's last name?");
		lastName = scan.nextLine();
		String queryStringLastName = String.format("lastName=%s", URLEncoder.encode(lastName, charset));
		
//		Creates a new URL out of the end-point, returnType, and queryString
		URL localURLLastName = new URL(endPoint + "?" + queryStringLastName);
		HttpURLConnection connectionLastName = (HttpURLConnection)
		localURLLastName.openConnection();
		connectionLastName.setRequestMethod("PUT");
		
//		if we did not get a 201 (success) throw an exception
		if(connectionLastName.getResponseCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " +
			connectionLastName.getResponseMessage());
		}
		connectionLastName.disconnect();
		break;
		
	case "3":
		System.out.println("What is the employee's email address?");
		email = scan.nextLine();
		String queryStringEmail = String.format("email=%s", URLEncoder.encode(email, charset));
		
//		Creates a new URL out of the end-point, returnType, and queryString
		URL localURLEmail = new URL(endPoint + "?" + queryStringEmail);
		HttpURLConnection connectionEmail = (HttpURLConnection)
		localURLEmail.openConnection();
		connectionEmail.setRequestMethod("PUT");
		
//		if we did not get a 201 (success) throw an exception
		if(connectionEmail.getResponseCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " +
			connectionEmail.getResponseMessage());
		}
		connectionEmail.disconnect();
		break;
		
	case "4":
		System.out.println("What is the employee's home phone?");
		homePhone = scan.nextLine();
		String queryStringHomePhone = String.format("homePhone=%s", URLEncoder.encode(homePhone, charset));
		
//		Creates a new URL out of the end-point, returnType, and queryString
		URL localURLHomePhone = new URL(endPoint + "?" + queryStringHomePhone);
		HttpURLConnection connectionHomePhone = (HttpURLConnection)
		localURLHomePhone.openConnection();
		connectionHomePhone.setRequestMethod("PUT");
		
//		if we did not get a 201 (success) throw an exception
		if(connectionHomePhone.getResponseCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " +
			connectionHomePhone.getResponseMessage());
		}
		connectionHomePhone.disconnect();
		break;
	
	case "5":
		System.out.println("What is the employee's cell phone?");
		cellPhone = scan.nextLine();
		String queryStringCellPhone = String.format("cellPhone=%s", URLEncoder.encode(cellPhone, charset));
		
//		Creates a new URL out of the end-point, returnType, and queryString
		URL localURLCellPhone = new URL(endPoint + "?" + queryStringCellPhone);
		HttpURLConnection connectionCellPhone = (HttpURLConnection)
		localURLCellPhone.openConnection();
		connectionCellPhone.setRequestMethod("PUT");
		
//		if we did not get a 201 (success) throw an exception
		if(connectionCellPhone.getResponseCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " +
			connectionCellPhone.getResponseMessage());
		}
		connectionCellPhone.disconnect();
		break;
		
	case "6":
		System.out.println("\n\n Please have the employee enter a password. \n" +
			"Password must be 8 characters. \n" +
			"Password must contain at least 1 upper and 1 lower case letter. \n" +
			"Password must contain at least 1 number.");
		password = scan.nextLine();
		String queryStringPassword = String.format("password=%s", URLEncoder.encode(password, charset));
		
//		Creates a new URL out of the end-point, returnType, and queryString
		URL localURLPassword = new URL(endPoint + "?" + queryStringPassword);
		HttpURLConnection connectionPassword = (HttpURLConnection)
		localURLPassword.openConnection();
		connectionPassword.setRequestMethod("PUT");
		
//		if we did not get a 201 (success) throw an exception
		if(connectionPassword.getResponseCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " +
			connectionPassword.getResponseMessage());
		}
		connectionPassword.disconnect();
		break;
		
	case "7":
		System.out.println("\n\n Is the employee currently active? \n" +
			"Enter '1' if the employee is CURRENTLY active. \n" +
			"Enter '0' if the employee is currently INACTIVE.");
		activeCode = scan.nextLine();
		String queryStringActiveStatus = String.format("active=%s", URLEncoder.encode(activeCode, charset));
		
//		Creates a new URL out of the end-point, returnType, and queryString
		URL localURLActiveStatus = new URL(endPoint + "?" + queryStringActiveStatus);
		HttpURLConnection connectionActiveStatus = (HttpURLConnection)
		localURLActiveStatus.openConnection();
		connectionActiveStatus.setRequestMethod("PUT");
		
//		if we did not get a 201 (success) throw an exception
		if(connectionActiveStatus.getResponseCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " +
			connectionActiveStatus.getResponseMessage());
		}
		connectionActiveStatus.disconnect();
		break;
		
	case "exit":
		updateContinue = false;
		break;
		
	default:
		System.out.println("You have made an invalid entry.  Please try again and enter a selection 1 - 7.");
	}
	
	} while (updateContinue);
	
	
	ImplementGet.getAndPrint();
	
	} catch (MalformedURLException a) {
		a.printStackTrace();
	} catch (IOException b) {
		b.printStackTrace();
	}
	
	scan.close();
	
	} //Close Method

} // Class Close
