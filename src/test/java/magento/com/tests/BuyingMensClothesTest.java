package magento.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import magento.com.pageobject.Cartpage;
import magento.com.pageobject.CheckoutPage;
import magento.com.pageobject.MenHoodiesPage;
import magento.com.pageobject.MenJacketsPage;
import magento.com.pageobject.MenPantsPage;
import magento.com.pageobject.MenShortsPage;
import magento.com.pageobject.MenTanksPage;
import magento.com.pageobject.MenTeesPage;
import magento.com.pageobject.PaymentsPage;
import magento.com.pageobject.SuccessPage;

public class BuyingMensClothesTest extends BaseTest {

	@Test
	@Feature("Men's Clothing")
	@Story("Buy a Men's Jacket and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a man: a jacket, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_06_buyMenJacket() {
		MenJacketsPage mjp = new MenJacketsPage(driver);
		mjp.buyMenJackets("Hyperion Elements Jacket", "s", "red");
		takeScreenshot();
		mjp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), mjp.getJitem());
		Assert.assertEquals(cp.getItemColor(), mjp.getJcolor());
		Assert.assertEquals(cp.getItemSize(), mjp.getJsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "Omer", "Bracha", "Cnan", "IL", "Tel Aviv", "4458000", "0501234567",
				"Fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		Assert.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	@Feature("Men's Clothing")
	@Story("Buy a Men's Hoodie and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a man: a Hoodie, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_07_buyMenHoodies() {
		MenHoodiesPage mhp = new MenHoodiesPage(driver);
		mhp.buyMenHoodies("Frankie Sweatshirt", "XS", "GREEN");
		mhp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), mhp.getHitem());
		Assert.assertEquals(cp.getItemColor(), mhp.getHcolor());
		Assert.assertEquals(cp.getItemSize(), mhp.getHsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "Omer", "Bracha", "Cnan", "IL", "Tel Aviv", "4458000", "0501234567",
				"Fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		Assert.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");
	}

	@Test
	@Feature("Men's Clothing")
	@Story("Buy a Men's Tee and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a man: a Tee, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_08_buyMenTees() {
		MenTeesPage mtp = new MenTeesPage(driver);
		mtp.buyMenTees("Zoltan Gym Tee", "l", "green");
		mtp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), mtp.getTitem());
		Assert.assertEquals(cp.getItemColor(), mtp.getTcolor());
		Assert.assertEquals(cp.getItemSize(), mtp.getTsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "Omer", "Bracha", "Cnan", "IL", "Tel Aviv", "4458000", "0501234567",
				"Fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		Assert.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");
	}

	@Test
	@Feature("Men's Clothing")
	@Story("Buy a Men's Tank and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a man: a Tank, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_09_buyMenTanks() {
		MenTanksPage mtap = new MenTanksPage(driver);
		mtap.buyManTanks("Tristan Endurance Tank", "L", "white");
		mtap.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), mtap.getTaitem());
		Assert.assertEquals(cp.getItemColor(), mtap.getTacolor());
		Assert.assertEquals(cp.getItemSize(), mtap.getTasize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "Omer", "Bracha", "Cnan", "IL", "Tel Aviv", "4458000", "0501234567",
				"Fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		Assert.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	@Feature("Men's Clothing")
	@Story("Buy a Men's Pants and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a man: a Pants, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_10_buyMenPants() {
		MenPantsPage mpp = new MenPantsPage(driver);
		mpp.buyMenPants("Caesar Warm-Up Pant", "36", "purple");
		mpp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), mpp.getPitem());
		Assert.assertEquals(cp.getItemColor(), mpp.getPcolor());
		Assert.assertEquals(cp.getItemSize(), mpp.getPsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "Omer", "Bracha", "Cnan", "IL", "Tel Aviv", "4458000", "0501234567",
				"Fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		Assert.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	@Feature("Men's Clothing")
	@Story("Buy a Men's Shorts and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a man: a Shorts, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_11_buyMenShorts() {
		MenShortsPage msp = new MenShortsPage(driver);
		msp.buyMenShorts("Cobalt CoolTech™ Fitness Short", "34", "red");
		msp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), msp.getSitem());
		Assert.assertEquals(cp.getItemColor(), msp.getScolor());
		Assert.assertEquals(cp.getItemSize(), msp.getSsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "Omer", "Bracha", "Cnan", "IL", "Tel Aviv", "4458000", "0501234567",
				"Fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		Assert.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

}
