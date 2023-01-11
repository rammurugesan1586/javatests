package com.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application 
{
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws ParseException 
	{
		System.out.println("Welcome");
		System.out.println("*******");
		System.out.println("Please Login");
		System.out.println("");
		login();
	}
	
	public static void login() throws ParseException
	{
		System.out.println("Please enter UserID :: ");
		String userID = userInput.next();
		if(userID.trim().length() == 0 || userID.trim().isEmpty())
		{
			System.out.println("Invalid Credential");
		}
		else
		{
			if(userID.trim().equalsIgnoreCase("admin"))
			{
				System.out.println("Admin Login");
				showAdminMenu();
			}
			else
			{
				System.out.println("Please enter Password :: ");
				String pwd = userInput.next();
				if(userID.trim().equalsIgnoreCase(pwd.trim()))
				{
					System.out.println("Login Successfull for User :: "+userID.trim().toUpperCase());
				}
				else
				{
					System.out.println("Invalid Credential");
				}
			}
		}
	}

	public static void showAdminMenu() throws ParseException
	{
		System.out.println("Welcome to Admin Menu");
		System.out.println("**********************");
		System.out.println("Please select one of the below items");
		System.out.println();
		System.out.println("1. Create User");
		System.out.println("2. Delete User");
		System.out.println("3. Create Account");
		System.out.println("4. Delete Account");
		System.out.println("5. Display List of Users");
		System.out.println("6. Display List of Accounts");
		System.out.println("7. Exit");
		System.out.println("8. Relogin as different User");
		System.out.println();
		
		System.out.println("Please enter selected Menu# :: ");
		String optedMenu = userInput.next();
		
		int selectedMenu = Integer.parseInt(optedMenu);
		
		switch(selectedMenu)
		{
		case 1:
			System.out.println("Creating User");
			createUser();
			break;
			
		case 2:
			System.out.println("Deleting User");
			break;
			
		case 3:
			System.out.println("Creating Account");
			break;
			
		case 4:
			System.out.println("Deleting Account");
			break;
			
		case 5:
			System.out.println("Display List of Users");
			getAllUsers();
			break;
			
		case 6:
			System.out.println("Display List of Accounts");
			break;
			
		case 7:
			System.out.println("Exit");
			System.out.println("Thanks for Connecting");
			System.out.println("*********************");
			System.exit(0);
			break;
			
		case 8:
			System.out.println("Relogin as different User");
			login();
			break;
			
		default:
			System.out.println("Invalid Option Selected");
			showAdminMenu();
			break;
			
		}
	}
	
	public static void showUserMenu() throws ParseException
	{
		System.out.println("Welcome to User Menu");
		System.out.println("**********************");
		System.out.println("Please select one of the below items");
		System.out.println();
		System.out.println("1. Display Account Details");
		System.out.println("2. Deposit Money");
		System.out.println("3. WithDraw Money");
		System.out.println("4. Exit");
		System.out.println("5. Relogin as different User");
		System.out.println();
		
		System.out.println("Please enter selected Menu# :: ");
		String optedMenu = userInput.next();
		
		int selectedMenu = Integer.parseInt(optedMenu);
		
		switch(selectedMenu)
		{
		case 1:
			System.out.println("Display Account Details");
			break;
			
		case 2:
			System.out.println("Deposit Money");
			break;
			
		case 3:
			System.out.println("WithDraw Money");
			break;
			
		case 4:
			System.out.println("Exit");
			System.out.println("Thanks for Connecting");
			System.out.println("*********************");
			System.exit(0);
			break;
			
		case 5:
			System.out.println("Relogin as different User");
			login();
			break;
			
		default:
			System.out.println("Invalid Option Selected");
			showUserMenu();
			break;
			
		}
	}
	
	public static void createUser() throws ParseException
	{
		System.out.println("Please enter below details for User Creation");
		System.out.println("********************************************");
		
		System.out.println("Enter First Name :: ");
		String firstName = userInput.next();
		
		System.out.println("Enter Last Name :: ");
		String lastName = userInput.next();
		
		System.out.println("Enter Email Address :: ");
		String emailID = userInput.next();
		
		System.out.println("Enter Sex (M/F) :: ");
		String sex = userInput.next();
		
		System.out.println("Enter Date of Birth (YYYY-MM-DD) :: ");
		String dateOfBirth = userInput.next();
		
		String userID = generateDigitUniqueID(8);
		
		DateTimeFormatter birthDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate birthDate = LocalDate.parse(dateOfBirth, birthDateFormat); 
		LocalDate currentDate = LocalDate.now();
		int age = Period.between(birthDate, currentDate).getYears();
		
		User newUser = new User(firstName, lastName, dateOfBirth, emailID, sex, age, userID);
		
		boolean isUserCreated = new UserServices().createUser(newUser);
		
		if(isUserCreated)
		{
			System.out.println("User Created Successfully");
			System.out.println("*************************");
			System.out.println();
			System.out.println("Please opt from below Options");
			System.out.println("*****************************");
			System.out.println("1. Return to Previous Menu");
			System.out.println("2. Exit");
			
			String selected = userInput.next();
			int selectedMenu = Integer.parseInt(selected);
			
			switch(selectedMenu)
			{
			case 1:
				showAdminMenu();
				break;
				
			case 2:
				System.out.println("Exit");
				System.out.println("Thanks for Connecting");
				System.out.println("*********************");
				System.exit(0);
				break;
			}
		}
		else
		{
			System.out.println("User Creation Failed, please try again.");
			showAdminMenu();
		}
	}
	
	
	public static String generateDigitUniqueID(int length)
	{
		String tokens = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random uniq = new Random();
		StringBuilder uniqID = new StringBuilder(length);
		
		for(int i=0; i<length; i++)
		{
			uniqID.append(tokens.charAt(uniq.nextInt(tokens.length())));
		}
		return uniqID.toString();
	}
	
	public static void getAllUsers() throws ParseException
	{
		List<User> allUsers = new UserServices().getAllUsers();
		if(allUsers.size() > 0)
		{
			System.out.println("Created Users List");
			System.out.println("******************");
			for(int i=0;i<allUsers.size();i++)
			{
				System.out.println(allUsers.get(i).getFirstName() +"-"+ allUsers.get(i).getLastName() +"-"+ allUsers.get(i).getAge());
			}
			System.out.println("******************");
		}
		else
		{
			System.out.println("******************");
			System.out.println("No User Created");
			System.out.println("******************");
		}
		System.out.println();
		System.out.println("Please opt from below Options");
		System.out.println("*****************************");
		System.out.println("1. Return to Previous Menu");
		System.out.println("2. Exit");
		
		String selected = userInput.next();
		int selectedMenu = Integer.parseInt(selected);
		
		switch(selectedMenu)
		{
		case 1:
			showAdminMenu();
			break;
			
		case 2:
			System.out.println("*********************");
			System.out.println("Thanks for Connecting");
			System.out.println("*********************");
			System.exit(0);
			break;
		}
	}
}
