package magento.com.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartpage extends MenuToolBar {

//First item element 
	@FindBy(css = "#shopping-cart-table .item-info .col.item strong a")
	private WebElement FirstItemName;
	public String ItemName;

	@FindBy(css = "#shopping-cart-table > tbody:nth-child(3) > tr.item-info > td.col.item > div > dl > dd:nth-child(2)")
	private WebElement FirstItemSize;
	public String ItemSize;

	@FindBy(css = "#shopping-cart-table > tbody > tr.item-info > td.col.item > div > dl > dd:nth-child(4)")
	private WebElement FirstItemColor;
	public String ItemColor;

	@FindBy(css = "[data-th=\"Item\"]>[class=\"product-item-details\"]>[class=\"product-item-name\"]")
	private List<WebElement> itemsNames;

	// Buttons of the page
	@FindBy(css = "#maincontent > div.columns > div > div.cart-container > div.cart-summary > ul > li:nth-child(1) > button > span")
	private WebElement Checkoutbtn;
	@FindBy(css = "#cart-totals > div")
	private WebElement loudingPrice;
	@FindBy(css = "[class=\"input-text qty\"]")
	private List<WebElement> listOfQtyItems;
	@FindBy(css = " [title=\"Update Shopping Cart\"] ")
	private WebElement Updatebtn;
	@FindBy(css = " [class=\"loader\"]>[alt=\"Loading...\"]")
	private WebElement loudingSpin;
	@FindBy(css = " [class=\"col subtotal\"]>[class=\"price-excluding-tax\"]>[class=\"cart-price\"]>[class=\"price\"]")
	private List<WebElement> prices;

	@FindBy(css = "[class=\"actions-toolbar\"]>[title=\"Remove item\"]")
	private List<WebElement> garbageCanList;

	// Cart variables
	private int quantityToEdit;
	private double finalPriceFirst;
	private double finalPriceSecond;

	public Cartpage(WebDriver driver) {
		super(driver);
	}

	// A method that populates the variables and proceeds to complete a purchase

	public void DoCheckout() {

		waitingToElement(loudingPrice);
		waitingToElement(FirstItemName);
		ItemName = getText(FirstItemName);
		waitingToElement(FirstItemSize);
		ItemSize = getText(FirstItemSize);
		waitingToElement(FirstItemSize);
		ItemColor = getText(FirstItemColor);

		click(Checkoutbtn);
	}

	// A method that edits the quantities of products in the cart and returns a
	// before and after value.
	public void editQtyOfAllItems(String qty) {
		if (qty != null && !qty.trim().isEmpty() && !qty.trim().equals("0")) {
			finalPriceFirst = getFinalPrice();
			quantityToEdit = Integer.parseInt(qty);

			for (WebElement el : listOfQtyItems) {
				waitingToElement(el);
				fillText(el, qty);
			}
			waitingToElement(Updatebtn);
			clickSafe(Updatebtn);
			waitingToElement(loudingSpin);
			waitingToElementDisappear(loudingSpin);
			finalPriceSecond = getFinalPrice();

		} else {
			throw new IllegalArgumentException("Quantity must not be null, empty, or '0'");
		}

	}

	// A method that converts a string of prices to numbers and sums them
	public double getFinalPrice() {
		double totalPrice = 0;
		for (WebElement el : prices) {
			waitingToElement(loudingPrice);
			waitingToElement(el);
			double price = Double.parseDouble(el.getText().trim().replace("$", ""));
			totalPrice += price;
		}

		System.out.println("The total price of the products is $" + totalPrice);
		return totalPrice;
	}

	public void deleteItemFromCart(String itemToDeleted) {
		finalPriceFirst = getFinalPrice();
		for (int i = 0; i < itemsNames.size(); i++) {
			String name = itemsNames.get(i).getText();
			if (name.equals(itemToDeleted.trim())) {
				click(garbageCanList.get(i));
			}
			;

		}
		;

		finalPriceSecond = getFinalPrice();

	};

	public String getItemName() {
		return ItemName;
	}

	public String getItemSize() {
		return ItemSize;
	}

	public String getItemColor() {
		return ItemColor.toLowerCase();
	}

	public double getFinalPriceFirst() {
		return finalPriceFirst;
	}

	public double getFinalPriceSecond() {
		return finalPriceSecond;
	}

	public int getQuantityToEdit() {
		return quantityToEdit;
	}

}
