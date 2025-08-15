package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenHoodiesPage extends MenPage {

	// Hoodies local Variables
	private boolean isHoodie = false;
	private String WHcolor;
	private String WHsize;
	private String WHitem;
	private int position;

	@FindBy(css = "#ui-id-12")
	protected WebElement Whoodietbtn;

	public WomenHoodiesPage(WebDriver driver) {
		super(driver);

	}

	// A method for choosing a item from the list in the right color and size.
	public void buyWomenHoodies(String hoodie, String size, String color) {
		pickItems(Whoodietbtn, true, false);
		invalidItem(hoodie);
		WHitem = hoodie.trim().replaceAll("\\s+", " ");

		// Checking if the selected hoodie is in the list.
		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(WHitem)) {
				isHoodie = true;
				moveto(itemlistForPage.get(i));
				WHitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + WHitem + " from the items list ");

				// Size selection for each item.
				WHsize = pickItemSize(size, i, true);
				position = i;
				break;
			}
		}

		// Choosing colors for each item separately.

		// 1.Choosing a hoodie called:"Circe Hooded Ice Fleece"

		WHcolor = switchColors(WHitem, "Circe Hooded Ice Fleece", color, "gray", "green", "purple", Graylist.get(0),
				Greenlist.get(0), Purplelist.get(0));

		// 2.Choosing a hoodie called:"Eos V-Neck Hoodie""

		WHcolor = switchColors(WHitem, "Eos V-Neck Hoodie", color, "blue", "green", "orange", Bluelist.get(1),
				Greenlist.get(1), Orangelist.get(0));

		// 3. Choosing a hoodie called:"Helena Hooded Fleece"

		WHcolor = switchColors(WHitem, "Helena Hooded Fleece", color, "blue", "gray", "yellow", Bluelist.get(1),
				Graylist.get(1), Yellowlist.get(0));

		// 4.Choosing a hoodie called:"Ariel Roll Sleeve Sweatshirt"
		WHcolor = switchColors(WHitem, "Ariel Roll Sleeve Sweatshirt", color, "green", "purple", "red",
				Greenlist.get(2), Purplelist.get(1), Redlist.get(0));

		// 5.Choosing a hoodie called:"Cassia Funnel Sweatshirt"
		WHcolor = switchColors(WHitem, "Cassia Funnel Sweatshirt", color, "orange", "purple", "white",
				Orangelist.get(1), Purplelist.get(2), Whitelist.get(0));

		// 6.Choosing a hoodie called:"Phoebe Zipper Sweatshirt"

		WHcolor = switchColors(WHitem, "Phoebe Zipper Sweatshirt", color, "gray", "purple", "white", Graylist.get(2),
				Purplelist.get(3), Whitelist.get(1));

		// 7.Choosing a hoodie called:"Daphne Full-Zip Hoodiet"

		WHcolor = switchColors(WHitem, "Inez Full Zip Jacket", color, "purple", INVALID_COLOR, INVALID_COLOR,
				Purplelist.get(4), null, null);

		// 8.Choosing a hoodie called:"Selene Yoga Hoodie"

		WHcolor = switchColors(WHitem, "Selene Yoga Hoodie", color, "orange", "purple", "white", Orangelist.get(1),
				Purplelist.get(5), Whitelist.get(2));

		// 9.Choosing a hoodie called:"Miko Pullover Hoodie"

		WHcolor = switchColors(WHitem, "Miko Pullover Hoodie", color, "blue", "orange", "purple", Bluelist.get(2),
				Orangelist.get(3), Purplelist.get(6));

		// 10.Choosing a hoodie called:"Autumn Pullie"

		WHcolor = switchColors(WHitem, "Autumn Pullie", color, "green", "purple", "red", Greenlist.get(3),
				Purplelist.get(7), Redlist.get(1));

		// 11.Choosing a hoodie called:"Hera Pullover Hoodie"

		WHcolor = switchColors(WHitem, "Hera Pullover Hoodie", color, "blue", "green", "orange", Bluelist.get(3),
				Greenlist.get(4), Orangelist.get(4));

		// 12.Choosing a hoodie called:"Mona Pullover Hoodlie"

		WHcolor = switchColors(WHitem, "Mona Pullover Hoodlie", color, "green", "orange", "purple", Greenlist.get(5),
				Orangelist.get(5), Purplelist.get(8));

		noSuchItem(isHoodie);
		addToCart(position, itemlistForPage, isHoodie, false);

	}

	public String getWHcolor() {
		return WHcolor;
	}

	public String getWHitem() {
		return WHitem;
	}

	public String getWHsize() {
		return WHsize;
	}

}
