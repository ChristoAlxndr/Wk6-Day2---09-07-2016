package com.wk6day2api;

import java.util.Scanner;
import com.wk6day2api.*;

public class APIMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		Scanner in-take of user information
		String userInput = null;
		boolean dbRun = true;
		
		do {

		System.out.println("Please choose an action for employee information. \n" +
				"Enter '1' for the employee list. \n" +
				"Enter '2' to add an employee to the list \n" +
				"Enter '3' to update an employee on the list \n" +
				"Enter '4' to delete an employee from the list \n" +
				"Enter 'exit' to terminate the program.");
		
		userInput = scan.nextLine();
		
		switch(userInput) {
		case "1":
			ImplementGet.getAndPrint();
			break;
		case "2":
			ImplementCreate.postAndPrint();
			break;
		case "3":
			ImplementChange.putAndPrint();
			break;
		case "4":
			ImplementDelete.deleteAndPrint();
			break;
		case "exit":
			System.out.println("Thank you for using the employee Database.");
			dbRun = false;
			break;
		default:
			System.out.println("Invalid selection.  Please enter an option from 1 - 4, \n" +
					"or enter 'exit'. \n\n");
			break;
		} 
		
		} while (dbRun);
		
	} // Close Main
} //Close Class
