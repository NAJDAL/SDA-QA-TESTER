import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Go to URL: https://api.jquery.com/dblclick/
//Double click on the blue square at the bottom of the page and then write the changed color.
//Go top of the page and sendKeys "Thanks to JavascriptExecutor"
//Go to the bottom of the page and click the book, name"jQuery in Action"
// Assignment1

public class JQueryInteraction {
    public static void main(String[] args) {
        // Set path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Go to the URL
        driver.get("https://api.jquery.com/dblclick/");

        // Switch to the iframe containing the blue square
        driver.switchTo().frame(0);

        // Double click on the blue square
        WebElement blueSquare = driver.findElement(By.className("demo"))
                .findElement(By.tagName("div"));
        Actions actions = new Actions(driver);
        actions.doubleClick(blueSquare).perform();

        // Write the changed color
        WebElement colorElement = driver.findElement(By.cssSelector(".ui-widget-content.ui-selected"));
        String changedColor = colorElement.getAttribute("style");
        System.out.println("Changed color: " + changedColor);

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Scroll to the top of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");

        // Send keys "Thanks to JavascriptExecutor"
        js.executeScript("document.body.innerHTML += '<input type=\"text\" id=\"thanksInput\">'");
        WebElement thanksInput = driver.findElement(By.id("thanksInput"));
        thanksInput.sendKeys("Thanks to JavascriptExecutor");

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Click the book named "jQuery in Action"
        WebElement bookLink = driver.findElement(By.xpath("//a[contains(text(),'jQuery in Action')]"));
        bookLink.click();

        // Close the browser
        driver.quit();
    }
}
