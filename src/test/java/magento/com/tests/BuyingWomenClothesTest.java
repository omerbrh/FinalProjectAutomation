package magento.com.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import magento.com.pageobject.Cartpage;
import magento.com.pageobject.CheckoutPage;
import magento.com.pageobject.PaymentsPage;
import magento.com.pageobject.SuccessPage;
import magento.com.pageobject.WomenBrasPage;
import magento.com.pageobject.WomenHoodiesPage;
import magento.com.pageobject.WomenJacketsPage;
import magento.com.pageobject.WomenPantsPage;
import magento.com.pageobject.WomenShortsPage;
import magento.com.pageobject.WomenTeesPage;

public class BuyingWomenClothesTest extends BaseTest {

	@Test
	public void tc_12_buyWomenJacket() {
		WomenJacketsPage wjp = new WomenJacketsPage(driver);
		wjp.buyWomenJackets("Inez Full Zip Jacket", "s", "red");
		wjp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), wjp.getWJitem());
		AssertJUnit.assertEquals(cp.getItemColor(), wjp.getWJcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), wjp.getWJsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_13_buyWomenHoodies() {
		WomenHoodiesPage whp = new WomenHoodiesPage(driver);
		whp.buyWomenHoodies("Phoebe Zipper Sweatshirt", "XS", "white");
		whp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), whp.getWHitem());
		AssertJUnit.assertEquals(cp.getItemColor(), whp.getWHcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), whp.getWHsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_14_buyWomenteess() {
		WomenTeesPage wtp = new WomenTeesPage(driver);
		wtp.buyWomenTees("Iris Workout Top", "l", "green");
		wtp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), wtp.getWtitem());
		AssertJUnit.assertEquals(cp.getItemColor(), wtp.getWtcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), wtp.getWtsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_15_buyWomenBras() {
		WomenBrasPage wbp = new WomenBrasPage(driver);
		wbp.buyWomenBras("Zoe Tank", "s", "green");
		wbp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), wbp.getBritem());
		AssertJUnit.assertEquals(cp.getItemColor(), wbp.getBrcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), wbp.getBrsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_16_buyWomenPants() {
		WomenPantsPage wpp = new WomenPantsPage(driver);
		wpp.buyWomenTees("Cora Parachute Pant", "29", "white");
		wpp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), wpp.getWpitem());
		AssertJUnit.assertEquals(cp.getItemColor(), wpp.getWpcolor());
		AssertJUnit.assertEquals(cp.getItemSize(), wpp.getWpsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

	@Test
	public void tc_17_buyWomenShorts() {
		WomenShortsPage wsp = new WomenShortsPage(driver);
		wsp.buyWomenShorts("Bess Yoga Short", "28", "yellow");
		wsp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		AssertJUnit.assertEquals(cp.getItemName(), wsp.getWSitem());
		AssertJUnit.assertEquals(cp.getItemColor(), wsp.getWScolor());
		AssertJUnit.assertEquals(cp.getItemSize(), wsp.getWSsize());
		CheckoutPage cop = new CheckoutPage(driver);
		cop.FillShippingInfo("omerbrh81@gmail.com", "O,er1234567!", "fixed");
		PaymentsPage pp = new PaymentsPage(driver);
		pp.clickPlaceOrder();
		SuccessPage sp = new SuccessPage(driver);
		AssertJUnit.assertEquals(sp.getThankYouText(),
				"We'll email you an order confirmation with details and tracking info.");

	}

}
