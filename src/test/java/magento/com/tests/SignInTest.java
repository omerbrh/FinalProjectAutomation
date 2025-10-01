package magento.com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.Assert;

import magento.com.pageobject.SignInPage;

public class SignInTest extends BaseTest {

	@Test(dataProvider = "getData", description = "use incorect login information")
	@Feature("User Authentication")
	@Story("Attempt login with incorrect credentials")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test attempts to sign in with incorrect credentials and verifies that the appropriate error message is displayed.")
	public void tc01_loginFailed(String email, String password) {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn(email, password);
		Assert.assertEquals(sip.getIncorrectAcountM(),
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
		takeScreenshot();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "omerbrh81@gmail.com", "1234567" }

		};
		return myData;
	}

	@Test
	@Feature("User Authentication")
	@Story("Sign in with invalid email format")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test enters an invalid email format during sign-in and verifies that the system shows the correct validation message.")
	public void tc02_invalidEmail() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn("omerbrh.gmail.com", "ob260494Q");
		takeScreenshot();
		Assert.assertEquals(sip.getInvalidEmailM(), "Please enter a valid email address (Ex: johndoe@domain.com).");
	}

	@Test
	@Feature("User Authentication")
	@Story("Sign in with empty email field")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test leaves the email field empty during sign-in and verifies that the required field error appears.")
	public void tc03_emptyEmailField() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn("", "ob123456");
		takeScreenshot();
		Assert.assertEquals(sip.getInvalidEmailM(), "This is a required field.");

	}

	@Test
	@Feature("User Authentication")
	@Story("Sign in with empty password field")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test leaves the password field empty and verifies that the required field error message is displayed.")
	public void tc04_emptyPasswordField() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn("omerbrh81@gmail.com", "");
		takeScreenshot();
		Assert.assertEquals(sip.getInvalidPasswordM(), "This is a required field.");

	}

	@Test
	@Feature("User Authentication")
	@Story("Sign in with valid credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This test signs in with correct credentials and verifies that the welcome message is displayed.")
	public void tc05_validLogin() {
		SignInPage sip = new SignInPage(driver);
		sip.SignIn("omerbrh81@gmail.com", "Omer1234567!");
		sip.watingToWelcome();
		takeScreenshot();
		Assert.assertEquals(sip.getWelcomeUser(), "Welcome, omer BRACHA!");

	}

}