package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EqiipmentPage extends GearPage {
	@FindBy(css = "#ui-id-23")
	protected WebElement equipmentbtn;
	@FindBy(css = "[class=\"fotorama__img\"]")
	protected WebElement ballImg;
	@FindBy(css = "#bundle-slide")
	private WebElement customAddToCart;
	@FindBy(css = "[name=\"super_group[33]\"]")
	private WebElement sixFootStrap;
	@FindBy(css = "[name=\"super_group[34]\"]")
	private WebElement eightFootStrap;
	@FindBy(css = "[name=\"super_group[35]\"]")
	private WebElement tenFootStrap;

	private boolean isEquipment = false;
	private String Item;

	public EqiipmentPage(WebDriver driver) {
		super(driver);

	}

	public void BuyEquipment(String PickedItem) {
		waitingToElement(Gearbtn);
		moveto(Gearbtn);
		clickSafe(equipmentbtn);

		invalidItem(PickedItem);
		Item = PickedItem.trim().replaceAll("\\s+", " ");

		for (int i = 0; i < itemlistForPage.size(); i++) {
			if (itemlistForPage.get(i).getText().equalsIgnoreCase(Item)) {
				if (Item.equalsIgnoreCase("Sprite Yoga Companion Kit")) {
					waitingToElement((itemlistForPage.get(i)));
					moveto((itemlistForPage.get(i)));
					isEquipment = true;
					System.out.println("You choose the item: " + Item);
					click(AddToCartlist.get(i));
					addSpriteYoga();
					break;
				} else if (Item.equalsIgnoreCase("Set of Sprite Yoga Straps")) {
					waitingToElement((itemlistForPage.get(i)));
					moveto((itemlistForPage.get(i)));
					isEquipment = true;
					System.out.println("You choose the item: " + Item);
					click(AddToCartlist.get(i));
					addYogaStraps("10 foot");
					break;

				} else {
					waitingToElement((itemlistForPage.get(i)));
					moveto((itemlistForPage.get(i)));
					isEquipment = true;
					System.out.println("You choose the item: " + Item);
					AddGear(isEquipment, false, itemlistForPage, i);
					break;
				}
			}

		}
		noSuchItem(isEquipment);

	}

	private void addSpriteYoga() {
		int i = 0;
		waitingToElement(customAddToCart);
		click(customAddToCart);
		waitingToElement(AddToCartlist.get(i));
		click(AddToCartlist.get(i));
		waitingToElementDisappear(ballImg);
		;
		waitingToElement(ballImg);
		waitingToElement(addToCartMessage);
		System.out.println(addToCartMessage.getText() + "This item is out of stock");

	}

	private void addYogaStraps(String Straps) {
		int i = 0;
		if (Straps.equalsIgnoreCase("6 foot")) {
			System.out.println("You add one 6 foot strap");
			waitingToElement(sixFootStrap);
			fillText(sixFootStrap, "1");
		} else if (Straps.equalsIgnoreCase("8 foot")) {
			waitingToElement(eightFootStrap);
			System.out.println("You add one 8 foot strap");
			fillText(eightFootStrap, "1");
		} else if (Straps.equalsIgnoreCase("10 foot")) {
			waitingToElement(tenFootStrap);
			System.out.println("You add one 10 foot strap");
			fillText(tenFootStrap, "1");

		}
		waitingToElement(AddToCartlist.get(i));
		click(AddToCartlist.get(i));
		sleep(2000);
		System.out.println(addToCartMessage.getText());
	}

	public String getItem() {
		return Item;
	}

}
