package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewOrderPage {

	@FindBy(how=How.XPATH,using="")WebElement PRODUCT_OR_SERVICE;
	@FindBy(how=How.XPATH,using="")WebElement CUSTOMER;
	@FindBy(how=How.XPATH,using="")WebElement STATUS;
	@FindBy(how=How.XPATH,using="")WebElement PRICE;
	@FindBy(how=How.XPATH,using="")WebElement BILLING_CYCLE;
	@FindBy(how=How.ID,using="")WebElement GENERATE_INVOICE;
	@FindBy(how=How.ID,using="")WebElement SEND_EMAIL;
	@FindBy(how=How.ID,using="")WebElement SUBMIT;
	@FindBy(how=How.ID,using="")WebElement CANCEL;

}
