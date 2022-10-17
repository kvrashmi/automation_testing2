package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver driver;
	
	@Test(priority=1)
	public void validUserShouldBeAbleToLogin()
	{
		driver=BrowserFactory.init();
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.inputUserName("demo@techfios.com");
		lp.inputPassWord("abc123");
		lp.login();
		BrowserFactory.tearDown();
	}
}
