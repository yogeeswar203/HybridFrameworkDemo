package pageObjects_OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PB_001_Login_OrangeHRM  extends BasePage{

	public PB_001_Login_OrangeHRM(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txtuserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_login;
	
	
	
	
	public void eneter_txt_uname(String userName) {
		txtuserName.sendKeys(userName);
	}
	
	public void enter_txt_pass(String passW) {
		txtPassword.sendKeys(passW);
	}
	
	public void btn_login() {
		btn_login.click();;
	}
	

}
