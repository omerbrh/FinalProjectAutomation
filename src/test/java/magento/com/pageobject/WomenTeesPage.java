package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenTeesPage extends MenPage {

	// Tees local Variables
	private boolean isTee = false;
	private String Wtcolor;
	private String Wtsize;
	private String Wtitem;
	private int position;

	@FindBy(css = "#ui-id-13")
	protected WebElement Wteestbtn;

	public WomenTeesPage(WebDriver driver) {
		super(driver);

	}

	// A method for choosing a item from the list in the right color and size.
	public void buyWomenTees(String tee, String size, String color) {
		pickItems(Wteestbtn, true, false);
		invalidItem(tee);
		Wtitem = tee.trim().replaceAll("\\s+", " ");

		// Checking if the selected item is in the list.
		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Wtitem)) {
				isTee = true;
				moveto(itemlistForPage.get(i));
				Wtitem = itemlistForPage.get(i).getText().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + Wtitem + " from the items list ");

				// Size selection for each item.
				Wtsize = pickItemSize(size, i, true);
				position = i;
				;
				break;
			}
		}

		// Choosing colors for each item separately.

		// 1.Choosing a tee called:"Desiree Fitness Tee"

		Wtcolor = switchColors(Wtitem, "Desiree Fitness Tee", color, "black", "orange", "yellow", Blacklist.get(0),
				Orangelist.get(0), Yellowlist.get(0));

		// 2.Choosing a tee called:"Gwyn Endurance Tee""

		Wtcolor = switchColors(Wtitem, "Gwyn Endurance Tee", color, "black", "green", "yellow", Blacklist.get(1),
				Greenlist.get(0), Yellowlist.get(1));

		// 3.Choosing a tee called:"Radiant Tee"
		Wtcolor = switchColors(Wtitem, "Radiant Tee", color, "blue", "orange", "purple", Bluelist.get(0),
				Orangelist.get(1), Purplelist.get(0));

		// 4.Choosing a tee called:"Diva Gym Tee"
		Wtcolor = switchColors(Wtitem, "Diva Gym Tee", color, "green", "orange", "yellow", Greenlist.get(1),
				Orangelist.get(2), Yellowlist.get(2));

		// 5.Choosing a tee called:"Karissa V-Neck Tee"
		Wtcolor = switchColors(Wtitem, "Karissa V-Neck Tee", color, "green", "red", "yellow", Greenlist.get(2),
				Redlist.get(0), Yellowlist.get(3));

		// 6.Choosing a tee called:"Tiffany Fitness Tee"

		Wtcolor = switchColors(Wtitem, "Tiffany Fitness Tee", color, "blue", "red", "white", Bluelist.get(1),
				Redlist.get(1), Whitelist.get(0));

		// 7.Choosing a tee called:"Minerva LumaTech™ V-Tee"

		Wtcolor = switchColors(Wtitem, "Minerva LumaTech™ V-Tee", color, "black", "blue", "red", Blacklist.get(2),
				Bluelist.get(2), Redlist.get(2));

		// 8.Choosing a tee called:"Juliana Short-Sleeve Tee"

		Wtcolor = switchColors(Wtitem, "Juliana Short-Sleeve Tee", color, "black", "white", "yellow", Blacklist.get(3),
				Whitelist.get(1), Yellowlist.get(4));

		// 9.Choosing a tee called:"Elisa EverCool™ Tee"

		Wtcolor = switchColors(Wtitem, "Elisa EverCool™ Tee", color, "gray", "purple", "red", Graylist.get(0),
				Purplelist.get(1), Redlist.get(3));

		// 10.Choosing a tee called:"Layla Tee"

		Wtcolor = switchColors(Wtitem, "Layla Tee", color, "blue", "green", "red", Bluelist.get(3), Greenlist.get(3),
				Redlist.get(3));

		// 11.Choosing a tee called:"Iris Workout Top"

		Wtcolor = switchColors(Wtitem, "Iris Workout Top", color, "blue", "green", "red", Bluelist.get(4),
				Greenlist.get(4), Redlist.get(4));

		// 12.Choosing a tee called:"Gabrielle Micro Sleeve Top"

		Wtcolor = switchColors(Wtitem, "Gabrielle Micro Sleeve Top", color, "blue", "green", "red", Bluelist.get(5),
				Greenlist.get(5), Redlist.get(5));
		noSuchItem(isTee);
		addToCart(position, itemlistForPage, isTee, false);

	}

	public String getWtcolor() {
		return Wtcolor;
	}

	public String getWtsize() {
		return Wtsize;
	}

	public String getWtitem() {
		return Wtitem;
	}

}
