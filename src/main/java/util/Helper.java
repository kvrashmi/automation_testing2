package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;


import org.testng.Assert;

public class Helper {
	
	public static int generateRandomNumber(int boundaryNum)
	{
		Random rnd = new Random();
		int number=rnd.nextInt(boundaryNum);
		return number;
	}
	
	public static HashMap<String,String> readConfigFile()
	{
		HashMap<String, String> configFileProps = new HashMap<String, String>();
		try 
		{
			InputStream input = new FileInputStream("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//config//config.properties");
			Properties prop = new Properties();
			prop.load(input);
		    configFileProps.put("browser", prop.getProperty("browser"));
		    configFileProps.put("url", prop.getProperty("url"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return configFileProps;	
	}
	
	
	public static boolean compareUrls(String url1,String url2)
	{
		Assert.assertEquals(url2, url1);
		return url1.equals(url2);
	}

}
