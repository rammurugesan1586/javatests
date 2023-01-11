package com.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServices implements UserManagement
{

	@Override
	public boolean createUser(User user) 
	{
		boolean isInserted = false;
		try
		{
			String insertUserQuery = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?)";
			Connection conn = new DBConfig().getConnection();
		
			PreparedStatement ps = conn.prepareStatement(insertUserQuery);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmailID());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getDob());
			ps.setInt(6, user.getAge());
			ps.setString(7, user.getUserID());
			
			int result=ps.executeUpdate();
			
			if(result == 1)
				isInserted = true;
			else
				isInserted = false;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		return isInserted;
	}

	@Override
	public boolean deleteUser(String userID) 
	{
		return false;
	}

	@Override
	public List<User> getAllUsers() 
	{
		List<User> allUsers = new ArrayList<User>();
		Connection conn = new DBConfig().getConnection();
		try
		{
			String getUsersQuery = "SELECT count(*) FROM USERS";
			Statement fetchStatement = conn.createStatement();
			ResultSet rs = fetchStatement.executeQuery(getUsersQuery);
			System.out.println(rs.getFetchSize());
			ResultSetMetaData metaData = rs.getMetaData();
			int columnsNumber = metaData.getColumnCount();
		    while (rs.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(" | ");
		            System.out.print(metaData.getColumnName(i)+" :: "+rs.getString(i));
		        }
		        System.out.println("");
		    }
			/*while(rs.next())
			{
				User dbUsers = new User(rs.getString("firstName"),rs.getString("lastName"),rs.getString("dateOfBirth"),rs.getString("emailID"),rs.getString("sex"),rs.getInt("age"),rs.getString("userID"));
				allUsers.add(dbUsers);
			}*/
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return allUsers;
	}

	@Override
	public User getUserByID(User user) 
	{
		return null;
	}

}
