package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.DriverManager;
import utils.DriverManager;

public class LoginPage {

	private WebDriver driver;
	
	//constructor to initialise web driver
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	//locators
	
	By usernameField = By.name("username");
	By passwordField = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public void loginMethod(String user,String pwd) {
		
		
		WebElement username = driver.findElement(usernameField);
		username.sendKeys(user);//enter username
		
		WebElement password = driver.findElement(passwordField);
		password.sendKeys(pwd);//enter the password
		
		WebElement loginButton = driver.findElement(loginBtn);
		loginButton.click();
		
		
	
	}
	public void dashboardPage() {
		
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("Dashboard")){
			
			System.out.println("user is on the dashboard");
			
			
		}
		
	}
	
}
