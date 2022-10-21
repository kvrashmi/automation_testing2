package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewDepositPage extends BasePage {
	
	WebDriver driver;
	
	public NewDepositPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[5]/a/span[1]")WebElement TRANSACTION_LINK;
	public void clickTransactionLink()
	{
		TRANSACTION_LINK.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='side-menu']/li[5]/ul/li[1]/a")WebElement NEW_DEP_LINK;
	public void clickDepositLink()
	{
		NEW_DEP_LINK.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"account\"]")WebElement SELECT_ACCOUNT;
	public void selectAccount(String visibleText)
	{
		super.explicitlyWaitForElements("SELECT","//*[@id=\"account\"]" );
		super.selectFromDropDown(By.xpath("//*[@id=\"account\"]"), visibleText);
	}
	
	//*[@id="date"]
	@FindBy(how=How.XPATH,using="//*[@id=\"date\"]")WebElement PICK_DATE;
	public void pickDate(String dateString)
	{
		PICK_DATE.sendKeys(dateString);
	}

	//*[@id="description"]
	@FindBy(how=How.XPATH,using="//*[@id=\"description\"]")WebElement DESCRIPTION;
	public void inputDescription(String desc)
	{
		DESCRIPTION.sendKeys(desc);
	}

	//*[@id="tform"]/div[3]/div/div/a
	@FindBy(how=How.XPATH,using="//*[@id=\"tform\"]/div[3]/div/div/a")WebElement FILE_UPLOAD;
	public void fileUpload(String filePath)
	{
		FILE_UPLOAD.sendKeys(filePath);
	}

	//*[@id="amount"]
	@FindBy(how=How.XPATH,using="//*[@id=\"amount\"]")WebElement AMOUNT;
	public void inputAmount(String amount)
	{
		AMOUNT.sendKeys(amount);
	}

	//*[@id="cats"]
	@FindBy(how=How.XPATH,using="//*[@id=\"cats\"]")WebElement SELECT_CATEGORY;
	public void selectCategory(String visibleText)
	{
		super.explicitlyWaitForElements("SELECT","//*[@id=\"cats\"]" );
		super.selectFromDropDown(By.xpath("//*[@id=\"cats\"]"), visibleText);
	}

	//*[@id="tags"]
	@FindBy(how=How.XPATH,using="//*[@id=\"tags\"]")WebElement SELECT_TAGS;

	//*[@id="payer"]
	@FindBy(how=How.XPATH,using="//*[@id=\"payer\"]")WebElement SELECT_PAYER;
	public void selectPayer(String visibleText)
	{
		super.explicitlyWaitForElements("SELECT","//*[@id=\"payer\"]" );
		super.selectFromDropDown(By.xpath("//*[@id=\"payer\"]"), visibleText);
	}

	//*[@id="pmethod"]
	@FindBy(how=How.XPATH,using="//*[@id=\"pmethod\"]")WebElement SELECT_PAYMENT;
	public void selectPayment(String visibleText)
	{
		super.explicitlyWaitForElements("SELECT","//*[@id=\"pmethod\"]" );
		super.selectFromDropDown(By.xpath("//*[@id=\"pmethod\"]"), visibleText);
	}

	//*[@id="ref"]
	@FindBy(how=How.XPATH,using="//*[@id=\"ref\"")WebElement REF;
	public void inputRef(String ref)
	{
		REF.sendKeys(ref);
	}

	
	//*[@id="a_toggle"]
	@FindBy(how=How.XPATH,using="//*[@id=\"a_toggle\"]")WebElement ADVANCED;
	public void clickAdvanced()
	{	
		ADVANCED.click();
	}

	//*[@id="submit"]
	@FindBy(how=How.XPATH,using="//*[@id=\"submit\"]")WebElement DESPOSIT;
	public void clickDeposit()
	{
		DESPOSIT.click();
	}
	
}
