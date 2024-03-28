import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

//@homework
//Feature: Homework
 // Scenario Outline:  dynamic url
  //  Given user goes to the "<page_url>"
  //  Then user waits for 5 seconds
  //  And verifies that the page title contains the word "<title>"
  //  And closes the page
  //  Examples:
   //   |page_url|  title|
   //   |googleUrl | Google |
   //   |amazonUrl | Amazon |
   //   |youtubeUrl | YouTube  |

public class StepDefinitions {

    @Given("user goes to the {string}")
    public void user_goes_to_the_page(String pageUrl) {
        // Code to navigate to the given page URL
        System.out.println("Navigating to: " + pageUrl);
    }

    @Then("user waits for 5 seconds")
    public void user_waits_for_5_seconds() {
        // Code to wait for 5 seconds
        System.out.println("Waiting for 5 seconds");
    }

    @And("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String expectedTitle) {
        // Code to verify that the page title contains the expected word
        System.out.println("Verifying page title contains: " + expectedTitle);
    }

    @And("closes the page")
    public void closes_the_page() {
        // Code to close the page
        System.out.println("Closing the page");
    }
}
