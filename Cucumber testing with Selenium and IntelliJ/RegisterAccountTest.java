import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//Task01-FluentPOM

//FluentRegisterPage Class: This class represents the registration page and contains methods to interact with its elements.
            /*
            go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
            register account test with fluent page object approach
         */


public class RegisterAccountTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void registerAccountTest() {
        // Navigate to the registration page
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

        // Fill out the registration form
        enterText(By.id("input-firstname"), "John");
        enterText(By.id("input-lastname"), "Doe");
        enterText(By.id("input-email"), "john.doe@example.com");
        enterText(By.id("input-telephone"), "1234567890");
        enterText(By.id("input-password"), "password123");
        enterText(By.id("input-confirm"), "password123");
        clickCheckbox(By.name("agree"));

        // Click on the Continue button
        driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();

        // Verify registration success message
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Registration success message not displayed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickCheckbox(By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
