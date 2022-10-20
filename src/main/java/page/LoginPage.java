package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//WebElements List
	@FindBy(how=How.XPATH,using="//input[@id='username']")WebElement USER_NAME;
	@FindBy(how=How.XPATH,using="//input[@id='password']")WebElement PASS_WORD;
	@FindBy(how=How.NAME,using="login")WebElement SIGNIN_BUTTON;
	@FindBy(how=How.XPATH,using="/html/body/div/div/div/div[2]")WebElement INVALID_TEXT;
	
	
	//Methods
	public void inputUserName(String userName)
	{
		USER_NAME.sendKeys(userName);
	}
	
	public void inputPassWord(String passWord)
	{
		PASS_WORD.sendKeys(passWord);
	}
	
	public void login()
	{
		SIGNIN_BUTTON.click();
	}
	
	public boolean checkIfInvalidUserTextAppeared()
	{
		if(INVALID_TEXT.getText().trim().equals("×\n"
				+ "Invalid Username or Password"))
		{
			return true;
		}
		return false;
		
	}
	
	public void informInvalidUserTextAppeared()
	{
		Assert.assertEquals(INVALID_TEXT.getText().trim(),"×\n"
				+ "Invalid Username or Password","Invalid Login!");

	}

}
