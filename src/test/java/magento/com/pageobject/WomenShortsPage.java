package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenShortsPage extends WomenPage {

	// Tees local Variables
	private boolean isShorts = false;
	private String WScolor;
	private String WSsize;
	private String WSitem;
	private int position;

	@FindBy(css = "#ui-id-11")
	protected WebElement Wshortsbtn;
	protected static final String INVALID_Size = "none";

	public WomenShortsPage(WebDriver driver) {
		super(driver);

	}

	// A method for choosing a item from the list in the right color and size.
	public void buyWomenShorts(String shorts, String size, String color) {
		pickItems(Wshortsbtn, false, false);
		invalidItem(shorts);
		WSitem = shorts.trim().replaceAll("\\s+", " ");

		// Checking if the selected shorts is in the list.
		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(WSitem)) {
				isShorts = true;
				moveto(itemlistForPage.get(i));
				WSitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + WSitem + " from the items list ");

				position = i;

				break;
			}
		}

		// Choosing colors and size for each item separately.

		// 1.Choosing a shorts called:"Erika Running Short"

		WSsize = switchWomenShortsSize(WSitem, "Erika Running Short", size, "28", "29", "30", "31", "32", list28.get(0),
				list29.get(0), list30.get(0), list31.get(0), list32.get(0));
		WScolor = switchColors(WSitem, "Erika Running Short", color, "green", "purple", "red", Greenlist.get(0),
				Purplelist.get(0), Redlist.get(0));

		// 2.Choosing a shorts called:"Ina Compression Short""

		WSsize = switchWomenShortsSize(WSitem, "Ina Compression Short", size, "28", "29", INVALID_Size, INVALID_Size,
				INVALID_Size, list28.get(1), list29.get(1), null, null, null);
		WScolor = switchColors(WSitem, "Ina Compression Short", color, "blue", "orange", "red", Bluelist.get(0),
				Orangelist.get(0), Redlist.get(1));

		// 3.Choosing a shorts called:"Ana Running Short"

		WSsize = switchWomenShortsSize(WSitem, "Ana Running Short", size, "28", "29", INVALID_Size, INVALID_Size,
				INVALID_Size, list28.get(2), list29.get(2), null, null, null);
		WScolor = switchColors(WSitem, "Ana Running Short", color, "black", "orange", "white", Blacklist.get(0),
				Orangelist.get(1), Whitelist.get(0));

		// 4.Choosing a shorts called:"Mimi All-Purpose Short"

		WSsize = switchWomenShortsSize(WSitem, "Mimi All-Purpose Short", size, "28", "29", INVALID_Size, INVALID_Size,
				INVALID_Size, list28.get(3), list29.get(3), null, null, null);
		WScolor = switchColors(WSitem, "Mimi All-Purpose Short", color, "gray", "green", "white", Graylist.get(0),
				Greenlist.get(1), Whitelist.get(1));

		// 5.Choosing a shorts called:"Sybil Running Short"

		WSsize = switchWomenShortsSize(WSitem, "Erika Running Short", size, "28", "29", "30", "31", "32", list28.get(4),
				list29.get(4), list30.get(1), list31.get(1), list32.get(1));
		WScolor = switchColors(WSitem, "Sybil Running Short", color, "purple", INVALID_COLOR, INVALID_COLOR,
				Purplelist.get(1), null, null);

		// 6.Choosing a shorts called:"Echo Fit Compression Short"

		WSsize = switchWomenShortsSize(WSitem, "Echo Fit Compression Short", size, "28", "29", INVALID_Size,
				INVALID_Size, INVALID_Size, list28.get(5), list29.get(5), null, null, null);
		WScolor = switchColors(WSitem, "Echo Fit Compression Short", color, "black", "blue", "purple", Blacklist.get(1),
				Bluelist.get(1), Purplelist.get(2));

		// 7.Choosing a shorts called:"Angel Light Running Short"

		WSsize = switchWomenShortsSize(WSitem, "Angel Light Running Short", size, "28", "29", INVALID_Size,
				INVALID_Size, INVALID_Size, list28.get(6), list29.get(6), null, null, null);
		WScolor = switchColors(WSitem, "Angel Light Running Short", color, "gray", "orange", "purple", Graylist.get(1),
				Orangelist.get(2), Purplelist.get(3));

		// 8.Choosing a shorts called:"Bess Yoga Short"

		WSsize = switchWomenShortsSize(WSitem, "Bess Yoga Short", size, "28", "29", "30", "31", "32", list28.get(7),
				list29.get(7), list30.get(2), list31.get(2), list32.get(2));
		WScolor = switchColors(WSitem, "Bess Yoga Short", color, "blue", "purple", "yellow", Bluelist.get(2),
				Purplelist.get(4), Yellowlist.get(0));

		// 9.Choosing a shorts called:"Artemis Running Short"

		WSsize = switchWomenShortsSize(WSitem, "Artemis Running Short", size, "28", "29", "30", "31", "32",
				list28.get(8), list29.get(8), list30.get(3), list31.get(3), list32.get(3));
		WScolor = switchColors(WSitem, "Artemis Running Short", color, "black", "green", "orange", Blacklist.get(2),
				Greenlist.get(2), Orangelist.get(3));

		// 10.Choosing a shorts called:"Gwen Drawstring Bike Short"

		WSsize = switchWomenShortsSize(WSitem, "Gwen Drawstring Bike Short", size, "28", "29", "30", "31", "32",
				list28.get(9), list29.get(9), list30.get(4), list31.get(4), list32.get(4));
		WScolor = switchColors(WSitem, "Gwen Drawstring Bike Short", color, "blue", "gray", "orange", Bluelist.get(3),
				Graylist.get(2), Orangelist.get(4));

		// 11.Choosing a shorts called:"Maxima Drawstring Short"

		WSsize = switchWomenShortsSize(WSitem, "Maxima Drawstring Short", size, "28", "29", "30", "31", "32",
				list28.get(10), list29.get(10), list30.get(5), list31.get(5), list32.get(5));
		WScolor = switchColors(WSitem, "Maxima Drawstring Short", color, "gray", "orange", "yellow", Graylist.get(3),
				Orangelist.get(5), Yellowlist.get(1));

		// 12.Choosing a shorts called:"Fiona Fitness Short"

		WSsize = switchWomenShortsSize(WSitem, "Fiona Fitness Short", size, "28", "29", "30", "31", "32",
				list28.get(11), list29.get(11), list30.get(6), list31.get(6), list32.get(6));
		WScolor = switchColors(WSitem, "Fiona Fitness Short", color, "black", "green", "red", Blacklist.get(3),
				Greenlist.get(3), Redlist.get(2));

		noSuchItem(isShorts);
		addToCart(position, itemlistForPage, isShorts, false);

	}

	public String getWScolor() {
		return WScolor;
	}

	public String getWSsize() {
		return WSsize;
	}

	public String getWSitem() {
		return WSitem;
	}

}
