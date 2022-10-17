package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage {
	
	WebDriver driver;
	 public DashBoardPage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	
	//@FindBy(how=How.XPATH,using="html/body/section/div/div/div[2]/div[1]/h2")WebElement dashBoardText;
	 @FindBy(how=How.XPATH,using="//h2[contains(text(),'Dashboard')]")WebElement DASHBOARD_TEXT;
	 @FindBy(how=How.XPATH,using="//span[contains(text(),'Customers')]")WebElement CUSTOMER_MENU;
	 @FindBy(how=How.XPATH,using="//a[contains(text(),'Add Customer')]")WebElement ADD_CUSTOMER_MENU;

	 
	public void checkIfDashBoardIsLaunched()
	{
		Assert.assertEquals(DASHBOARD_TEXT.getText(),"Dashboard","Page not found!!!");
	}
	
	public void clickCustomerMenu()
	{
		CUSTOMER_MENU.click();
	}
	
	public void clickAddCustomer()
	{
		ADD_CUSTOMER_MENU.click();
	}

}
