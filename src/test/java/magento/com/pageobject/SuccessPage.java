package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends MenuToolBar {

	@FindBy(css = "#maincontent > div.columns > div > div.checkout-success > p:nth-child(2)")
	WebElement ConfirmationText;

	public SuccessPage(WebDriver driver) {
		super(driver);
	}

	// A method that returns the purchase message
	public String getThankYouText() {
		waitingToElement(ConfirmationText);
		String purchase = getText(ConfirmationText);
		System.out.println(getText(ConfirmationText));
		return purchase;
	}

}
