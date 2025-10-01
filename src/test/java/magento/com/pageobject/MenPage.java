package magento.com.pageobject;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class MenPage extends MenuToolBar {

	// item lists for page
	@FindBy(css = "[class=\"product-item-link\"]")
	protected List<WebElement> itemlistForPage;

	// Size lists
	@FindBy(css = "#option-label-size-144-item-166")
	protected List<WebElement> XSlist;
	@FindBy(css = "#option-label-size-144-item-167")
	protected List<WebElement> Slist;
	@FindBy(css = "#option-label-size-144-item-168")
	protected List<WebElement> Mlist;
	@FindBy(css = "#option-label-size-144-item-169")
	protected List<WebElement> Llist;
	@FindBy(css = "#option-label-size-144-item-170")
	protected List<WebElement> XLlist;

	@FindBy(css = "#option-label-size-144-item-171")
	protected List<WebElement> list28;
	@FindBy(css = "#option-label-size-144-item-172")
	protected List<WebElement> list29;
	@FindBy(css = "#option-label-size-144-item-173")
	protected List<WebElement> list30;
	@FindBy(css = "#option-label-size-144-item-174")
	protected List<WebElement> list31;
	@FindBy(css = "#option-label-size-144-item-175")
	protected List<WebElement> list32;
	@FindBy(css = "#option-label-size-144-item-176")
	protected List<WebElement> list33;
	@FindBy(css = "#option-label-size-144-item-177")
	protected List<WebElement> list34;
	@FindBy(css = "#option-label-size-144-item-178")
	protected List<WebElement> list36;
	protected String itemSize;
	protected boolean isSize = true;
	public String itemcolor;

	// colors lists
	@FindBy(css = "#option-label-color-93-item-49")
	protected List<WebElement> Blacklist;

	@FindBy(css = "#option-label-color-93-item-50")
	protected List<WebElement> Bluelist;

	@FindBy(css = "#option-label-color-93-item-56")
	protected List<WebElement> Orangelist;

	@FindBy(css = "#option-label-color-93-item-58")
	protected List<WebElement> Redlist;

	@FindBy(css = "#option-label-color-93-item-57")
	protected List<WebElement> Purplelist;

	@FindBy(css = "#option-label-color-93-item-59")
	protected List<WebElement> Whitelist;

	@FindBy(css = "#option-label-color-93-item-60")
	protected List<WebElement> Yellowlist;

	@FindBy(css = "#option-label-color-93-item-52")
	protected List<WebElement> Graylist;

	@FindBy(css = "#option-label-color-93-item-53")
	protected List<WebElement> Greenlist;

	@FindBy(css = "#option-label-color-93-item-54")
	protected List<WebElement> Lavenderlist;

	@FindBy(css = "#option-label-color-93-item-51")
	protected List<WebElement> Brownlist;
	protected boolean iscolor;

	// other buttons
	@FindBy(css = "[data-role=\"addToCartButton\"]")
	protected List<WebElement> AddToCartlist;
	@FindBy(css = " form > button > span")
	protected List<WebElement> addToCartPage2;
	@FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div > a")
	protected WebElement ShoppingCartlink;
	@FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
	protected WebElement itemSizeUnavailable;
	@FindBy(css = "[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
	protected WebElement addToCartMessage;
	protected static final String INVALID_COLOR = "none";

	public MenPage(WebDriver driver) {
		super(driver);

	}

	//Function that opens the men's top clothing menu
	public void pickItems(WebElement pageName, boolean isTOP, boolean isMen) {

		if (isMen) {
			waitingToElement(Menbtn);
			hoverTopMenu(Menbtn);


			if (isTOP) {
				waitingToElement(Topsbtn);
				moveto(Topsbtn);
			} else {
				waitingToElement(Bottombtn);
				moveto(Bottombtn);
			}

		} else {

			waitingToElement(Womenbtn);
			hoverTopMenu(Womenbtn);

			if (isTOP) {
				waitingToElement(WomenTopbtn);
				hoverTopMenu(WomenTopbtn);
			} else {
				waitingToElement(WomenBottomsbtn);
				hoverTopMenu(WomenBottomsbtn);
			}

		}

		clickSafe(pageName);

	}

	// A method that selects a size for each item on each page - enter the required
	// size and location in the item list.
	public String pickItemSize(String size, int i, boolean isTOP) {
		invalidItem(size);
		size = size.trim().replaceAll("\\s+", " ");

		if (isTOP == true) {
			switch (size.toUpperCase()) {
			case "XS":
				itemSize = "XS";

				existingSize(XSlist, i);
				break;
			case "S":
				itemSize = "S";
				existingSize(Slist, i);
				break;
			case "M":
				itemSize = "M";
				existingSize(Mlist, i);
				break;
			case "L":
				itemSize = "L";
				existingSize(Llist, i);
				break;
			case "XL":
				itemSize = "XL";
				existingSize(XLlist, i);
				break;
			default:
				System.out.println("This size is not listed you must choose again");
				isSize = false;
				return null;

			}
		} else {
			switch (size.toUpperCase()) {
			case "28":
				itemSize = "28";
				existingSize(list28, i);
				break;
			case "29":
				itemSize = "29";
				existingSize(list29, i);
				break;
			case "30":
				itemSize = "30";
				existingSize(list30, i);
				break;
			case "31":
				itemSize = "31";
				existingSize(list31, i);
				break;
			case "32":
				itemSize = "32";
				existingSize(list32, i);
				break;
			case "33":
				itemSize = "33";
				existingSize(list33, i);
				break;
			case "34":
				itemSize = "34";
				existingSize(list34, i);
				break;
			case "36":
				itemSize = "36";
				existingSize(list36, i);
				break;

			default:
				System.out.println("This size is not listed you must choose again");
				isSize = false;
				return null;

			}

		}

		System.out.println("You choose a " + itemSize + " sized item");
		return itemSize;

	}

	private void existingSize(List<WebElement> sizes, int i) {

		if (sizes.size() > i) {
			waitingToElement(sizes.get(i));
			click(sizes.get(i));

		} else {
			System.out.println("This size didnt exist for this item");
			isSize = false;
		}

	}

	// A method that chooses a color for each item from a list of three colors.
	public String switchColors(String item, String pageItem, String pickColor, String firstOptionColor,
			String secondOptionColor, String thirdOptionColor, WebElement firstColorBtn, WebElement secondColorBtn,
			WebElement thirdColorBtn) {

		if (item != null && item.equalsIgnoreCase(pageItem)) {

			if (pickColor == null || pickColor.trim().isEmpty() || pickColor.equalsIgnoreCase(INVALID_COLOR)) {
				System.out.println("You have selected an invalid or empty color.");
				iscolor = false;
				return itemcolor;
			}
			pickColor = pickColor.toLowerCase().trim();
			if (firstOptionColor.equals(pickColor) && firstColorBtn != null) {
				iscolor = true;
				itemcolor = firstOptionColor;
				System.out.println("You have selected an item in color " + itemcolor);
				waitingToElement(firstColorBtn);
				click(firstColorBtn);

			} else if (secondOptionColor.equals(pickColor) && secondColorBtn != null) {
				iscolor = true;
				itemcolor = secondOptionColor;
				System.out.println("You have selected an item in color " + itemcolor);
				waitingToElement(secondColorBtn);
				click(secondColorBtn);

			} else if (thirdOptionColor.equals(pickColor) && thirdColorBtn != null) {
				iscolor = true;
				itemcolor = thirdOptionColor;
				System.out.println("You have selected an item in color " + itemcolor);
				waitingToElement(thirdColorBtn);
				click(thirdColorBtn);

			} else {
				iscolor = false;
				System.out.println("You have selected an item in color that not exist on this list");
				return itemcolor;

			}

		}

		return itemcolor;

	}

	// A method where you purchase the item after selecting an item, size, and
	// color.

	public void addToCart(int i, List<WebElement> pageItemList, boolean isItem, boolean page2) {
		if (isSize == true && iscolor == true && isItem == true) {
			if (!page2) {
				sleep(500);
				waitingToElement(pageItemList.get(i));
				moveto(pageItemList.get(i));
				click(AddToCartlist.get(i));

			} else {
				sleep(500);
				waitingToElement(pageItemList.get(i));
				moveto(pageItemList.get(i));
				click(addToCartPage2.get(i));

			}

		}
	}

	// A method that navigates to the cart page after adding items.
	public void goToCartPage(boolean page2) {
		if (page2) {
			waitingToElement(ShoppingCartlink);
			click(ShoppingCartlink);
		} else {

			try {
				waitingToElement(ShoppingCartlink);
				click(ShoppingCartlink);
			} catch (TimeoutException | NoSuchElementException e) {
				waitingToElement(itemSizeUnavailable);
				if (itemSizeUnavailable.getText().equalsIgnoreCase("The requested qty is not available")) {
					System.err.println("This item is not available in this color and size, try other details.");
				}

			}
		}
	}

	// A method that checks if the item exists on this page.
	public boolean noSuchItem(boolean isItem) {

		if (!isItem) {
			System.out.println("This item is not on this list or not in this page");
			scrollDown();
			sleep(500);
			scrollDown();
			sleep(500);
			Assert.fail("Item not found — test stopped.");
			return false;
		}

		return true;

	}

	// A method that checks for invalid values ​​in items
	public void invalidItem(String PageItem) {
		if (PageItem == null || PageItem.isBlank()) {
			throw new IllegalArgumentException("PickedItem is null or blank — cannot continue.");

		}
	}

}
