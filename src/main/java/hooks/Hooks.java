package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

	WebDriver driver;
	@Before
    public void setUp() {
        DriverManager.getDriver(); // initialize driver before each scenario
    }
/*
    @After
    public void tearDown() {
    	if(driver!=null) {
        DriverManager.quitDriver(); // close browser after each scenario
    	}
    	}
    	*/

}
