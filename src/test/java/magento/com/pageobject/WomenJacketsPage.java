package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenJacketsPage extends MenPage {

	// Jackets local Variables
	private boolean isJacket = false;
	private String WJcolor;
	private String WJsize;
	private String WJitem;
	private int position;

	@FindBy(css = "#ui-id-11")
	protected WebElement Wjacketbtn;

	public WomenJacketsPage(WebDriver driver) {
		super(driver);

	}

	// A method for choosing a jacket from the list in the right color and size.
	public void buyWomenJackets(String jacket, String size, String color) {
		pickItems(Wjacketbtn, true, false);
		invalidItem(jacket);
		WJitem = jacket.trim().replaceAll("\\s+", " ");

		// Checking if the selected jacket is in the list.
		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(WJitem)) {
				isJacket = true;
				moveto(itemlistForPage.get(i));
				WJitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + WJitem + " from the items list ");

				// Size selection for each jacket.
				WJsize = pickItemSize(size, i, true);
				position = i;

				break;
			}
		}

		// Choosing colors for each jacket separately.

		// 1.Choosing a jacket called:"Olivia 1/4 Zip Light Jacket"

		WJcolor = switchColors(WJitem, "Olivia 1/4 Zip Light Jacket", color, "black", "blue", "purple",
				Blacklist.get(0), Bluelist.get(0), Purplelist.get(0));

		// 2.Choosing a jacket called:"Juno Jacket""

		WJcolor = switchColors(WJitem, "Juno Jacket", color, "blue", "green", "purple", Bluelist.get(1),
				Greenlist.get(0), Purplelist.get(1));

		// 3. Choosing a jacket called:"Neve Studio Dance Jacket"

		WJcolor = switchColors(WJitem, "Neve Studio Dance Jacket", color, "black", "blue", "orange", Blacklist.get(1),
				Bluelist.get(2), Orangelist.get(0));

		// 4.Choosing a jacket called:"Nadia Elements Shell"
		WJcolor = switchColors(WJitem, "Nadia Elements Shell", color, "black", "orange", "yellow", Blacklist.get(2),
				Orangelist.get(1), Yellowlist.get(0));

		// 5.Choosing a jacket called:"Jade Yoga Jacket"
		WJcolor = switchColors(WJitem, "Jade Yoga Jacket", color, "blue", "gray", "green", Bluelist.get(3),
				Graylist.get(0), Greenlist.get(1));

		// 6.Choosing a jacket called:"Adrienne Trek Jacket"

		WJcolor = switchColors(WJitem, "Adrienne Trek Jacket", color, "gray", "orange", "purple", Graylist.get(1),
				Orangelist.get(2), Purplelist.get(2));

		// 7.Choosing a jacket called:"Inez Full Zip Jacket"

		WJcolor = switchColors(WJitem, "Inez Full Zip Jacket", color, "orange", "purple", "red", Orangelist.get(3),
				Purplelist.get(3), Redlist.get(0));

		// 8.Choosing a jacket called:"Riona Full Zip Jackett"

		WJcolor = switchColors(WJitem, "Riona Full Zip Jacket", color, "brwon", "green", "red", Brownlist.get(0),
				Greenlist.get(2), Redlist.get(1));

		// 9.Choosing a jacket called:"Ingrid Running Jacket"

		WJcolor = switchColors(WJitem, "Ingrid Running Jacket", color, "orange", "red", "white", Orangelist.get(4),
				Redlist.get(2), Whitelist.get(0));

		// 10.Choosing a jacket called:"Augusta Pullover Jacket"

		WJcolor = switchColors(WJitem, "Augusta Pullover Jacket", color, "blue", "orange", "red", Bluelist.get(3),
				Orangelist.get(5), Redlist.get(4));

		// 11.Choosing a jacket called:"Josie Yoga Jacket"

		WJcolor = switchColors(WJitem, "Josie Yoga Jacket", color, "black", "blue", "gary", Blacklist.get(3),
				Bluelist.get(4), Graylist.get(2));

		// 12.Choosing a jacket called:"Stellar Solar Jacket"

		WJcolor = switchColors(WJitem, "Stellar Solar Jacket", color, "blue", "red", "yellow", Bluelist.get(5),
				Bluelist.get(5), Graylist.get(1));

		noSuchItem(isJacket);
		addToCart(position, itemlistForPage, isJacket, false);

	}

	public String getWJcolor() {
		return WJcolor;
	}

	public String getWJitem() {
		return WJitem;
	}

	public String getWJsize() {
		return WJsize;
	}

}
