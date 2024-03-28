import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Task01-FluentPOM

//FluentRegisterPage Class: This class represents the registration page and contains methods to interact with its elements.
            /*
            go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
            register account test with fluent page object approach
         */



public class FluentRegisterPage {

    private WebDriver driver;

    public FluentRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public FluentRegisterPage navigateToRegistrationPage() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        return this;
    }

    public FluentRegisterPage enterFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FluentRegisterPage enterLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FluentRegisterPage enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public FluentRegisterPage enterTelephone(String telephone) {
        WebElement telephoneInput = driver.findElement(By.id("input-telephone"));
        telephoneInput.clear();
        telephoneInput.sendKeys(telephone);
        return this;
    }

    public FluentRegisterPage enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public FluentRegisterPage confirmPassword(String confirmPassword) {
        WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }

    public FluentRegisterPage agreeToPrivacyPolicy() {
        WebElement privacyPolicyCheckbox = driver.findElement(By.name("agree"));
        if (!privacyPolicyCheckbox.isSelected()) {
            privacyPolicyCheckbox.click();
        }
        return this;
    }

    public FluentRegisterPage clickContinueButton() {
        driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();
        return this;
    }

    public void verifyRegistrationSuccessMessage() {
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        assert successMessage.isDisplayed() : "Registration success message not displayed";
    }
}
