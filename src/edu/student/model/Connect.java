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
		/*public void deadfunc()
		{
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dipesh","root", "Dip_mukh99");
			
			if (connection != null)
			{
				return connection;
			}
			else
			{
				return null;
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}*/

