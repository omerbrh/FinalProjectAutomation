package magento.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import magento.com.pageobject.BagsPage;
import magento.com.pageobject.Cartpage;
import magento.com.pageobject.EqiipmentPage;
import magento.com.pageobject.MenHoodiesPage;
import magento.com.pageobject.MenJacketsPage;
import magento.com.pageobject.MenPantsPage;
import magento.com.pageobject.MenShortsPage;
import magento.com.pageobject.MenTanksPage;
import magento.com.pageobject.MenTeesPage;
import magento.com.pageobject.MenuToolBar;
import magento.com.pageobject.WatchesPage;
import magento.com.pageobject.WomenBrasPage;
import magento.com.pageobject.WomenHoodiesPage;
import magento.com.pageobject.WomenJacketsPage;
import magento.com.pageobject.WomenPantsPage;
import magento.com.pageobject.WomenShortsPage;
import magento.com.pageobject.WomenTeesPage;

public class AddToCartTest extends BaseTest {

	@Test
	@Feature("Additional items")
	@Story("Buying a bag, sports accessory, and watch and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects a bag, sports accessory, and watch and verifies that they were actually added to the shopping cart.")
	public void tc_18_AddingSeveralItemsToCartTest() throws InterruptedException {
		BagsPage bp = new BagsPage(driver);
		bp.BuyBags("Endeavor Daytrip Backpack");

		EqiipmentPage ep = new EqiipmentPage(driver);
		ep.BuyEquipment("Affirm Water Bottle");

		WatchesPage wp = new WatchesPage(driver);
		wp.BuyWatches("Aim Analog Watch");

		MenuToolBar mtp = new MenuToolBar(driver);
		Assert.assertTrue(mtp.isCartCorrect(bp.getItem(), ep.getItem(), wp.getItem()),
				"Cart items do not match the expected items, ignoring order");
	}

	@Test
	@Feature("Shopping cart testing")
	@Story("Selecting a number of men's clothing items in a variety of colors and sizes, adding them to the cart and changing the quantity")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects a number of men's clothing items in the requested sizes and colors, adds them to the cart, changes their quantity in the cart itself, and verifies that the quantity and price have changed to the required ones accordingly.")
	public void tc_19_EditingItemsNumbers() {
		MenJacketsPage mjp = new MenJacketsPage(driver);
		mjp.buyMenJackets("Jupiter All-Weather Trainer", "m", "blue");
		MenHoodiesPage mhp = new MenHoodiesPage(driver);
		mhp.buyMenHoodies("Frankie Sweatshirt", "l", "white");
		MenTeesPage mtp = new MenTeesPage(driver);
		mtp.buyMenTees("Aero Daily Fitness Tee", "m", "black");
		MenTanksPage mt = new MenTanksPage(driver);
		mt.buyManTanks("Helios Endurance Tank", "s", "blue");
		MenPantsPage mpp = new MenPantsPage(driver);
		mpp.buyMenPants("Geo Insulated Jogging Pant", "32", "red");
		MenShortsPage msp = new MenShortsPage(driver);
		msp.buyMenShorts("Apollo Running Short", "33", "black");
		msp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.editQtyOfAllItems("2");
		takeScreenshot();
		Assert.assertEquals(cp.getFinalPriceSecond(), cp.getQuantityToEdit() * cp.getFinalPriceFirst(),
				"Final price after edit is not calculated correctly");
	}

	@Test
	@Feature("Shopping cart testing")
	@Story("Selecting a number of women's clothing items in a variety of colors and sizes, adding them to the cart and changing the quantity")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects a number of women's clothing items in the requested sizes and colors, adds them to the cart, reduces their quantity in the cart itself, and verifies that the quantity and price have changed to the required ones accordingly.")
	public void tc_20_deletingItemsFromTheCart() {
		WomenJacketsPage wjp = new WomenJacketsPage(driver);
		wjp.buyWomenJackets("Neve Studio Dance Jacket", "s", "black");
		WomenHoodiesPage whp = new WomenHoodiesPage(driver);
		whp.buyWomenHoodies("Hera Pullover Hoodie", "l", "green");
		WomenTeesPage wtp = new WomenTeesPage(driver);
		wtp.buyWomenTees("Tiffany Fitness Tee", "m", "white");
		WomenBrasPage wbp = new WomenBrasPage(driver);
		wbp.buyWomenBras("Lucia Cross-Fit Bra", "s", "orange");
		WomenPantsPage wpp = new WomenPantsPage(driver);
		wpp.buyWomenTees("Carina Basic Capri", "28", "blue");
		WomenShortsPage wsp = new WomenShortsPage(driver);
		wsp.buyWomenShorts("Maxima Drawstring Short", "29", "yellow");
		wsp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.deleteItemFromCart("Neve Studio Dance Jacket");
		Assert.assertTrue(cp.getFinalPriceFirst() > cp.getFinalPriceSecond(),
				"Price after deletion is not lower than before");
	}

}
