package com.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;


public class Test {

	public static void main(String[] args) throws ParseException 
	{
		//System.out.println(generateDigitUniqueID(16));
		String birthDay = "1989-05-01";
		DateTimeFormatter birthDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate birthDate = LocalDate.parse(birthDay, birthDateFormat); 
		LocalDate currentDate = LocalDate.now();
		System.out.println(Period.between(birthDate, currentDate).getYears());
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

}
