import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;


public class Setup 
{	
	public static void main(String[] args) throws FileNotFoundException
	{	
		Properties properties = new Properties();
		Setup set= new Setup();
		InputStream in = set.getClass().getResourceAsStream("Setup.properties");
		FileOutputStream out = new FileOutputStream("Setup.properties");
		try
		{			
			properties.load(in);
			System.out.println(properties.getProperty("database.driverClassName"));
			System.out.println(properties.getProperty("database.url"));
    		System.out.println(properties.getProperty("database.username"));
    		System.out.println(properties.getProperty("database.password"));
    		
    		properties.clear();
    		properties.setProperty("database.password", "fcgnjdf");
    		properties.store(out, "");
		}
		catch(Exception e)
		{System.out.println(""+e.getMessage());}
	}
}