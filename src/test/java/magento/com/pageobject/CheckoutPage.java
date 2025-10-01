package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends MenuToolBar {
	// Information fields
	@FindBy(css = "[class=\"control _with-tooltip\"]>#customer-email")
	private WebElement EmailField;
	@FindBy(css = "[name=\"firstname\"]")
	private WebElement firstNameField;
	@FindBy(css = "[name=\"lastname\"]")
	private WebElement lastNameField;
	@FindBy(css = "[name=\"street[0]\"]")
	private WebElement streetAddressField;
	@FindBy(css = "[name=\"country_id\"]")
	private WebElement countryBtn;
	@FindBy(css = "[name=\"city\"]")
	private WebElement cityField;
	@FindBy(css = "[name=\"postcode\"]")
	private WebElement postCodeField;
	@FindBy(css = "[name=\"telephone\"]")
	private WebElement phoneField;


	// Shipping Methods
	@FindBy(css = "#opc-shipping_method > div")
	private WebElement ShippingMethodsFields;

	@FindBy(css = "[type=\"radio\"]")
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

	public void FillShippingInfo(String email, String firstName, String lastName, String street, String country,
			String city,String postCode,String phone, String ShippingMethod) {
		waitingToElement(EmailField);
		fillText(EmailField, email);
		waitingToElement(firstNameField);
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(streetAddressField, street);
		click(countryBtn);
		selectByValue(countryBtn, country);
		fillText(cityField, city);
		fillText(postCodeField, postCode);
		fillText(phoneField, phone);
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
		waitingToElement(Nextbtn);
		click(Nextbtn);

	}

}
