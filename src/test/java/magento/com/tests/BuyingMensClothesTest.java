package magento.com.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
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
	public void tc_06_buyMenJacket() {
		MenJacketsPage mjp = new MenJacketsPage(driver);
		mjp.buyMenJackets("Hyperion Elements Jacket", "s", "red");
		mjp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), mjp.getJitem());
		AssertJUnit.assertEquals(cp.getItemColor(), mjp.getJcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), mjp.getJsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_07_buyMenHoodies() {
		MenHoodiesPage mhp = new MenHoodiesPage(driver);
		mhp.buyMenHoodies("Frankie Sweatshirt", "XS", "GREEN");
		mhp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), mhp.getHitem());
		AssertJUnit.assertEquals(cp.getItemColor(), mhp.getHcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), mhp.getHsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_08_buyMenTees() {
		MenTeesPage mtp = new MenTeesPage(driver);
		mtp.buyMenTees("Zoltan Gym Tee", "l", "green");
		mtp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), mtp.getTitem());
		AssertJUnit.assertEquals(cp.getItemColor(), mtp.getTcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), mtp.getTsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_09_buyMenTanks() {
		MenTanksPage mtap = new MenTanksPage(driver);
		mtap.buyManTanks("Tristan Endurance Tank", "L", "white");
		mtap.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), mtap.getTaitem());
		AssertJUnit.assertEquals(cp.getItemColor(), mtap.getTacolor());
		AssertJUnit.assertEquals(cp.getItemSize(), mtap.getTasize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_10_buyMenPants() {
		MenPantsPage mpp = new MenPantsPage(driver);
		mpp.buyMenPants("Caesar Warm-Up Pant", "36", "purple");
		mpp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), mpp.getPitem());
		AssertJUnit.assertEquals(cp.getItemColor(), mpp.getPcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), mpp.getPsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_11_buyMenShorts() {
		MenShortsPage msp = new MenShortsPage(driver);
		msp.buyMenShorts("Cobalt CoolTech™ Fitness Short", "34", "red");
		msp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), msp.getSitem());
		AssertJUnit.assertEquals(cp.getItemColor(), msp.getScolor());
		AssertJUnit.assertEquals(cp.getItemSize(), msp.getSsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

}
