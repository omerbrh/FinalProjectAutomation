package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenHoodiesPage extends MenJacketsPage {

	// Hoodies buttons
	@FindBy(css = "#ui-id-15")
	protected WebElement Hoodiesbtn;

	// Hoodies local Variables
	private boolean isHoodie = false;
	private String Hitem;
	private String Hcolor;
	public String Hsize;
	private int position;

	// other buttons

	@FindBy(css = "#maincontent > div.columns > div.column.main > div:nth-child(5) > div.pages > ul > li:nth-child(2) > a > span:nth-child(2)")
	protected WebElement pageTwobtn;

	public MenHoodiesPage(WebDriver driver) {
		super(driver);

	}

	// A method for choosing a Hoodie from the list in the right color and size.
	public void buyMenHoodies(String hoddie, String size, String color) {
		pickItems(Hoodiesbtn, true, true);
		invalidItem(hoddie);
		Hitem=hoddie.trim().replaceAll("\\s+", " ");
		
		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));

			// Checking if the selected hoddie is in the list.

			// This hoodie is on page 2 .
			// Choosing a jacket called:"Chaz Kangeroo Hoodie""
			if (Hitem.equalsIgnoreCase("Chaz Kangeroo Hoodie")) {
				isHoodie = true;
				waitingToElement(pageTwobtn);
				click(pageTwobtn);
				Hitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose " + Hitem + " from the hoodies list on the second page");
				Hsize = pickItemSize(size, i, true);
				Hcolor = switchColors(Hitem, "Chaz Kangeroo Hoodie", color, "black", "gray", "orange", Blacklist.get(0),
						Graylist.get(0), Orangelist.get(0));
				moveto(itemlistForPage.get(0));
				addToCart(i, itemlistForPage, isHoodie, true);
				waitingToElement(ShoppingCartlink);
				click(ShoppingCartlink);
				break;

			}

			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Hitem.trim())) {
				isHoodie = true;
				moveto(itemlistForPage.get(i));
				Hitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose " + Hitem + " from the hoodies list");

				// Size selection for each hoodie
				Hsize = pickItemSize(size, i, true);
				position = i;
				break;

			}

		}

		// Choosing colors for each hoodie separately.

		// Choosing a jacket called:"Marco Lightweight Active Hoodie"

		if (!Hitem.equalsIgnoreCase("Chaz Kangeroo Hoodie")) {

			Hcolor = switchColors(Hitem, "Marco Lightweight Active Hoodie", color, "blue", "green", "lavender",
					Bluelist.get(0), Greenlist.get(0), Lavenderlist.get(0));

			// 1. Choosing a hoodie called:"Ajax Full-Zip Sweatshirt"

			Hcolor = switchColors(Hitem, "Ajax Full-Zip Sweatshirt", color, "blue", "green", "red", Bluelist.get(1),
					Greenlist.get(1), Redlist.get(0));

			// 2. Choosing a hoddie called:"Grayson Crewneck Sweatshirt"
			Hcolor = switchColors(Hitem, "Grayson Crewneck Sweatshirt", color, "orange", "red", "white",
					Orangelist.get(0), Redlist.get(1), Whitelist.get(0));

			// 3. Choosing a hoddie called:"Mach Street Sweatshirt"

			Hcolor = switchColors(Hitem, "Mach Street Sweatshirt", color, "black", "blue", "red", Blacklist.get(0),
					Bluelist.get(2), Redlist.get(2));

			// 4.Choosing a hoddie called:"Abominable Hoodie"
			switchColors(Hitem, "Abominable Hoodie", color, "blue", "green", "red", Bluelist.get(3), Greenlist.get(2),
					Redlist.get(3));

			// 5.Choosing a hoddie called:"Oslo Trek Hoodie"
			Hcolor = switchColors(Hitem, "Oslo Trek Hoodie", color, "brown", "purpel", "red", Brownlist.get(0),
					Purplelist.get(0), Redlist.get(4));

			// 6.Choosing a hoddie called:"Oslo Trek Hoodie"
			Hcolor = switchColors(Hitem, "Hero Hoodie", color, "black", "gray", "green", Blacklist.get(1),
					Graylist.get(0), Greenlist.get(3));

			// 7.Choosing a hoddie called:"Stark Fundamental Hoodie"
			Hcolor = switchColors(Hitem, "Stark Fundamental Hoodie", color, "black", "gray", "purpel", Blacklist.get(2),
					Bluelist.get(4), Purplelist.get(1));

			// 8.Choosing a hoddie called:"Hollister Backyard Sweatshirt"
			Hcolor = switchColors(Hitem, "Hollister Backyard Sweatshirt", color, "green", "red", "white",
					Greenlist.get(4), Redlist.get(5), Whitelist.get(1));

			// 9.Choosing a hoddie called:"Frankie Sweatshirt"
			Hcolor = switchColors(Hitem, "Frankie Sweatshirt", color, "green", "white", "yellow", Greenlist.get(5),
					Whitelist.get(2), Yellowlist.get(0));

			// 10.Choosing a hoddie called:"Bruno Compete Hoodie"
			Hcolor = switchColors(Hitem, "Bruno Compete Hoodie", color, "black", "blue", "green", Blacklist.get(3),
					Bluelist.get(5), Greenlist.get(6));

			// 11.Choosing a hoddie called:"Teton Pullover Hoodie"
			Hcolor = switchColors(Hitem, "Teton Pullover Hoodie", color, "black", "purpel", "red", Blacklist.get(4),
					Purplelist.get(2), Redlist.get(6));

			noSuchItem(isHoodie);
			addToCart(position, itemlistForPage, isHoodie, false);
			
		}

	}

	public String getHitem() {
		return Hitem;
	}

	public String getHsize() {
		return Hsize;
	}

	public String getHcolor() {
		return Hcolor;
	}

}
