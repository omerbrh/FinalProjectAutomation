package magento.com.pageobject;

import org.openqa.selenium.WebDriver;

public class MenJacketsPage extends MenPage {

	// Jackets local Variables
	private boolean isJacket = false;
	private String Jcolor;
	private String Jsize;
	private String Jitem;
	private int position;

	public MenJacketsPage(WebDriver driver) {
		super(driver);

	}

	// A method for choosing a jacket from the list in the right color and size.
	public void buyMenJackets(String jacket, String size, String color) {
		pickItems(Jacketsbtn, true, true);
		invalidItem(jacket);
		Jitem = jacket.trim().replaceAll("\\s+", " ");

		// Checking if the selected jacket is in the list.
		for (int i = 0; i < itemlistForPage.size(); i++) {
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Jitem)) {
				isJacket = true;
				moveto(itemlistForPage.get(i));
				Jitem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				;
				System.out.println("You choose the item " + Jitem + " from the jackets list ");
				// Size selection for each jacket.
				Jsize = pickItemSize(size, i, true);
				position = i;
				break;
			}
		}
		// Choosing colors for each jacket separately.

		// 1.Choosing a jacket called:"Proteus Fitness Jackshirt"

		Jcolor = switchColors(Jitem, "Proteus Fitness Jackshirt", color, "black", "blue", "orange", Blacklist.get(0),
				Bluelist.get(0), Orangelist.get(0));

		// 2.Choosing a jacket called:"Montana Wind Jacket""

		Jcolor = switchColors(Jitem, "Montana Wind Jacket", color, "black", "green", "red", Blacklist.get(1),
				Greenlist.get(0), Redlist.get(0));

		// 3.Choosing a jacket called:"Jupiter All-Weather Trainer"

		Jcolor = switchColors(Jitem, "Jupiter All-Weather Trainer", color, "blue", "green", "purple", Bluelist.get(1),
				Greenlist.get(1), Purplelist.get(0));

		// 4.Choosing a jacket called:"Typhon Performance Fleece-lined Jacket"
		Jcolor = switchColors(Jitem, "Typhon Performance Fleece-lined Jacket", color, "black", "green", "red",
				Blacklist.get(2), Greenlist.get(2), Redlist.get(1));

		// 5.Choosing a jacket called:"Mars HeatTech™ Pullover"
		Jcolor = switchColors(Jitem, "Mars HeatTech™ Pullover", color, "black", "orange", "red", Blacklist.get(3),
				Orangelist.get(1), Redlist.get(2));

		// 6.Choosing a jacket called:"Taurus Elements Shell"

		Jcolor = switchColors(Jitem, "Taurus Elements Shell", color, "blue", "white", "yellow", Bluelist.get(2),
				Whitelist.get(0), Yellowlist.get(0));

		// 7.Choosing a jacket called:"Lando Gym Jacket"

		Jcolor = switchColors(Jitem, "Lando Gym Jacket", color, "blue", "gray", "green", Bluelist.get(3),
				Graylist.get(0), Greenlist.get(3));

		// 8.Choosing a jacket called:"Orion Two-Tone Fitted Jacket"

		Jcolor = switchColors(Jitem, "Orion Two-Tone Fitted Jacket", color, "black", "red", "yellow", Blacklist.get(4),
				Redlist.get(3), Yellowlist.get(1));

		// 9.Choosing a jacket called:"Kenobi Trail Jacket"

		Jcolor = switchColors(Jitem, "Kenobi Trail Jacket", color, "black", "blue", "purple", Blacklist.get(5),
				Bluelist.get(4), Purplelist.get(1));

		// 10.Choosing a jacket called:"Hyperion Elements Jacket"

		Jcolor = switchColors(Jitem, "Hyperion Elements Jacket", color, "green", "orange", "red", Greenlist.get(4),
				Orangelist.get(2), Redlist.get(4));

		// 11.Choosing a jacket called:"Beaumont Summit Kit"

		Jcolor = switchColors(Jitem, "Beaumont Summit Kit", color, "green", "orange", "red", Greenlist.get(4),
				Orangelist.get(2), Redlist.get(5));

		noSuchItem(isJacket);
		addToCart(position, itemlistForPage, isJacket, false);

	}

	public String getJitem() {
		return Jitem;
	}

	public String getJcolor() {
		return Jcolor;
	}

	public String getJsize() {
		return Jsize;
	}

}
