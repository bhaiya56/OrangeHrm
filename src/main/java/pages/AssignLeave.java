package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utils.DriverManager;

public class AssignLeave {

	private WebDriver driver;
	WebDriverWait wait;
	// locators

	By assignLeaveButton = By.xpath("//button[@title='Assign Leave']");
	By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
	By leaveDropdown = By.xpath("//div[@class='oxd-select-text-input']");
	By leaveTitle = By.xpath("//span[contains(text(),'CAN - Personal')]");
	By fromBox = By.xpath("(//div[@class='oxd-date-input'])[1]");
	By fromDate = By.xpath("//div[@class='oxd-calendar-date' and contains(text(),'21')]");
	By toBox = By.xpath("(//div[@class='oxd-date-input'])[2]");
	By toDate = By.xpath("//div[@class='oxd-calendar-date' and contains(text(),'25')]");
	By cmtField = By.xpath("//textarea");
	By assignButton = By.xpath("//button[@type='submit']");
	By entitlementBtn = By.xpath("//span[contains(text(),'Entitlements')]");
	By empEntitlement = By.xpath("//a[contains(text(),'Employee Entitlements')]");
	By recordVerify = By.xpath("//span[contains(normalize-space(),'(1) Record Found')]");

	public AssignLeave(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}

	public void clickAssignLeave() {

		System.out.println("Inside clickAssignLeave");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement assign_leave_button = driver.findElement(assignLeaveButton);
		wait.until(ExpectedConditions.visibilityOfAllElements(assign_leave_button));
		assign_leave_button.click();
	}

	public void enterEmployeeName(String empName) {
		// step 1 : enter employee name
		driver.findElement(employeeNameField).sendKeys(empName);

		// Step 2: Wait for suggestions to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']//span")));

		// Step 3: Loop through suggestions and click the match
		for (WebElement suggestion : suggestions) {
			if (suggestion.getText().equalsIgnoreCase(empName)) {
				suggestion.click();
				break;
			}
		}

	}

	public void clickLeaveDropdown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement drp = driver.findElement(leaveDropdown);
		drp.click();
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(leaveTitle));
		option.click();

	}

	public void selectDate() {

		WebElement fromButton = driver.findElement(fromBox);
		fromButton.click();
		WebElement fromDateSelector = driver.findElement(fromDate);
		fromDateSelector.click();

		WebElement toButton = driver.findElement(toBox);
		toButton.click();
		WebElement toDateSelector = driver.findElement(toDate);
		toDateSelector.click();
	}

	public void addComment() {
		WebElement cmt = driver.findElement(cmtField);
		cmt.sendKeys("good luck");

		
	}

	public void clickAssign() {
		WebElement asnBtn = driver.findElement(assignButton);
		asnBtn.click();
	}

	public void clickEntitlement() {

		WebElement ent = driver.findElement(entitlementBtn);
		ent.click();
	}

	public void clickEmpEnt() {

		WebElement employeeEnt = driver.findElement(empEntitlement);
		employeeEnt.click();

	}

	public void searchEmp(String empName2) {
		// step 1 : enter employee name
				driver.findElement(employeeNameField).sendKeys(empName2);

				// Step 2: Wait for suggestions to load
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']//span")));

				// Step 3: Loop through suggestions and click the match
				for (WebElement suggestion : suggestions) {
					if (suggestion.getText().equalsIgnoreCase(empName2)) {
						suggestion.click();
						break;
					}
				}
	}
	public void verifyRecord() {
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement vr = driver.findElement(recordVerify);
		String rec = "(1) Record Found";
		
		if(vr.getText().contentEquals(rec)) {
			System.out.println("test is passed");
			
		}
	}

}
