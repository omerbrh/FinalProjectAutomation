package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenBrasPage extends MenPage {

	// Bras local Variables
	private boolean isBra = false;
	private String Brcolor;
	private String Brsize;
	private String Britem;
	private int position;

	@FindBy(css = "#ui-id-14")
	protected WebElement Brastbtn;

	// Page 2 elements

	@FindBy(css = "div:nth-child(5) > div.pages > ul > li:nth-child(2) > a > span:nth-child(2)")
	protected WebElement Page2;

	public WomenBrasPage(WebDriver driver) {
		super(driver);
	}

	public void buyWomenBras(String bra, String size, String color) {
		pickItems(Brastbtn, true, false);
		invalidItem(bra);
		Britem = bra.trim().replaceAll("\\s+", " ");

		// Checking if the selected item is in the list.
		for (int i = 0; i < itemlistForPage.size(); i++) {

			// This bras is on page 2 .

			if (Britem.equalsIgnoreCase("Erica Evercool Sports Bra") || Britem.equalsIgnoreCase("Electra Bra Top")) {
				isBra = true;
				waitingToElement(Page2);
				click(Page2);
				Britem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose " + Britem + " from the items list on the second page");
				Brsize = pickItemSize(size, i, true);
				// 1.Choosing a bra called:"Erica Evercool Sports Bra"
				Brcolor = switchColors(Britem, "Erica Evercool Sports Bra", color, "blue", "orange", "yellow",
						Bluelist.get(0), Orangelist.get(0), Yellowlist.get(0));

				// 2.Choosing a bra called:"Erica Evercool Sports Bra"
				Brcolor = switchColors(Britem, "Electra Bra Top", color, "black", "gray", "purple", Blacklist.get(0),
						Graylist.get(0), Purplelist.get(0));
				moveto(itemlistForPage.get(i));
				addToCart(position, itemlistForPage, isBra, true);
				goToCartPage(true);

				break;

			}
			waitingToElement(itemlistForPage.get(i));
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Britem)) {
				isBra = true;
				moveto(itemlistForPage.get(i));
				Britem = itemlistForPage.get(i).getText().trim().replaceAll("\\s+", " ");
				System.out.println("You choose the item " + Britem + " from the items list ");

				// Size selection for each item.
				Brsize = pickItemSize(size, i, true);
				position = i;

				break;
			}
		}

		// Choosing colors for each item separately.

		// 1.Choosing a bra called:"Breathe-Easy Tank"

		Brcolor = switchColors(Britem, "Breathe-Easy Tank", color, "purple", "white", "yellow", Purplelist.get(0),
				Whitelist.get(0), Yellowlist.get(0));

		// 2.Choosing a hoodie called:"Antonia Racer Tank""

		Brcolor = switchColors(Britem, "Antonia Racer Tank", color, "black", "purple", "yellow", Blacklist.get(0),
				Purplelist.get(1), Yellowlist.get(1));

		// 3. Choosing a bra called:"Maya Tunic"

		Brcolor = switchColors(Britem, "Maya Tunic", color, "green", "white", "yellow", Greenlist.get(0),
				Whitelist.get(1), Yellowlist.get(2));

		// 4.Choosing a bra called:"Chloe Compete Tank"
		Brcolor = switchColors(Britem, "Chloe Compete Tank", color, "blue", "red", "yellow", Bluelist.get(0),
				Redlist.get(0), Yellowlist.get(3));

		// 5.Choosing a bra called:"Leah Yoga Top"
		Brcolor = switchColors(Britem, "Leah Yoga Top", color, "orange", "purple", "white", Orangelist.get(0),
				Purplelist.get(2), Whitelist.get(2));

		// 6.Choosing a bra called:"Nona Fitness Tank"

		Brcolor = switchColors(Britem, "Nona Fitness Tank", color, "blue", "purple", "red", Bluelist.get(1),
				Purplelist.get(3), Redlist.get(1));

		// 7.Choosing a bra called:"Nora Practice Tank"

		Brcolor = switchColors(Britem, "Nora Practice Tank", color, "orange", "purple", "red", Orangelist.get(1),
				Purplelist.get(4), Redlist.get(2));

		// 8.Choosing a bra called:"Zoe Tank"

		Brcolor = switchColors(Britem, "Zoe Tank", color, "green", "orange", "yellow", Greenlist.get(1),
				Orangelist.get(2), Yellowlist.get(4));

		// 9.Choosing a bra called:"Bella Tank"

		Brcolor = switchColors(Britem, "Bella Tank", color, "black", "blue", "orange", Blacklist.get(1),
				Bluelist.get(2), Orangelist.get(3));

		// 10.Choosing a bra called:"Lucia Cross-Fit Bra"

		Brcolor = switchColors(Britem, "Lucia Cross-Fit Bra", color, "black", "orange", "purple", Blacklist.get(2),
				Orangelist.get(4), Purplelist.get(5));

		// 11.Choosing a bra called:"Prima Compete Bra Top"

		Brcolor = switchColors(Britem, "Prima Compete Bra Top", color, "blue", "purple", "yellow", Bluelist.get(3),
				Purplelist.get(6), Yellowlist.get(5));

		// 12.Choosing a bra called:"Celeste Sports Bra"

		Brcolor = switchColors(Britem, "Celeste Sports Bra", color, "green", "red", "yellow", Greenlist.get(2),
				Redlist.get(3), Yellowlist.get(6));

		noSuchItem(isBra);
		addToCart(position, itemlistForPage, isBra, false);

	}

	public String getBrcolor() {
		return Brcolor;
	}

	public String getBrsize() {
		return Brsize;
	}

	public String getBritem() {
		return Britem;
	}

}
