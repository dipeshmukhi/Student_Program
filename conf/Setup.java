import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Setup 
{
	String fileLocation=this.getClass().getResource("Setup.properties").toString().substring(6).replace("%20"," ");
	
	public static void main(String[] args)
	{	
		Properties properties = new Properties();
		Setup set= new Setup();
		try
		{	
			File file= new File(set.fileLocation);
			properties.load(new FileInputStream(file));
			System.out.println(properties.getProperty("database.url"));
    		System.out.println(properties.getProperty("database.username"));
    		System.out.println(properties.getProperty("database.password"));
		}
		catch(Exception e)
		{System.out.println(""+e.getMessage());}
	}
}