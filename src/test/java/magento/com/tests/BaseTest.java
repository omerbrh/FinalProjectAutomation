package magento.com.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import magento.com.pageobject.MenuToolBar;

public class BaseTest {

    protected WebDriver driver;

    // Open a new browser before each test
    @BeforeMethod
    @Step("Opening browser and navigating to site")
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.cart2quote.com/what-is-new.html");
        MenuToolBar menu = new MenuToolBar(driver);
        menu.closeWelcome();
        System.out.println("Browser opened and site loaded");
    }

    // Take screenshot and attach to Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Close the browser after each test
    @AfterMethod
    @Step("Closing browser")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }

    // Helper method to log messages to Allure
    @Step("{0}")
    public void log(String message) {
        System.out.println(message); // print in console
    }
}
