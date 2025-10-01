package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenTeesPage extends MenPage {

	// Tees buttons
	@FindBy(css = "#ui-id-16")
	protected WebElement Teesbtn;

	// Tees local Variables
	private boolean isTee = false;
	private String Titem;
	private String Tcolor;
	public String Tsize;
	private int position;

	public MenTeesPage(WebDriver driver) {
		super(driver);

	}

	public void buyMenTees(String tee, String size, String color) {
		pickItems(Teesbtn, true, true);
		invalidItem(tee);
		Titem = tee.trim().replaceAll("\\s+", " ");

		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Titem)) {
				isTee = true;
				moveto(itemlistForPage.get(i));
				Titem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + Titem + " from the tees list ");

				// Size selection for each tee.
				Tsize = pickItemSize(size, i, true);
				position = i;
				break;
			}
		}
		// Choosing colors for each tees separately.

		// 1.Choosing a tee called:"Strike Endurance Tee"

		Tcolor = switchColors(Titem, "Strike Endurance Tee", color, "black", "blue", "red", Blacklist.get(0),
				Bluelist.get(0), Redlist.get(0));

		// 2.Choosing a tee called:"Deion Long-Sleeve EverCool™ Tee""

		Tcolor = switchColors(Titem, "Deion Long-Sleeve EverCool™ Tee", color, "black", "green", "white",
				Blacklist.get(1), Greenlist.get(0), Whitelist.get(0));

		// 3.Choosing a tee called:"Logan HeatTec® Tee"

		Tcolor = switchColors(Titem, "Logan HeatTec® Tee", color, "black", "blue", "red", Blacklist.get(2),
				Bluelist.get(1), Redlist.get(1));

		// 4.Choosing a tee called:"Ryker LumaTech™ Tee (V-neck)"
		Tcolor = switchColors(Titem, "Typhon Performance Fleece-lined Jacket", color, "black", "blue", "gray",
				Blacklist.get(3), Bluelist.get(2), Graylist.get(0));

		// 5.Choosing a tee called:"Aero Daily Fitness Tee"
		Tcolor = switchColors(Titem, "Aero Daily Fitness Tee", color, "black", "brown", "yellow", Blacklist.get(4),
				Brownlist.get(0), Yellowlist.get(0));

		// 6.Choosing a tee called:"Zoltan Gym Tee"

		Tcolor = switchColors(Titem, "Zoltan Gym Tee", color, "blue", "green", "yellow", Bluelist.get(3),
				Greenlist.get(1), Yellowlist.get(1));

		// 7.Choosing a tee called:"Balboa Persistence Tee"

		Tcolor = switchColors(Titem, "Balboa Persistence Tee", color, "gray", "green", "orange", Graylist.get(1),
				Greenlist.get(2), Orangelist.get(0));

		// 8.Choosing a tee called:"Atomic Endurance Running Tee (Crew-Neck)"

		Tcolor = switchColors(Titem, "Atomic Endurance Running Tee (Crew-Neck)", color, "black", "blue", "red",
				Blacklist.get(5), Bluelist.get(4), Redlist.get(2));

		// 9.Choosing a tee called:"Atomic Endurance Running Tee (V-neck)"

		Tcolor = switchColors(Titem, "Atomic Endurance Running Tee (V-neck)", color, "blue", "green", "yellow",
				Bluelist.get(5), Greenlist.get(3), Yellowlist.get(2));

		// 10.Choosing a tee called:"Ryker LumaTech™ Tee (Crew-neck)"

		Tcolor = switchColors(Titem, "Ryker LumaTech™ Tee (Crew-neck)", color, "black", "blue", "red", Blacklist.get(6),
				Bluelist.get(5), Redlist.get(3));

		// 11.Choosing a tee called:"Helios EverCool™ Tee"

		Tcolor = switchColors(Titem, "Helios EverCool™ Tee", color, "black", "blue", "purple", Blacklist.get(7),
				Bluelist.get(6), Purplelist.get(0));

		// 12.Choosing a tee called:"Gobi HeatTec® Tee"

		Tcolor = switchColors(Titem, "Gobi HeatTec® Tee", color, "black", "orange", "red", Blacklist.get(8),
				Orangelist.get(1), Redlist.get(4));

		noSuchItem(isTee);
		addToCart(position, itemlistForPage, isTee, false);
		

	}

	public String getTitem() {
		return Titem;
	}

	public String getTcolor() {
		return Tcolor;
	}

	public String getTsize() {
		return Tsize;
	}

}
