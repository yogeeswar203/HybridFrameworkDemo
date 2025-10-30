package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPages extends BasePage{

	public myAccountPages(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//div[@id=\"content\"]//h2[1]")
	WebElement text_account;
	
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	WebElement btn_logout;
	
	
	public boolean isMyAccountDisplayed() {
		try
		{
			return(text_account.isDisplayed());
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout() {
		btn_logout.click();
	}

}
