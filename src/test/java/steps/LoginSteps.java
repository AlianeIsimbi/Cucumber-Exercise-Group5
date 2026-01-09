package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class LoginSteps {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\java\\Cucumber_AskOmDch\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on the Account page of AskOmDch website")
    public void i_am_on_the_account_page_of_ask_om_dch_website() {
        driver.get("https://askomdch.com/account/");
    }
    @When("I enter valid <username> and <password>")
    public void i_enter_valid_username_and_password() {
        driver.findElement(By.name("username")).sendKeys("User101");
        driver.findElement(By.name("password")).sendKeys("user123");
        driver.findElement(By.name("login")).click();
    }
    @Then("I should be taken to Dashboard")
    public void i_should_be_taken_to_dashboard() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.linkText("Dashboard")).isDisplayed();
    }

    @After
    public void quitBrowser(){
        driver.quit();
    }


    @When("I enter {string} and {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }

    @Then("I should see an error {string}")
    public void iShouldSeeAnErrorMessageIndicatingInvalidLoginCredentials(String expectedMessage) {
        By errorMessage = By.cssSelector(".woocommerce-error li");
        String message = driver.findElement(errorMessage).getText();
        System.out.println(message+"errrrrrrrrr");
        assertEquals(
                expectedMessage, message, message
        );
    }

    @And("I should remain on the Account page")
    public void iShouldRemainOnTheAccountPage() {
    }

}
