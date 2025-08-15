package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage extends MenuToolBar {

	@FindBy(css = "#checkout-payment-method-load > div > div > div.payment-method._active > div.payment-method-content > div.actions-toolbar > div > button > span")
	WebElement PlaceOrderbtn;
	@FindBy(css = "[alt=\"Loading...\"]")
	WebElement Loading;

	public PaymentsPage(WebDriver driver) {
		super(driver);

	}

	// A method that clicks on the PLACR ORDER button
	public void clickPlaceOrder() {
		waitingToElement(Loading);
		waitingToElementDisappear(Loading);
		click(PlaceOrderbtn);
	}

}
