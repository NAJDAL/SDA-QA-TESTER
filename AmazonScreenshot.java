import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

// Assignment 7
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot

public class AmazonScreenshot {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver","C:\Users\najda\Downloads\chromedriver_win32\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to Amazon website
        driver.get("https://www.amazon.com/");

        // Take full-page screenshot
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("fullpage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Take screenshot of a specific WebElement
        WebElement element = driver.findElement(By.id("nav-logo-sprites"));
        Screenshot elementScreenshot = new AShot().takeScreenshot(driver, element);
        try {
            ImageIO.write(elementScreenshot.getImage(), "PNG", new File("element.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
