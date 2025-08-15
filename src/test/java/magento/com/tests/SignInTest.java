package magento.com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import magento.com.pageobject.SignInPage;

public class SignInTest extends BaseTest {

	@Test(dataProvider = "getData", description = "use incorect login information")
	public void tc01_loginFailed(String email, String password) {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn(email, password);
		AssertJUnit.assertEquals(sip.getIncorrectAcountM(),
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "omerbrh81@gmail.com", "1234567" }, { "omerbrh@gmail.com", "ob260494Q" },
				{ " Omerbrh@Gmail.com", "ob260494Q " },

		};
		return myData;
	}

	@Test
	public void tc02_invalidEmail() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn("omerbrh.gmail.com", "ob260494Q");
		AssertJUnit.assertEquals(sip.getInvalidEmailM(),
				"Please enter a valid email address (Ex: johndoe@domain.com).");

	}

	@Test
	public void tc03_emptyEmailField() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn(" ", "ob260494Q");
		AssertJUnit.assertEquals(sip.getInvalidEmailM(), "This is a required field.");

	}

	@Test
	public void tc04_emptyPasswordField() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn("omerbrh81@gmail.com", " ");
		AssertJUnit.assertEquals(sip.getInvalidPasswordM(), "This is a required field.");

	}

	@Test
	public void tc04_validLogin() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn("omerbrh81@gmail.com", "O,er1234567!");
		sip.watingToWelcome();
		AssertJUnit.assertEquals(sip.getWelcomeUser(), "Welcome, omer bracha!");

	}

}
