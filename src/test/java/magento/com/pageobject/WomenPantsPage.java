package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPantsPage extends MenPage {

	// Tees local Variables
	private boolean isPants = false;
	private String Wpcolor;
	private String Wpsize;
	private String Wpitem;
	private int position;

	@FindBy(css = "#ui-id-15")
	protected WebElement Wpantsbtn;

	public WomenPantsPage(WebDriver driver) {
		super(driver);

	}

	// A method for choosing a item from the list in the right color and size.
	public void buyWomenTees(String pants, String size, String color) {
		pickItems(Wpantsbtn, false, false);
		invalidItem(pants);
		Wpitem = pants.trim().replaceAll("\\s+", " ");

		// Checking if the selected item is in the list.
		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Wpitem)) {
				isPants = true;
				moveto(itemlistForPage.get(i));
				Wpitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + Wpitem + " from the items list ");

				// Size selection for each item.
				Wpsize = pickItemSize(size, i, false);
				position = i;

				break;
			}
		}

		// Choosing colors for each item separately.

		// 1.Choosing a pants called:"Desiree Fitness Tee"

		Wpcolor = switchColors(Wpitem, "Portia Capri", color, "blue", "green", "orange", Bluelist.get(0),
				Greenlist.get(0), Orangelist.get(0));

		// 2.Choosing a pants called:"Deirdre Relaxed-Fit Capri""

		Wpcolor = switchColors(Wpitem, "Deirdre Relaxed-Fit Capri", color, "blue", "gray", "green", Bluelist.get(1),
				Graylist.get(1), Greenlist.get(1));

		// 3.Choosing a pants called:"Sylvia Capri"
		Wpcolor = switchColors(Wpitem, "Sylvia Capri", color, "blue", "green", "red", Bluelist.get(2), Greenlist.get(2),
				Redlist.get(0));

		// 4.Choosing a pants called:"Daria Bikram Pant"
		Wpcolor = switchColors(Wpitem, "Daria Bikram Pant", color, "black", "gray", "white", Blacklist.get(0),
				Graylist.get(1), Whitelist.get(0));

		// 5.Choosing a pants called:"Carina Basic Capri"
		Wpcolor = switchColors(Wpitem, "Carina Basic Capri", color, "black", "blue", "purple", Blacklist.get(1),
				Bluelist.get(3), Purplelist.get(0));

		// 6.Choosing a pants called:"Bardot Capri"

		Wpcolor = switchColors(Wpitem, "Bardot Capri", color, "black", "green", "red", Blacklist.get(2),
				Greenlist.get(3), Redlist.get(1));

		// 7.Choosing a pants called:"Aeon Capri"

		Wpcolor = switchColors(Wpitem, "Aeon Capri", color, "black", "blue", "orange", Blacklist.get(3),
				Bluelist.get(4), Orangelist.get(1));

		// 8.Choosing a pants called:"Diana Tights"

		Wpcolor = switchColors(Wpitem, "Diana Tights", color, "black", "blue", "orange", Blacklist.get(4),
				Bluelist.get(5), Orangelist.get(2));

		// 9.Choosing a pants called:"Sahara Leggings"

		Wpcolor = switchColors(Wpitem, "Sahara Leggings", color, "blue", "gray", "red", Bluelist.get(6),
				Graylist.get(2), Redlist.get(2));

		// 10.Choosing a pants called:"Cora Parachute Pant"

		Wpcolor = switchColors(Wpitem, "Cora Parachute Pant", color, "black", "blue", "white", Blacklist.get(5),
				Bluelist.get(7), Whitelist.get(1));

		// 11.Choosing a pants called:"Ida Workout Parachute Pant"

		Wpcolor = switchColors(Wpitem, "Ida Workout Parachute Pant", color, "black", "blue", "purple", Blacklist.get(6),
				Bluelist.get(8), Purplelist.get(1));

		// 12.Choosing a pants called:"Emma Leggings"

		Wpcolor = switchColors(Wpitem, "Emma Leggings", color, "blue", "purple", "red", Bluelist.get(9),
				Purplelist.get(2), Redlist.get(3));

		noSuchItem(isPants);
		addToCart(position, itemlistForPage, isPants, false);
		

	}

	public String getWpcolor() {
		return Wpcolor;
	}

	public String getWpsize() {
		return Wpsize;
	}

	public String getWpitem() {
		return Wpitem;
	}

}
