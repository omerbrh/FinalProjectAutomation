package magento.com.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuToolBar extends BasePage {


	@FindBy(css = "#ui-id-4 > span:nth-child(2)")
	protected WebElement Womanbtn;
	@FindBy(css = "#ui-id-5 > span:nth-child(2)")

	// Men menu elements
	protected WebElement Menbtn;
	@FindBy(css = "#ui-id-5 > span.ui-menu-icon.ui-icon.ui-icon-carat-1-e")
	protected WebElement MensMarker;
	@FindBy(css = "#ui-id-17 > span:nth-child(2)")
	protected WebElement Topsbtn;
	@FindBy(css = "#ui-id-19")
	protected WebElement Jacketsbtn;
	@FindBy(css = "#ui-id-18")
	protected WebElement Bottombtn;

	// Women menu elements

	@FindBy(css = "#ui-id-4")
	protected WebElement Womenbtn;
	@FindBy(css = "#ui-id-9")
	protected WebElement WomenTopbtn;
	@FindBy(css = "#ui-id-10")
	protected WebElement WomenBottomsbtn;

	// Gear menu element
	@FindBy(css = "#ui-id-6")
	protected WebElement Gearbtn;

	// cart buttons
	@FindBy(css = "body > div.page-wrapper > header > div.header.content > div.minicart-wrapper.active > a > span.text")
	protected WebElement Cartbtn;
	@FindBy(css = "#minicart-content-wrapper > div.block-content > div:nth-child(7) > div > a > span")
	protected WebElement ViewItemsbtn;

	@FindBy(css = ".minicart-wrapper > a")
	private WebElement cartIcon;

	@FindBy(css = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a")
	protected WebElement MSignInbtn;

	// Validation on this page
	@FindBy(css = " header > div.panel.wrapper > div > ul > li.greet.welcome > span")
	protected WebElement WelcomeUser;

	public MenuToolBar(WebDriver driver) {
		super(driver);

	}

	// A method that waits for the appearance of the welcome text
	public void watingToWelcome() {
		waitingToElement(WelcomeUser);
	}

	// A method that returns the welcome text
	public String getWelcomeUser() {
		sleep(1000);
		return getText(WelcomeUser);
	}


	// A method for safely clicking a button hidden by an advertisement
	public void clickSafe(WebElement el) {
		try {
			skipAds();
		} catch (Exception e) {
		}

		try {
			waitingToElement(el);
			highlightElement(el, "black", "orange");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
		} catch (Exception e) {
			System.out.println("Unable to click on this element");
		}
	}

	// A method that collects the items from the basket and groups them into a list
	public List<String> getCartItemNames() {
		List<String> helperCartItems = new ArrayList<>();
		waitingToElement(cartIcon);
		click(cartIcon);
		List<WebElement> itemsName = driver
				.findElements(By.cssSelector("[class=\"product-item-details\"]>[class=\"product-item-name\"]>a"));
		for (WebElement el : itemsName) {
			waitingToElement(el);
			helperCartItems.add(el.getText());

		}
		return helperCartItems;

	}

	// A method that collects items and returns them in a list.
	public List<String> itemsToList(String... items) {
		List<String> list = new ArrayList<>();
		for (String item : items) {
			list.add(item);

		}

		return list;
	}

}
