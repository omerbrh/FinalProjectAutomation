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
	@Feature("Women's Clothing")
	@Story("Buy a Women's Jacket and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a woman: a jacket, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_12_buyWomenJacket() {
		WomenJacketsPage wjp = new WomenJacketsPage(driver);
		wjp.buyWomenJackets("Inez Full Zip Jacket", "s", "red");
		wjp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), wjp.getWJitem());
		Assert.assertEquals(cp.getItemColor(), wjp.getWJcolor());
		Assert.assertEquals(cp.getItemSize(), wjp.getWJsize());
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
	@Feature("Women's Clothing")
	@Story("Buy a Women's hoodie and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a woman: a hoodie, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_13_buyWomenHoodies() {
		WomenHoodiesPage whp = new WomenHoodiesPage(driver);
		whp.buyWomenHoodies("Phoebe Zipper Sweatshirt", "XS", "white");
		whp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), whp.getWHitem());
		Assert.assertEquals(cp.getItemColor(), whp.getWHcolor());
		Assert.assertEquals(cp.getItemSize(), whp.getWHsize());
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
	@Feature("Women's Clothing")
	@Story("Buy a Women's tee and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a woman: a tee, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_14_buyWomentees() {
		WomenTeesPage wtp = new WomenTeesPage(driver);
		wtp.buyWomenTees("Iris Workout Top", "l", "green");
		wtp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), wtp.getWtitem());
		Assert.assertEquals(cp.getItemColor(), wtp.getWtcolor());
		Assert.assertEquals(cp.getItemSize(), wtp.getWtsize());
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
	@Feature("Women's Clothing")
	@Story("Buy a Women's bras and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a woman: a bras, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_15_buyWomenBras() {
		WomenBrasPage wbp = new WomenBrasPage(driver);
		wbp.buyWomenBras("Zoe Tank", "s", "green");
		wbp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), wbp.getBritem());
		Assert.assertEquals(cp.getItemColor(), wbp.getBrcolor());
		Assert.assertEquals(cp.getItemSize(), wbp.getBrsize());
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
	@Feature("Women's Clothing")
	@Story("Buy a Women's pants and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a woman: a pants, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_16_buyWomenPants() {
		WomenPantsPage wpp = new WomenPantsPage(driver);
		wpp.buyWomenTees("Cora Parachute Pant", "29", "white");
		wpp.goToCartPage(false);
		Cartpage cp = new Cartpage(driver);
		takeScreenshot();
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), wpp.getWpitem());
		Assert.assertEquals(cp.getItemColor(), wpp.getWpcolor());
		Assert.assertEquals(cp.getItemSize(), wpp.getWpsize());
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
	@Feature("Women's Clothing")
	@Story("Buy a Women's short and complete checkout")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test selects clothing items for a woman: a short, its size and color, verifies that the matching items were actually selected, and purchases the item.")
	public void tc_17_buyWomenShorts() {
		WomenShortsPage wsp = new WomenShortsPage(driver);
		wsp.buyWomenShorts("Bess Yoga Short", "28", "yellow");
		wsp.goToCartPage(false);
		takeScreenshot();
		Cartpage cp = new Cartpage(driver);
		cp.DoCheckout();
		Assert.assertEquals(cp.getItemName(), wsp.getWSitem());
		Assert.assertEquals(cp.getItemColor(), wsp.getWScolor());
		Assert.assertEquals(cp.getItemSize(), wsp.getWSsize());
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
