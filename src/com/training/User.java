package com.training;

public class User 
{
	private String firstName;
	private String lastName;
	private String dob;
	private String emailID;
	private String sex;
	private int age;
	private String userID;
	
	

	public User(String firstName, String lastName, String dob, String emailID, String sex, int age, String userID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailID = emailID;
		this.sex = sex;
		this.age = age;
		this.userID = userID;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", emailID=" + emailID
				+ ", sex=" + sex + ", age=" + age + ", userID=" + userID + "]";
	}

}
