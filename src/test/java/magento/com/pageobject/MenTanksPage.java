package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenTanksPage extends MenPage {
	// Tees buttons
	@FindBy(css = "#ui-id-17")
	protected WebElement Tanksbtn;

	// Tees local Variables
	private boolean isTank = false;
	private String Taitem;
	private String Tacolor;
	public String Tasize;
	private int position;

	protected static final String INVALID_COLOR = "none";

	public MenTanksPage(WebDriver driver) {
		super(driver);

	}

	public void buyManTanks(String tank, String size, String color) {
		pickItems(Tanksbtn, true, true);
		invalidItem(tank);
		Taitem = tank.trim().replaceAll("\\s+", " ");

		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Taitem)) {
				isTank = true;
				moveto(itemlistForPage.get(i));
				Taitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + Taitem + " from the tanks list ");

				// Size selection for each tank.
				Tasize = pickItemSize(size, i, true);
				position = i;

				break;
			}
		}
		// Choosing colors for each tanks separately.

		// 1.Choosing a tank called:"Cassius Sparring Tank"

		Tacolor = switchColors(Taitem, "Cassius Sparring Tank", color, "blue", INVALID_COLOR, INVALID_COLOR,
				Bluelist.get(0), null, null);

		// 2.Choosing a tank called:"Atlas Fitness Tank""

		Tacolor = switchColors(Taitem, "Atlas Fitness Tank", color, "blue", INVALID_COLOR, INVALID_COLOR,
				Bluelist.get(1), null, null);

		// 3.Choosing a tank called:"Tiberius Gym Tank"

		Tacolor = switchColors(Taitem, "Tiberius Gym Tank", color, "yellow", INVALID_COLOR, INVALID_COLOR,
				Yellowlist.get(0), null, null);

		// 4.Choosing a tank called:"Sinbad Fitness Tank"
		Tacolor = switchColors(Taitem, "Sinbad Fitness Tank", color, "blue", INVALID_COLOR, INVALID_COLOR,
				Bluelist.get(2), null, null);

		// 5.Choosing a tank called:Sparta Gym Tank"
		Tacolor = switchColors(Taitem, "Sparta Gym Tank", color, "green", INVALID_COLOR, INVALID_COLOR,
				Greenlist.get(0), null, null);

		// 6.Choosing a tank called:"Argus All-Weather Tank"

		Tacolor = switchColors(Taitem, "Argus All-Weather Tank", color, "gray", INVALID_COLOR, INVALID_COLOR,
				Graylist.get(0), null, null);

		// 7.Choosing a tank called:"Vulcan Weightlifting Tank"

		Tacolor = switchColors(Taitem, "Vulcan Weightlifting Tank", color, "black", INVALID_COLOR, INVALID_COLOR,
				Blacklist.get(0), null, null);

		// 8.Choosing a tank called:"Rocco Gym Tank"

		Tacolor = switchColors(Taitem, "Rocco Gym Tank", color, "blue", INVALID_COLOR, INVALID_COLOR, Bluelist.get(3),
				null, null);

		// 9.Choosing a tank called:"Helios Endurance Tank"

		Tacolor = switchColors(Taitem, "Helios Endurance Tank", color, "blue", INVALID_COLOR, INVALID_COLOR,
				Bluelist.get(4), null, null);

		// 10.Choosing a tank called:"Primo Endurance Tank"

		Tacolor = switchColors(Taitem, "Primo Endurance Tank", color, "blue", "red", "yellow", Bluelist.get(5),
				Redlist.get(0), Yellowlist.get(1));

		// 11.Choosing a tank called:"Tristan Endurance Tank"

		Tacolor = switchColors(Taitem, "Tristan Endurance Tank", color, "gary", "red", "white", Graylist.get(1),
				Redlist.get(1), Whitelist.get(0));

		// 12.Choosing a tank called:"Erikssen CoolTech™ Fitness Tank"
		Tacolor = switchColors(Taitem, "Erikssen CoolTech™ Fitness Tank", color, "gray", "orange", "red",
				Graylist.get(2), Orangelist.get(0), Redlist.get(2));

		noSuchItem(isTank);
		addToCart(position, itemlistForPage, isTank, false);
		

	}

	public String getTaitem() {
		return Taitem;
	}

	public String getTacolor() {
		return Tacolor;
	}

	public String getTasize() {
		return Tasize;
	}

}
