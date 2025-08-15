package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends MenuToolBar {
	// Information fields
	@FindBy(css = "[class=\"control _with-tooltip\"]>#customer-email")
	private WebElement EmailField;
	@FindBy(css = "#customer-password")
	private WebElement PasswordField;

	// Buttons
	@FindBy(css = "#customer-email-fieldset > fieldset > div.actions-toolbar > div.primary > button > span")
	private WebElement Loginbtn;

	// Shipping Methods
	@FindBy(css = "#opc-shipping_method > div")
	private WebElement ShippingMethodsFields;

	@FindBy(css = "[class=\"col col-method\"]>[name=\"ko_unique_2\"]")
	private WebElement Fixedbtn;

	@FindBy(css = "[class=\"col col-method\"]>[name=\"ko_unique_1\"]")
	private WebElement TableRatebtn;

	@FindBy(css = "[alt=\"Loading...\"]")
	private WebElement loading;

	@FindBy(css = "[data-role=\"opc-continue\"]")
	private WebElement Nextbtn;

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	public void FillShippingInfo(String email, String password, String ShippingMethod) {
		waitingToElement(EmailField);
		fillText(EmailField, email);
		waitingToElement(PasswordField);
		fillText(PasswordField, password);
		click(Loginbtn);
		waitingToElement(ShippingMethodsFields);
		waitingToElementDisappear(loading);
		if (ShippingMethod.equalsIgnoreCase("Fixed")) {
			waitingToElement(Fixedbtn);
			clickSafe(Fixedbtn);
			System.out.println("You choose Flat Rate shipping method");
		} else if (ShippingMethod.equalsIgnoreCase("Table Rate")) {
			waitingToElement(TableRatebtn);
			clickSafe(TableRatebtn);
			System.out.println("You choose Best Way shipping method");

		} else {
			System.out.println("You must choose between Fixed to Table Rate");

		}
		click(Nextbtn);

	}

}
