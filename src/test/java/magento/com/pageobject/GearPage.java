package magento.com.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GearPage extends MenPage {

	@FindBy(css = ".counter.qty > .counter-number")
	private WebElement CounterItemsCart;
	@FindBy(css = "[title=\"Loading...\"]")
	private WebElement cartLoader;

	private int ItemsInCart;
	private int beforeCount;
	private int afterCount;
	private boolean inStock;

	public GearPage(WebDriver driver) {

		super(driver);

	}

//	Method that clicks on Add Item to Cart
	public void AddGear(boolean isItem, boolean page2, List<WebElement> pageItemList, int i) {

		if (isItem) {
			sleep(200);
			beforeCount = cartNumOfItem();

			if (!page2) {
				waitingToElement(AddToCartlist.get(i));
				 click(AddToCartlist.get(i));
				
			} else {
				waitingToElement(addToCartPage2.get(i));
				 click(addToCartPage2.get(i));
			}

			afterCount = cartNumOfItem();

			inStock = checkInStock();
		}

		if (!inStock) {
			sleep(1000);
			List<WebElement> errorMessages = driver
					.findElements(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div"));
			waitForListVisible(errorMessages);

			if (!errorMessages.isEmpty() && errorMessages.get(0).isDisplayed()) {
				System.out.println("This product is currently out of stock.");

			}

		}

	}

//	A method that checks if the product is in stock
	public boolean checkInStock() {

		if (afterCount > beforeCount) {
			inStock = true;
			System.out.println("The item is in stock");
			waitingToElement(addToCartMessage);
			System.out.println(addToCartMessage.getText());

		} else {
			inStock = false;
		}

		return inStock;

	}

//	A method that reduces the quantity of products in stock from a string to a number
	public int cartNumOfItem() {

		sleep(2000);
		if (CounterItemsCart.getText().trim().equalsIgnoreCase("")) {
			ItemsInCart = 0;

		} else {
			waitingToElementDisappear(cartLoader);
			waitingToElement(CounterItemsCart);
			ItemsInCart = Integer.parseInt(CounterItemsCart.getText().trim());

		}
		return ItemsInCart;

	}

}
