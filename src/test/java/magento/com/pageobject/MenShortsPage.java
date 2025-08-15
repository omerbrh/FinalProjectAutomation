package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenShortsPage extends MenPage {

	@FindBy(css = "#ui-id-24")
	protected WebElement Shortsbtn;

	// Pants local Variables
	private boolean isShorts = false;
	private String Sitem;
	private String Scolor;
	public String Ssize;
	private int position;

	public MenShortsPage(WebDriver driver) {
		super(driver);

	}

	public void buyMenShorts(String item, String size, String color) {
		pickItems(Shortsbtn, false, true);
		invalidItem(item);
		Sitem = item.trim().replaceAll("\\s+", " ");

		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Sitem)) {
				isShorts = true;
				moveto(itemlistForPage.get(i));
				Sitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + Sitem + " from the shorts list ");

				// Size selection for each short.
				Ssize = pickItemSize(size, i, false);
				position = i;

				break;
			}
		}
		// Choosing colors for each shorts separately.

		// 1.Choosing a shorts called:"Pierce Gym Short"

		Scolor = switchColors(Sitem, "Pierce Gym Short", color, "black", "gray", "red", Blacklist.get(0),
				Graylist.get(0), Redlist.get(0));

		// 2.Choosing a shorts called:"Arcadio Gym Short"

		Scolor = switchColors(Sitem, "Arcadio Gym Short", color, "black", "blue", "red", Blacklist.get(1),
				Bluelist.get(0), Redlist.get(1));

		// 3.Choosing a shorts called:"Sol Active Short"

		Scolor = switchColors(Sitem, "Sol Active Short", color, "blue", "green", "purple", Bluelist.get(1),
				Greenlist.get(0), Purplelist.get(0));

		// 4.Choosing a shorts called:"Troy Yoga Short"
		Scolor = switchColors(Sitem, "Troy Yoga Short", color, "black", "blue", "green", Blacklist.get(2),
				Bluelist.get(2), Greenlist.get(1));

		// 5.Choosing a shorts called:"Orestes Fitness Short"
		Scolor = switchColors(Sitem, "Orestes Fitness Short", color, "black", "blue", "green", Blacklist.get(3),
				Bluelist.get(3), Greenlist.get(2));

		// 6.Choosing a shorts called:"Rapha Sports Short"

		Scolor = switchColors(Sitem, "Rapha Sports Short", color, "black", "blue", "purple", Blacklist.get(4),
				Bluelist.get(4), Purplelist.get(1));

		// 7.Choosing a shorts called:"Lono Yoga Short"

		Scolor = switchColors(Sitem, "Lono Yoga Short", color, "blue", "gray", "red", Bluelist.get(5), Graylist.get(1),
				Redlist.get(2));

		// 8.Choosing a shorts called:"Hawkeye Yoga Short"

		Scolor = switchColors(Sitem, "Hawkeye Yoga Short", color, "black", "blue", "gray", Blacklist.get(5),
				Bluelist.get(6), Redlist.get(2));

		// 9.Choosing a shorts called:"Torque Power Short"

		Scolor = switchColors(Sitem, "Torque Power Short", color, "gray", "purple", "yellow", Graylist.get(2),
				Purplelist.get(2), Yellowlist.get(0));

		// 10.Choosing a shorts called:"Meteor Workout Short"

		Scolor = switchColors(Sitem, "Meteor Workout Short", color, "black", "blue", "green", Blacklist.get(6),
				Bluelist.get(7), Greenlist.get(3));

		// 11.Choosing a shorts called:"Apollo Running Short"

		Scolor = switchColors(Sitem, "Apollo Running Short", color, "black", INVALID_COLOR, INVALID_COLOR,
				Blacklist.get(7), null, null);

		// 12.Choosing a shorts called:"Cobalt CoolTech™ Fitness Short"

		Scolor = switchColors(Sitem, "Cobalt CoolTech™ Fitness Short", color, "black", "blue", "red", Blacklist.get(8),
				Bluelist.get(8), Redlist.get(3));

		noSuchItem(isShorts);
		addToCart(position, itemlistForPage, isShorts, false);
		

	}

	public String getSitem() {
		return Sitem;
	}

	public String getScolor() {
		return Scolor;
	}

	public String getSsize() {
		return Ssize;
	}

}
