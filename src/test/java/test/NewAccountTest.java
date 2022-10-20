package test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import page.NewAccountPage;
import util.BrowserFactory;
import util.ExcelReader;

public class NewAccountTest {
WebDriver driver;
	
	@Test(priority=1)
	public void validUserShouldBeAbleToLogin()
	{
		driver=BrowserFactory.init();
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		ExcelReader reader = new ExcelReader("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//testdata//TestNGProject1.xlsx");
		String username = reader.getCellData("LoginPage", "Username", 2);
		String password = reader.getCellData("LoginPage", "Password", 2);
		lp.inputUserName(username);
		lp.inputPassWord(password);
		lp.login();
		DashBoardPage dp=PageFactory.initElements(driver, DashBoardPage.class);
		dp.checkIfDashBoardIsLaunched();
	}
	
	@Test(priority=2)
	public void createNewAccount() throws IOException, InterruptedException
	{
		NewAccountPage nap = PageFactory.initElements(driver, NewAccountPage.class);
		nap.clickBankAndCashLink();
		nap.clickNewAccountLink();
		ExcelReader rd = new ExcelReader("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//testdata//TestNGProject1.xlsx");
		List<Map<String,String>> lMap = rd.getSheetData("NewAccountPage");
		Map<String,String> map= lMap.get(0);
		
		String accountTitle=map.get("AccountTitle");
		String description = map.get("Description");
		String initialBalance =map.get("InitialBalance");
		String accountNumber =map.get("AccountNumber");
		String contactPerson =map.get("ContactPerson"); 
		String phoneNumber=map.get("PhoneNo");
		String internetBankingUrl=map.get("internetBankingUrl");
		
		nap.inputAccountTitle(accountTitle);
		nap.inputDescription(description);
		nap.inputInitialBalance(initialBalance);
		nap.inputAccountNumber(accountNumber);
		nap.inputContactPerson(contactPerson);
		nap.inputPhoneNumber(phoneNumber);
		nap.inputInternetBankingUrl(internetBankingUrl);
		
		Thread.sleep(3000);
		nap.clickCreateAccount();
		BrowserFactory.tearDown();
	}
	
}
