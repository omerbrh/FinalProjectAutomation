package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenPantsPage extends MenPage {
	@FindBy(css = "#ui-id-19")
	protected WebElement Pantsbtn;

	// Pants local Variables
	private boolean isPants = false;
	private String Pitem;
	private String Pcolor;
	public String Psize;
	private int position;

	public MenPantsPage(WebDriver driver) {
		super(driver);

	}

	public void buyMenPants(String pants, String size, String color) {
		pickItems(Pantsbtn, false, true);
		invalidItem(pants);
		Pitem = pants.trim().replaceAll("\\s+", " ");

		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Pitem)) {
				isPants = true;
				moveto(itemlistForPage.get(i));
				Pitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");

				System.out.println("You choose the item " + Pitem + " from the pants list ");

				// Size selection for each pants.
				Psize = pickItemSize(size, i, false);
				position = i;
				break;
			}
		}
		// Choosing colors for each pants separately.

		// 1.Choosing a pants called:"Cronus Yoga Pant"

		Pcolor = switchColors(Pitem, "Cronus Yoga Pant", color, "black", "blue", "red", Blacklist.get(0),
				Bluelist.get(0), Redlist.get(0));

		// 2.Choosing a pants called:"Aether Gym Pant"

		Pcolor = switchColors(Pitem, "Aether Gym Pant", color, "blue", "brown", "green", Bluelist.get(1),
				Brownlist.get(0), Greenlist.get(0));

		// 3.Choosing a pants called:"Orestes Yoga Pant"

		Pcolor = switchColors(Pitem, "Orestes Yoga Pant", color, "black", "blue", "green", Blacklist.get(1),
				Bluelist.get(2), Greenlist.get(1));

		// 4.Choosing a pants called:"Livingston All-Purpose Tight"
		Pcolor = switchColors(Pitem, "Livingston All-Purpose Tight", color, "black", "blue", "red", Blacklist.get(2),
				Bluelist.get(3), Redlist.get(1));

		// 5.Choosing a pants called:"Zeppelin Yoga Pant"
		Pcolor = switchColors(Pitem, "Zeppelin Yoga Pant", color, "blue", "green", "red", Bluelist.get(4),
				Greenlist.get(2), Redlist.get(2));

		// 6.Choosing a pants called:"Zoltan Gym Tee"

		Pcolor = switchColors(Pitem, "Thorpe Track Pant", color, "black", "blue", "purple", Blacklist.get(3),
				Bluelist.get(5), Purplelist.get(0));

		// 7.Choosing a pants called:"Mithra Warmup Pant"

		Pcolor = switchColors(Pitem, "Mithra Warmup Pant", color, "gray", "green", "orange", Graylist.get(0),
				Greenlist.get(3), Orangelist.get(0));

		// 8.Choosing a pants called:"Kratos Gym Pant)"

		Pcolor = switchColors(Pitem, "Kratos Gym Pant", color, "black", "blue", "red", Blacklist.get(4),
				Bluelist.get(6), Redlist.get(3));

		// 9.Choosing a pants called:"Supernova Sport Pant"

		Pcolor = switchColors(Pitem, "Supernova Sport Pant", color, "black", "gary", "green", Blacklist.get(5),
				Graylist.get(1), Greenlist.get(5));

		// 10.Choosing a pants called:"Geo Insulated Jogging Pant"

		Pcolor = switchColors(Pitem, "Geo Insulated Jogging Pant", color, "blue", "green", "red", Bluelist.get(7),
				Greenlist.get(6), Redlist.get(3));

		// 11.Choosing a pants called:"Helios EverCool™ Tee"

		Pcolor = switchColors(Pitem, "Viktor LumaTech™ Pant", color, "blue", "gray", "red", Bluelist.get(8),
				Graylist.get(2), Redlist.get(4));

		// 12.Choosing a pants called:"Caesar Warm-Up Pant"

		Pcolor = switchColors(Pitem, "Caesar Warm-Up Pant", color, "black", "gray", "purple", Blacklist.get(6),
				Graylist.get(3), Purplelist.get(1));

		noSuchItem(isPants);
		addToCart(position, itemlistForPage, isPants, false);
		

	}

	public String getPitem() {
		return Pitem;
	}

	public String getPcolor() {
		return Pcolor;
	}

	public String getPsize() {
		return Psize;
	}

}
