package edu.student.model;

import org.apache.taglibs.standard.tag.common.sql.DataSourceWrapper;

public class Connect 
{
	
	private String lDriver;
	private String lURL;
	private String lUserName;
	private String lPassword;
	
	public DataSourceWrapper myDataSource = new DataSourceWrapper();
	
	public Connect()
	{
		lDriver="com.mysql.jdbc.Driver";
		lURL="jdbc:mysql://localhost:3306/Dipesh";
		lUserName="root";
		lPassword="Dip_mukh99";
	}
	
	public String getlDriver() {
   	return lDriver;
   }

	public void setlDriver(String pLDriver) {
   	lDriver = pLDriver;
   }

	public String getlURL() {
   	return lURL;
   }

	public void setlURL(String pLURL) {
   	lURL = pLURL;
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

	public void setMyDataSource(DataSourceWrapper pMyDataSource) {
   	myDataSource = pMyDataSource;
   }
	
	public  DataSourceWrapper getMyDataSource()
	{
		
		try
		{		
			myDataSource.setDriverClassName(lDriver);
			myDataSource.setJdbcURL(lURL);
			myDataSource.setUserName(lUserName);
			myDataSource.setPassword(lPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return myDataSource;
		}
		
		return myDataSource;		
	}
}