package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WatchesPage extends GearPage {

	@FindBy(css = "#ui-id-24")
	protected WebElement Watchesbtn;
	
	private boolean isWatch;
	
	private String Item;

	public WatchesPage(WebDriver driver) {
		super(driver);
		
	}

// Method for buying a specific watch from the website.
	public void BuyWatches(String PickedItem) {
		waitingToElement(Gearbtn);
		moveto(Gearbtn);
		 clickSafe(Watchesbtn);

		invalidItem(PickedItem);
		Item = PickedItem.trim().replaceAll("\\s+", " ");

		for (int i = 0; i < itemlistForPage.size(); i++) {
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Item)) {
				waitingToElement((itemlistForPage.get(i)));
				moveto((itemlistForPage.get(i)));
				isWatch = true;
				System.out.println("You choose the item : " + Item);
				AddGear(isWatch, false, itemlistForPage, i);
				break;

			}
			noSuchItem(isWatch);
			

		}
	}

	public String getItem() {
		return Item;
	}
	
	
}
