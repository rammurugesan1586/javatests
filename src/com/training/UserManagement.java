package com.training;

import java.util.List;

public interface UserManagement 
{
	boolean createUser(User user);
	boolean deleteUser(String userID);
	List<User> getAllUsers();
	User getUserByID(User user);
}
