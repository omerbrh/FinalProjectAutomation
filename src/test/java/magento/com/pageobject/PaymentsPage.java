package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage extends MenuToolBar {

	@FindBy(css = "[name=\"payment[method]\"]")
	private WebElement checkrbtn;
	@FindBy(css = "[class=\"action primary checkout\"]")
	private WebElement placeOrderbtn;
	@FindBy(css = "[alt=\"Loading...\"]")
	private WebElement Loading;

	public PaymentsPage(WebDriver driver) {
		super(driver);

	}

	// A method that clicks on the PLACR ORDER button
	public void clickPlaceOrder() {
		waitingToElement(checkrbtn);
		click(checkrbtn);
		waitingToElement(Loading);
		waitingToElementDisappear(Loading);
		click(placeOrderbtn);
	}

}
