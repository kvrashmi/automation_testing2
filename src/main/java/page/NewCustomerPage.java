package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import util.Helper;

public class NewCustomerPage extends BasePage{
	
	 WebDriver driver;
	 public NewCustomerPage (WebDriver driver)
	 {
		 super(driver);
	 }
	
	 @FindBy(how=How.XPATH,using="//h2[contains(text(),'Contact')]")WebElement CONTACT_TEXT;
	 
	 @FindBy(how=How.XPATH,using="//input[@id='account']")WebElement FULLNAME;
	 @FindBy(how=How.XPATH,using="//input[@id='email']")WebElement EMAIL;
	 @FindBy(how=How.XPATH,using="//input[@id='phone']")WebElement PHONE;
	 @FindBy(how=How.XPATH,using="//input[@id='address']")WebElement ADDRESS;
	 @FindBy(how=How.XPATH,using="//input[@id='city']")WebElement CITY;
	 @FindBy(how=How.XPATH,using="//input[@id='state']")WebElement STATE;
	 @FindBy(how=How.XPATH,using="//input[@id='zip']")WebElement ZIP;
	 @FindBy(how=How.XPATH,using="//input[@id='password']")WebElement PASSWORD;
	 @FindBy(how=How.XPATH,using="//input[@id='cpassword']")WebElement CONFIRM_PASSWORD;
	  
	public void checkIfAddContactsPageIsLaunched()
	{
		Assert.assertEquals(CONTACT_TEXT.getText(),"Contacts","Page not found!!!");
	}
	
	public void inputFullName(String fullName)
	{
		FULLNAME.sendKeys(fullName);
	}
	
	public void inputEmail(String email)
	{
		int num=Helper.generateRandomNumber(100);
		String emailId= "rashmi"+num+"demo@techfios.com";
		EMAIL.sendKeys(emailId);
	}
	
	public void inputPhone(String phone)
	{
		PHONE.sendKeys(phone);
	}
	
	public void inputAddress(String address)
	{
		ADDRESS.sendKeys(address);
	}
	
	public void inputCity(String city)
	{
		CITY.sendKeys(city);
	}
	
	public void inputState(String state)
	{
		STATE.sendKeys(state);
	}
	
	public void inputZip(String zip)
	{
		ZIP.sendKeys(zip);
	}
	
	public void inputPassword(String password)
	{
		PASSWORD.sendKeys(password);
	}
	
	public void inputConfirmPassword(String confirmPassword)
	{
		CONFIRM_PASSWORD.sendKeys(confirmPassword);
	}
	
	@FindBy(how=How.XPATH,using="//select[@id='cid']")WebElement COMPANY;
	@FindBy(how=How.XPATH,using="//select[@id='country']")WebElement COUNTRY;
	@FindBy(how=How.XPATH,using="//select[@id='currency']")WebElement CURRENCY;
	@FindBy(how=How.XPATH,using="//select[@id='group']")WebElement GROUP;
	
	public void selectCompany(String visibleText)
	{
		super.explicitlyWaitForElements("Select", "//select[@id='cid']");
		super.selectFromDropDown(COMPANY,visibleText);
	}
	
	public void selectCountry(String visibleText)
	{
		super.explicitlyWaitForElements("Select", "//select[@id='country']");
		super.selectFromDropDown(COUNTRY,visibleText);
	}
	
	public void selectCurrency(String visibleText)
	{
		super.explicitlyWaitForElements("Select", "//select[@id='currency']");
		super.selectFromDropDown(CURRENCY,visibleText);
	}
	
	public void selectGroup(String visibleText)
	{
		super.explicitlyWaitForElements("Select", "//select[@id='group']");
		super.selectFromDropDown(GROUP,visibleText);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='submit']")WebElement SAVE_BUTTON;
	public void saveContact()
	{
		SAVE_BUTTON.click();
	}

	/*
	 * //*[@id="page-wrapper"]/div[3]/div[2]/div[2]/div/div[1]/h5
	 
	@FindBy(how=How.XPATH,using="//*[@id=\"page-wrapper\"]/div[3]/div[2]/div[2]/div/div[1]/h5")WebElement CONTACT_CONFIRMATION;
	public void validateIfContactIsCreated(String fullName)
	{
		Assert.assertEquals(CONTACT_CONFIRMATION.getText(),fullName,"Contact is not created...");
	}
	*/
}
