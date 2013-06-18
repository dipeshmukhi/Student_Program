package edu.student.model;

public class User 
{
	private int lUserId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phone;
	private String type;
	
	public int getlUserId() {
   	return lUserId;
   }
	public void setlUserId(int pLUserId) {
   	lUserId = pLUserId;
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
	
}