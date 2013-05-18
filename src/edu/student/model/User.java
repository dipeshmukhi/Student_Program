package edu.student.model;

public class User 
{
	private int lUserId;
	private String lUserName;
	private String lPassword;
	private String lFirstName;
	private String lLastName;
	private String lEmailId;
	private String lPhone;
	private String lType;
	
	public User()
	{
		lUserId=0;
		lUserName="";
		lPassword="";
		lFirstName="";
		lLastName="";
		lEmailId="";
		lPhone="";
		lType="";
	}

	public int getlUserId() {
   	return lUserId;
   }

	public void setlUserId(int pLUserId) {
   	lUserId = pLUserId;
   }

	public String getlUserName() {
   	return lUserName;
   }

	public void setlUserName(String pLUserName) {
   	lUserName = pLUserName;
   }

	public String getlPassword() {
   	return lPassword;
   }

	public void setlPassword(String pLPassword) {
   	lPassword = pLPassword;
   }
	
	public String getlFirstName() {
   	return lFirstName;
   }

	public void setlFirstName(String pLFirstName) {
   	lFirstName = pLFirstName;
   }

	public String getlLastName() {
   	return lLastName;
   }

	public void setlLastName(String pLLastName) {
   	lLastName = pLLastName;
   }

	public String getlEmailId() {
   	return lEmailId;
   }

	public void setlEmailId(String pLEmailId) {
   	lEmailId = pLEmailId;
   }

	public String getlPhone() {
   	return lPhone;
   }

	public void setlPhone(String pLPhone) {
   	lPhone = pLPhone;
   }
	
	public String getlType() {
   	return lType;
   }
	public void setlType(String pLType) {
   	lType = pLType;
   }
	
}
