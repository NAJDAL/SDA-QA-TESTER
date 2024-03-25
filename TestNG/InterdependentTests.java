import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//DependsOn
 
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */

public class InterdependentTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\Users\najda\Downloads\chromedriver_win32\chromedriver.exe"");

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
    }

    @Test
    public void test1_GoToFacebook() {
        // Go to Facebook
        driver.get("https://www.facebook.com/");
    }

    @Test(dependsOnMethods = "test1_GoToFacebook")
    public void test2_GoToGoogle() {
        // Go to Google
        driver.get("https://www.google.com/");
    }

    @Test(dependsOnMethods = "test2_GoToGoogle")
    public void test3_GoToAmazon() {
        // Go to Amazon
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
