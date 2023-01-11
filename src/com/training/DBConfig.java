package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig 
{
	static Connection con = null;
	public static Connection getConnection()
	{
		try
		{
			String dbConURL = "jdbc:sqlite:C:/MyWorkSpace/MongoTest/CoreJava/coreJava.db";
			con = DriverManager.getConnection(dbConURL);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public static void closeConnection(Connection con)
	{
		try 
		{
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
