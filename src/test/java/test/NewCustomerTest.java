package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import page.NewCustomerPage;
import util.BrowserFactory;

public class NewCustomerTest {
WebDriver driver;
	
	@Test(priority=1)
	public void validUserShouldBeAbleToLogin()
	{
		driver=BrowserFactory.init();
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.inputUserName("demo@techfios.com");
		lp.inputPassWord("abc123");
		lp.login();
	}
	
	@Test(priority=2)
	public void checkDashboardLaunch() {
		DashBoardPage dp=PageFactory.initElements(driver, DashBoardPage.class);
		dp.checkIfDashBoardIsLaunched();
		dp.clickCustomerMenu();
		dp.clickAddCustomer();
	}
	
	@Test(priority=3)
	public void checkNewCustomerCreation() throws InterruptedException
	{
		NewCustomerPage ncp=PageFactory.initElements(driver, NewCustomerPage.class);
		ncp.checkIfAddContactsPageIsLaunched();
		ncp.inputFullName("Rashmi");
		ncp.inputEmail("Rashmi");
		ncp.inputPhone("1234567893");
		ncp.inputAddress("1234 adc st,");
		ncp.inputCity("Allen");
		ncp.inputState("Texas");
		ncp.inputZip("75072");
		ncp.inputPassword("abc123");
		ncp.inputConfirmPassword("abc123");
		ncp.selectCompany("Motorola");
		ncp.selectCountry("United States");
		ncp.selectCurrency("USD");
		ncp.selectGroup("Selenium");
		Thread.sleep(3000);
		ncp.saveContact();
		BrowserFactory.tearDown();
		
	}

}
