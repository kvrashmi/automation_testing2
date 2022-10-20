package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountPage extends BasePage{
	
	WebDriver driver;
	
	public NewAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH,using="/html/body/section/div/nav/div/ul/li[10]/a/span[1]")WebElement BANK_AND_CASH;
	public void clickBankAndCashLink()
	{
		super.explicitlyWaitForElements("Link", "/html/body/section/div/nav/div/ul/li[10]/a/span[1]");
		BANK_AND_CASH.click();
	}
	
	@FindBy(how=How.XPATH,using="/html/body/section/div/nav/div/ul/li[10]/ul/li[1]/a")WebElement NEW_ACCOUNT;
	public void clickNewAccountLink()
	{
		super.explicitlyWaitForElements("Link", "/html/body/section/div/nav/div/ul/li[10]/ul/li[1]/a");
		NEW_ACCOUNT.click();
	}
	
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[1]/input")WebElement ACCOUNT_TITLE;
	public void inputAccountTitle(String title)
	{
		ACCOUNT_TITLE.sendKeys(title);
	}
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[2]/input")WebElement DESCRIPTION;
	public void inputDescription(String desc)
	{
		DESCRIPTION.sendKeys(desc);
	}
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[3]/input")WebElement INITIAL_BALANCE;
	public void inputInitialBalance(String iBalance)
	{
		INITIAL_BALANCE.sendKeys(iBalance);
	}
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[4]/input")WebElement ACCOUNT_NUMBER;
	public void inputAccountNumber(String accNumber)
	{
		ACCOUNT_NUMBER.sendKeys(accNumber);
	}
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[5]/input")WebElement CONTACT_PERSON;
	public void inputContactPerson(String cPerson)
	{
		CONTACT_PERSON.sendKeys(cPerson);
	}
	
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[6]/input")WebElement PHONE_NUMBER;
	public void inputPhoneNumber(String phNo)
	{
		PHONE_NUMBER.sendKeys(phNo);
	}
	
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[7]/input")WebElement INTERNET_BANKING_URL;
	public void inputInternetBankingUrl(String url)
	{
		INTERNET_BANKING_URL.sendKeys(url);
	}
	
	@FindBy(how=How.XPATH,using="/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/button")WebElement CREATE_ACCOUNT;
	public void clickCreateAccount()
	{
		CREATE_ACCOUNT.submit();
	}
	
}
