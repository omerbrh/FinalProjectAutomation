package magento.com.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	// A method that appends text to a field
	public void fillText(WebElement el, String text) {
		highlightElement(el, "red", "yellow");
		el.clear();
		el.sendKeys(text);
	}

	// A method that clicks on an element
	public void click(WebElement el) {
		highlightElement(el, "black", "orange");
		el.click();
	}

	// A method that returns an element's text
	public String getText(WebElement el) {
		return el.getText();

	}

	// A method that performs sleep
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// A method that switches between options for selection
	public void selectByValue(WebElement el, String value) {
		highlightElement(el, "black", "red");
		Select s = new Select(el);
		s.selectByValue(value);

	}

	// method of moving the mouse
	public void moveto(WebElement el) {
		skipAds();
		try {
			highlightElement(el, "green", "purple");
			actions.moveToElement(el).build().perform();

		} catch (Exception e) {
			scrollDown();
			sleep(500);
			highlightElement(el, "green", "purple");
			actions.moveToElement(el).build().perform();

		}

	}

	// A method that clicks on the menu buttons and ignores advertising
	public void hoverTopMenu(WebElement menuItem) {
		skipAds();

		waitingToElement(menuItem);

		((JavascriptExecutor) driver).executeScript("var ad = document.querySelector('#adBannerId');"
				+ "if(ad) { ad.style.setProperty('display', 'none', 'important'); }");

		if (!menuItem.isDisplayed() || !menuItem.isEnabled()) {
			scrollDown();
			skipAds();
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", menuItem);

		highlightElement(menuItem, "green", "purple");
		actions.moveToElement(menuItem).perform();
	}

	public void scrollDown() {
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	// A method that waits for an element to appear
	public void waitingToElement(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	// A method that waits for an element to appear
	public void waitForListVisible(List<WebElement> list) {
		wait.until(driver -> !list.isEmpty() && list.get(0).isDisplayed());
	}

	// A method that waits for an element to disappear
	public void waitingToElementDisappear(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	// Call this method with your element and a color like (red,green,orange etc...)
	protected void highlightElement(WebElement element, String color, String backround) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:" + backround + ";border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

	// Method for skipping ads / banners / overlays
	public void skipAds() {
		List<By> adSelectors = List.of(By.cssSelector("iframe[id^='aswift_']"), By.id("google_esf"),
				By.cssSelector("body > ins"), By.id("adBannerId"), By.cssSelector(".popup-message"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (By adSelector : adSelectors) {
			List<WebElement> ads = driver.findElements(adSelector);

			for (WebElement ad : ads) {
				try {
					js.executeScript("arguments[0].style.setProperty('display', 'none', 'important');", ad);
				} catch (Exception e) {
					System.out.println("Failed to hide ad element: " + adSelector);
				}
			}
		}

		try {
			js.executeScript("document.querySelectorAll('*').forEach(el => {"
					+ "  const z = window.getComputedStyle(el).zIndex;" + "  if(!isNaN(z) && z > 1000) {"
					+ "    el.style.setProperty('display', 'none', 'important');" + "  }" + "});");
		} catch (Exception e) {
			System.out.println("Failed to auto-hide high z-index elements.");
		}

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void waitForInvisibility(By locator) {
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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


}
