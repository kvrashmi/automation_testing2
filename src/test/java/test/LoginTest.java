package test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import bsh.ParseException;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.Helper;
import util.JSONReader;

public class LoginTest {
	
	WebDriver driver;
	
	@Test(priority=1)
	public void validUserShouldBeAbleToLogin()
	{
		driver=BrowserFactory.init();
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		Map<String,String> myMap =JSONReader.readJSONFileForSimpleJSON();
		lp.inputUserName(myMap.get("username"));
		lp.inputPassWord(myMap.get("password"));
		lp.login();
		DashBoardPage dp=PageFactory.initElements(driver, DashBoardPage.class);
		dp.checkIfDashBoardIsLaunched();
		BrowserFactory.tearDown();
	}
		
	@Test(priority=2)
	public void checkAllComboOfUserNameAndPasswordsToLogin() throws IOException, ParseException, org.json.simple.parser.ParseException
	{
		driver=BrowserFactory.init();
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		List<Map<String,String>> myListOfMaps = JSONReader.readJSONFileForJSONArray();
		Map<String,String> myMap = JSONReader.getCredentialMapFromJSONList(myListOfMaps);
		lp.inputUserName(myMap.get("username"));
		lp.inputPassWord(myMap.get("password"));
		lp.login();
		if(!lp.checkIfInvalidUserTextAppeared())
		{
			DashBoardPage dp=PageFactory.initElements(driver, DashBoardPage.class);
			dp.checkIfDashBoardIsLaunched();
			BrowserFactory.tearDown();
		}
		else
		{
			lp.informInvalidUserTextAppeared();
			BrowserFactory.tearDown();
		}	
	}
	
}
