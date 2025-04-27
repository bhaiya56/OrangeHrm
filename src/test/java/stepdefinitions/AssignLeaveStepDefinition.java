package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AssignLeave;
import pages.LoginPage;

public class AssignLeaveStepDefinition {

    private WebDriver driver;
    AssignLeave al;
    LoginPage lpg;
    WebDriverWait wait;
    
    public AssignLeaveStepDefinition() {
        // Set up ChromeOptions to disable the password breach detection
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordLeakDetection");

        // Initialize WebDriver with the modified ChromeOptions
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        al = new AssignLeave(driver);
        lpg = new LoginPage(driver);
    }
    
    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("assign step defin " + driver.getCurrentUrl());
        
        // Log in with correct credentials
        lpg.loginMethod("sagar", "Pune@1234");
        System.out.println("after login method " + driver.getCurrentUrl());
        
        // Handling alert if it appears (though this shouldn't be needed with the previous fix)
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();  // Accept the alert if it appears
        } catch (Exception e) {
            // No alert found, proceed with the test
            System.out.println("No alert found.");
        }
    }
    
    @And("clicks on Assign Leave options")
    public void click_on_assign_leave_option() {
        System.out.println("inside ");
        al.clickAssignLeave();
    }
    
    @And("Enters employee name {string}")
    public void enter_employee_name(String empName) {
        al.enterEmployeeName(empName);
    }

    @And("Selects Leave type")
    public void select_leave_type() {
        al.clickLeaveDropdown();
    }

    @And("adds comment")
    public void add_comment() {
        al.addComment();
    }

    @And("Select Date")
    public void select_date() {
        al.selectDate();
    }

    @When("Taps on assign button")
    public void tap_on_assign() {
        al.clickAssign();
    }

    @And("Taps on entitlement")
    public void tap_on_leave() {
        al.clickEntitlement();
    }

    @And("Tap on employee entitlement")
    public void select_employee_entitlement() {
        al.clickEmpEnt();
    }

    @And("Enter employee name {string}")
    public void search_employee(String empName2) {
        al.searchEmp(empName2);
    }

    @Then("name of employee who was assigned leave should appear")
    public void verify_record() {
        al.verifyRecord();
    }
}
