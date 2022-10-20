package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void selectFromDropDown(By locator,String visibleText)
	{
		Select sel=new Select(this.driver.findElement(locator));
		sel.selectByVisibleText(visibleText); 
	}
	
	public void selectFromDropDown(WebElement element,String visibleText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	public void explicitlyWaitForElements(String elemType,String locatorText)
	{
		WebDriverWait wait = new WebDriverWait(this.driver,30);
		if(elemType.equals("Select"))
		{
			wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath(locatorText),By.tagName("option")));
		}
		else if(elemType.equals("Link"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locatorText))));
		}
	}
}
