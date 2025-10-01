package magento.com.pageobject;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuToolBar extends BasePage {

	// Men menu elements
	@FindBy(css = "#ui-id-12")
	protected WebElement Menbtn;
	@FindBy(css = "#ui-id-13")
	protected WebElement Topsbtn;
	@FindBy(css = "#ui-id-18")
	protected WebElement Bottombtn;

	// Women menu elements

	@FindBy(css = "#ui-id-3")
	protected WebElement Womenbtn;
	@FindBy(css = "#ui-id-4")
	protected WebElement WomenTopbtn;
	@FindBy(css = "#ui-id-9")
	protected WebElement WomenBottomsbtn;

	// Gear menu element
	@FindBy(css = "#ui-id-21")
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
	@FindBy(css = "[class=\"panel header\"]>[class=\"header links\"]>[class=\"greet welcome\"]>[class=\"logged-in\"]")
	protected WebElement WelcomeUser;

	public MenuToolBar(WebDriver driver) {
		super(driver);

	}

	public void closeWelcome() {
		sleep(500);
		List<WebElement>closeBtn =driver.findElements(By.cssSelector("[class=\"btn btn-close\"]"));
		for (WebElement btn : closeBtn) {
			if (btn.isDisplayed() && btn.isEnabled()) {
				waitingToElement(btn);
				clickSafe(btn);
				waitingToElementDisappear(btn);
				break;
			}
		}

		List<WebElement> overlays = driver.findElements(By.cssSelector(".background-overlay"));
		if (!overlays.isEmpty() && overlays.get(0).isDisplayed()) {
			try {
				sleep(200);
				waitForInvisibility(By.cssSelector(".background-overlay"));
				System.out.println("Overlay disappeared successfully.");
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("Overlay did not disappear in time, retrying...");
				try {
					Thread.sleep(500);
					waitForInvisibility(By.cssSelector(".background-overlay"));
				} catch (Exception ex) {
					System.out.println("Still not disappeared, proceed carefully");
				}
			}
		   
		} 
	
		
	}

	// A method that waits for the appearance of the welcome text
	public void watingToWelcome() {
		waitingToElement(WelcomeUser);
	}

	// A method that returns the welcome text
	public String getWelcomeUser() {
		if (!WelcomeUser.isDisplayed()) {
			sleep(200);
			
		}
		waitingToElement(WelcomeUser);
		return getText(WelcomeUser);
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

	public boolean isCartCorrect(String... items) throws InterruptedException {
		Thread.sleep(1000);
		List<String> expectedItems = itemsToList(items);
		List<String> actualItems = getCartItemNames();
		return actualItems.containsAll(expectedItems) && expectedItems.containsAll(actualItems);
	}

}
