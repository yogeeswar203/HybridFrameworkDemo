package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

	public loginPage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy(id="input-email")
	WebElement text_username;
	
	@FindBy(id="input-password")
	WebElement text_password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	
	public void enterUsername(String uname)
	{
		text_username.sendKeys(uname);
	}
	
	public void enterPassword(String password)
	{
		text_password.sendKeys(password);
	}
	
	public void buttonClick()
	{
		btn_login.click();
	}
}
