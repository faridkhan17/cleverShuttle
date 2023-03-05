package StepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefs {

    public static WebDriver driver ;
    public static WebDriverWait wait ;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("User opens the {string} Page")
    public void userOpensTheUrlPage(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
    }

    @When("User logs in with the credentials {string} and {string}")
    public void UserLogsInWithTheCredentials (String userName, String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("kc-login")).click();
        Thread.sleep(2000);
    }

    @Then("User should see the calendar view")
    public void UserShouldSeeTheCalendarView() {
        driver.findElement(By.cssSelector("div[class$=-title]")).isDisplayed();
    }
}