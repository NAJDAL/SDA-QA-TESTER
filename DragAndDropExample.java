import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

 /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
//Assignment 3
public class DragAndDropExample {
    public static void main(String[] args) {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver","C:\Users\najda\Downloads\chromedriver_win32\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // Locate the elements
        WebElement bankButton = driver.findElement(By.id("bank"));
        WebElement salesButton = driver.findElement(By.id("sales"));
        WebElement amount5000Button = driver.findElement(By.xpath("//a[text()=' 5000 ']"));
        WebElement debitSideAccount = driver.findElement(By.xpath("//ol[@id='bank']"));
        WebElement creditSideAccount = driver.findElement(By.xpath("//ol[@id='loan']"));
        WebElement debitSideAmount = driver.findElement(By.xpath("//ol[@id='amt7']"));
        WebElement creditSideAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));

        // Perform drag-and-drop operations
        Actions actions = new Actions(driver);
        actions.dragAndDrop(bankButton, debitSideAccount).build().perform();
        actions.dragAndDrop(salesButton, creditSideAccount).build().perform();
        actions.dragAndDrop(amount5000Button, debitSideAmount).build().perform();

        // Perform second drag-and-drop for 5000 button
        actions.clickAndHold(amount5000Button).moveToElement(creditSideAmount).release().build().perform();

        // Verify the visibility of the "Perfect" text
        WebElement perfectText = driver.findElement(By.xpath("//a[text()='Perfect!']"));
        boolean perfectTextVisible = perfectText.isDisplayed();
        System.out.println("Is 'Perfect' text visible? " + perfectTextVisible);

        // Close the browser
        driver.quit();
    }
}
