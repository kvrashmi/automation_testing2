package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigReader {
	/*
	 * Read config file for browser settings and return hashmap of key value pair from config file
	 */
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
	
}
