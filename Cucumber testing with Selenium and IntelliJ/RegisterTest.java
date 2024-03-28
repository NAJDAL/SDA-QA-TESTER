import org.openqa.selenium.WebDriver;
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

public class RegisterTest {

    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerAccountTest() {
        registerPage.navigateToRegistrationPage();
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Doe");
        registerPage.enterEmail("john.doe@example.com");
        registerPage.enterTelephone("1234567890");
        registerPage.enterPassword("password123");
        registerPage.confirmPassword("password123");
        registerPage.agreeToPrivacyPolicy();
        registerPage.clickContinueButton();
        
        String successMessage = registerPage.getRegistrationSuccessMessage();
        Assert.assertTrue(successMessage.contains("Your Account Has Been Created!"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
