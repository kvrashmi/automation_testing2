package homework;

 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

/*
 * Automate the following test case:
Scenario: Users will be able to add deposit
1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
2. Enter username: demo@techfios.com 
3. Enter password: abc123
4. Click login button
5. Click on Transactions button
6. Click on New Deposit button 
7. Click on Open An Account drop down to expand it
8. Click on any account name
9. Type any description
10. Type any amount			
11. Click on submit button
Visually check to make sure the deposit posted

 */
public class Homework2 {
	
	static WebDriver driver;
	static String optGroupUrl="http://www.techfios.com/billing/?ng=admin/";
	
	public static String getCurrentUrlForHM2()
	{
		String current_url=driver.getCurrentUrl();
		System.out.println("current url:"+current_url);
		return current_url;
	}
	
	public static boolean compareUrls(String url1,String url2)
	{
		return url1.equals(url2);
	}
	
	
	@BeforeSuite
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(optGroupUrl);
	}
	
	@Test(priority=1)
	public void loginApplication() 
	{
		System.out.println("TC1_Login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String current_url=Homework2.getCurrentUrlForHM2();
		
		//username: /html/body/div/div/div/form/div[1]/input
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		System.out.println("Identified username...");
		
		//password: //input[@id='password']
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		System.out.println("Identified password...");
		
		username.sendKeys("demo@techfios.com");
		password.sendKeys("abc123");
		
		WebElement loginBtn = driver.findElement(By.name("login"));
		if(loginBtn.isDisplayed())
		{
			loginBtn.submit();
		}
		System.out.println("Login Button Clicked...");
	}
	
	
	@Test(priority=2)
	public void openTransactions()
	{
		System.out.println("TC2_ClickTransactionsBtn");
		String current_url=Homework2.getCurrentUrlForHM2();
		// Bank and Cash: /html/body/section/div/nav/div/ul/li[10]/a/span[1]
		//*[@id="side-menu"]/li[10]/a/span[1]
		if(Homework2.compareUrls(current_url, "https://techfios.com/billing/?ng=dashboard/"))
		{
			WebElement transactions = driver.findElement(By.xpath("//*[@id='side-menu']/li[5]/a/span[1]"));
			System.out.println(transactions.getText());
			transactions.click();
		}
		
	}
	
	@Test(priority=3)
	public void openNewDeposit()
	{
		System.out.println("TC3_ClicklNewDeposit");
		WebElement newDeposit = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a"));
		newDeposit.click();
	}
	
	@Test(priority=4)
	public void fillFormForDeposit()
	{
		System.out.println("TC4_FillFormAndSubmit");
		String current_url=Homework2.getCurrentUrlForHM2();
		//*[@id="account"]/option[@value='Techfios']
		if(Homework2.compareUrls(current_url,"https://techfios.com/billing/?ng=transactions/deposit/"))
		{
			WebElement account = driver.findElement(By.xpath("//*[@id=\"account\"]"));
			Select sel1 = new Select(account);
			sel1.selectByValue("Techfios");
			System.out.println(sel1.getFirstSelectedOption().getText() + " is selected.");
			
			WebElement description =  driver.findElement(By.xpath("//*[@id=\"description\"]"));
			description.sendKeys("First Deposit");
			
			//Users/rashmikanduluvavikraman/Desktop/Upload.png
			WebElement attachFile =  driver.findElement(By.xpath("//*[@id=\"tform\"]/div[3]/div/div/a"));
			attachFile.sendKeys("//Users/rashmikanduluvavikraman/Desktop/Upload.png");
			
			//WebElement dateToSel =  driver.findElement(By.xpath("[@id=\"ref\"]"));;
			
			WebElement amount =  driver.findElement(By.xpath("//*[@id=\"amount\"]"));
			amount.sendKeys("1500");
			
			//*[@id="a_toggle"]
			WebElement advanced= driver.findElement(By.xpath("//*[@id=\"a_toggle\"]"));
			advanced.click();
			
			//*[@id="cats"]
			WebDriverWait wait1 = new WebDriverWait(driver,5);
			wait1.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath("//*[@id=\"cats\"]"),By.tagName("option")));
			Select sel2 = new Select(driver.findElement(By.xpath("//*[@id=\"cats\"]")));
			sel2.selectByIndex(2);
			System.out.println(sel2.getFirstSelectedOption().getText() + " is selected.");
			
			WebDriverWait wait2 = new WebDriverWait(driver,5);
			wait2.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath("//*[@id=\"payer\"]"),By.tagName("option")));
			Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"payer\"]")));
			sel3.selectByIndex(2);
			System.out.println(sel3.getFirstSelectedOption().getText() + " is selected.");
			
			
			//pmethod
			WebDriverWait wait3 = new WebDriverWait(driver,5);
			wait3.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath("//*[@id=\"pmethod\"]"),By.tagName("option")));
			Select sel4 = new Select(driver.findElement(By.xpath("//*[@id=\"pmethod\"]")));
			sel4.selectByIndex(2);
			System.out.println(sel4.getFirstSelectedOption().getText() + " is selected.");
			
			//*[@id="ref"]
			WebElement ref = driver.findElement(By.xpath("//*[@id=\"ref\"]"));
			ref.sendKeys("10001");
			
			
			WebElement sub = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
			sub.click();
			System.out.println("Amount Deposited.");
			
		}
	}
	
	
	@AfterSuite
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
