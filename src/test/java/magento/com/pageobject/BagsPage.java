package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagsPage extends GearPage {

	@FindBy(css = "#ui-id-25")
	protected WebElement Bugsbtn;

	// Bags local Variables
	private boolean isBags = false;
	@FindBy(css = "#maincontent > div.columns > div.column.main > div:nth-child(5) > div.pages > ul > li.item.pages-item-next > a")
	private WebElement NextPagebtn;
	private String Item;

	public BagsPage(WebDriver driver) {
		super(driver);

	}

	public void BuyBags(String PickedItem) {
		waitingToElement(Gearbtn);
		moveto(Gearbtn);
		waitingToElement(Bugsbtn);

		clickSafe(Bugsbtn);

		invalidItem(PickedItem);
		Item = PickedItem.trim().replaceAll("\\s+", " ");

		for (int i = 0; i < itemlistForPage.size(); i++) {
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Item)) {
				waitingToElement((itemlistForPage.get(i)));
				moveto((itemlistForPage.get(i)));
				isBags = true;
				System.out.println("You choose the item : " + Item);
				AddGear(isBags, false, itemlistForPage, i);
				break;

			} else if (Item.equalsIgnoreCase("Joust Duffle Bag") || Item.equalsIgnoreCase("Strive Shoulder Pack")) {
				waitingToElement(NextPagebtn);
				click(NextPagebtn);
				waitingToElement((itemlistForPage.get(i)));
				moveto((itemlistForPage.get(i)));
				isBags = true;
				System.out.println("You choose the item : " + Item);
				AddGear(isBags, true, itemlistForPage, i);
				break;

			}

		}

		noSuchItem(isBags);

	}

	public String getItem() {
		return Item;
	}

}
