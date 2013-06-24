package edu.student.model;

import java.io.Serializable;

public class User implements Serializable
{
	
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
   
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phone;
	private String type;
	
	public int getUserId() {
   	return userId;
   }
	public void setUserId(int pUserId) {
   	userId = pUserId;
   }
	public String getUserName() {
   	return userName;
   }
	public void setUserName(String pUserName) {
   	userName = pUserName;
   }
	public String getPassword() {
   	return password;
   }
	public void setPassword(String pPassword) {
   	password = pPassword;
   }
	public String getFirstName() {
   	return firstName;
   }
	public void setFirstName(String pFirstName) {
   	firstName = pFirstName;
   }
	public String getLastName() {
   	return lastName;
   }
	public void setLastName(String pLastName) {
   	lastName = pLastName;
   }
	public String getEmailId() {
   	return emailId;
   }
	public void setEmailId(String pEmailId) {
   	emailId = pEmailId;
   }
	public String getPhone() {
   	return phone;
   }
	public void setPhone(String pPhone) {
   	phone = pPhone;
   }
	public String getType() {
   	return type;
   }
	public void setType(String pType) {
   	type = pType;
   }
	public static long getSerialversionuid() {
   	return serialVersionUID;
   }
	
		
}