package magento.com.tests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
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
	public void tc_18_AddingSeveralItemsToCartTest() {
		BagsPage bp = new BagsPage(driver);
		bp.BuyBags("Overnight Duffle");
		EqiipmentPage ep = new EqiipmentPage(driver);
		ep.BuyEquipment("Affirm Water Bottle");
		WatchesPage wp = new WatchesPage(driver);
		wp.BuyWatches("Didi Sport Watch");
		MenuToolBar mtp = new MenuToolBar(driver);

		AssertJUnit.assertTrue(
				mtp.getCartItemNames().containsAll(mtp.itemsToList(bp.getItem(), ep.getItem(), wp.getItem())));

	}

	@Test
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
		AssertJUnit.assertEquals(cp.getFinalPriceSecond(), (cp.getQuantityToEdit() * cp.getFinalPriceFirst()));

	}

	@Test
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
		Cartpage cp = new Cartpage(driver);
		cp.deleteItemFromCart("Neve Studio Dance Jacket");
		AssertJUnit.assertTrue(cp.getFinalPriceFirst() > cp.getFinalPriceSecond());

	}

}
