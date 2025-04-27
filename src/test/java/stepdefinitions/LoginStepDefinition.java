package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager; // If you want auto driver setup

public class LoginStepDefinition {

    WebDriver driver;
    LoginPage loginPage;

    public LoginStepDefinition() {
        WebDriverManager.chromedriver().setup(); // ✅ Setup chromedriver executable
        this.driver = new ChromeDriver();        // ✅ Create driver here
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ✅ Add implicit wait
        this.driver.manage().window().maximize(); 
        this.loginPage = new LoginPage(driver);  // ✅ Pass driver to page class
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("User enters correct username and password")
    public void user_enters_username_pwd() {
        loginPage.loginMethod("sagar", "Pune@1234");
    }

    @Then("User should be directed to Dashboard")
    public void user_is_on_dashboard() {
        loginPage.dashboardPage();
    }
}
