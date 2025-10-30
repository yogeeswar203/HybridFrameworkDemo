package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends BasePage{

	public homePage(WebDriver driver) {
		super(driver);
		
	}
	
	// Identifying the elements 
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement link_myacc;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement link_register;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement link_login;
	
	
	public void clickMyAccount() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		link_myacc.click();
		
	}
	
	public void clickLogin() {
		link_login.click();
	}
	
	public void clickRegister() {
		link_register.click();
	}
	
	
	
	
	
}
