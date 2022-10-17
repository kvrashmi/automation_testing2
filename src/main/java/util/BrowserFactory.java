package util;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	static String browser="";
	static String url="";
	
	public static WebDriver init()
	{
		HashMap<String,String> configFileProps = Helper.readConfigFile();
		System.out.println(configFileProps);
		browser=configFileProps.get("browser");
		url=configFileProps.get("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
}
