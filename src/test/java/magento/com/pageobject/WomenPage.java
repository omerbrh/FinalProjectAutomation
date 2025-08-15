package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomenPage extends MenPage {

	protected String itemsize;
	protected static final String INVALID_Size = "none";

	public WomenPage(WebDriver driver) {
		super(driver);

	}

	// Method for choosing sizes for shorts.
	public String switchWomenShortsSize(String item, String pageItem, String pickSize, String firstOptionsize,
			String secondOptionSize, String thirdOptionSize, String fourthOptionSize, String fifthhOptionSize,
			WebElement firstSizerBtn, WebElement secondSizeBtn, WebElement thirdSizeBtn, WebElement fourthSizeBtn,
			WebElement fifthSizeBtn) {

		if (item != null && item.equalsIgnoreCase(pageItem)) {

			if (pickSize == null || pickSize.trim().isEmpty() || pickSize.equalsIgnoreCase(INVALID_Size)) {
				System.out.println("You have selected an invalid or empty size.");
				isSize = false;
				return itemsize;
			}
			pickSize = pickSize.toLowerCase().trim();
			if (firstOptionsize.equals(pickSize) && firstSizerBtn != null) {
				isSize = true;
				itemsize = firstOptionsize;
				waitingToElement(firstSizerBtn);
				clickSafe(firstSizerBtn);
				System.out.println("You have selected an item in size " + itemsize);

			} else if (secondOptionSize.equals(pickSize) && secondSizeBtn != null) {
				isSize = true;
				itemsize = secondOptionSize;
				waitingToElement(secondSizeBtn);
				clickSafe(secondSizeBtn);
				System.out.println("You have selected an item in size " + itemsize);

			} else if (thirdOptionSize.equals(pickSize) && thirdSizeBtn != null) {
				isSize = true;
				itemsize = thirdOptionSize;
				waitingToElement(thirdSizeBtn);
				clickSafe(thirdSizeBtn);
				System.out.println("You have selected an item in size " + itemsize);

			} else if (fourthOptionSize.equals(pickSize) && fourthSizeBtn != null) {
				isSize = true;
				itemsize = fourthOptionSize;
				waitingToElement(fourthSizeBtn);
				clickSafe(fourthSizeBtn);
				System.out.println("You have selected an item in size " + itemsize);

			} else if (fifthhOptionSize.equals(pickSize) && fifthSizeBtn != null) {
				isSize = true;
				itemsize = fifthhOptionSize;
				waitingToElement(fifthSizeBtn);
				clickSafe(fifthSizeBtn);
				System.out.println("You have selected an item in size " + itemsize);

			} else {
				isSize = false;
				System.out.println("You have selected an item in size that not exist on this list");
				return itemsize;

			}

		}

		return itemsize;

	}

}
