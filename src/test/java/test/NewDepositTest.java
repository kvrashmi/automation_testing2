package test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import page.NewDepositPage;
import util.BrowserFactory;
import util.CSVReaderHelper;
import util.ExcelReader;

public class NewDepositTest {
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
	public void createNewDeposit()
	{
		CSVReaderHelper csv_helper = new CSVReaderHelper("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//testdata//TestNGProject1.csv");
		List<Map<String,String>> lmap = csv_helper.readCSVFileUsingOpenCSV();
		Map<String,String> map = lmap.get(0);
		//System.out.println(map.size());
		//System.out.println(map.values());
		NewDepositPage ndp = PageFactory.initElements(driver, NewDepositPage.class);
		ndp.clickTransactionLink();
		ndp.clickDepositLink();
		ndp.selectAccount(map.get("Account"));
		ndp.pickDate(map.get("Date"));
		ndp.inputDescription(map.get("Description"));
		ndp.fileUpload(map.get("FilePath"));
		ndp.inputAmount(map.get("Amount"));
		ndp.clickAdvanced();
		ndp.selectCategory(map.get("Category"));
		ndp.selectPayer(map.get("Payee"));
		ndp.selectPayment(map.get("Method"));
		ndp.clickDeposit();
		BrowserFactory.tearDown();
	}
}
			
