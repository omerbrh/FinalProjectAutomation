package magento.com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends MenuToolBar {

	protected @FindBy(css = "#email") WebElement EmailField;
	protected @FindBy(css = "[title=\"Password\"]") WebElement PasswordField;
	protected @FindBy(css = "[class=\"action login primary\"]") WebElement SignInbtn;

// Error Messages 
	protected @FindBy(css = "#maincontent > div.page.messages ") WebElement incorrectAcountM;
	protected @FindBy(css = "#email-error") WebElement invalidEmailM;
	protected @FindBy(css = "#password-error") WebElement invalidPasswordM;

	public SignInPage(WebDriver driver) {
		super(driver);

	}

	public void SignIn(String email, String password) {
		click(MSignInbtn);
		fillText(EmailField, email);
		fillText(PasswordField, password);
		click(SignInbtn);

	}

	public String getIncorrectAcountM() {
		waitingToElement(incorrectAcountM);
		return getText(incorrectAcountM);
	}

	public String getInvalidEmailM() {
		waitingToElement(incorrectAcountM);
		return getText(invalidEmailM);
	}

	public String getInvalidPasswordM() {
		waitingToElement(invalidPasswordM);
		return getText(invalidPasswordM);
	}

}
