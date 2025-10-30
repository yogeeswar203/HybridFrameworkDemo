package pageObjects_OrangeHRM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PB_002_PIM extends BasePage{

	public PB_002_PIM(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement link_PIM;
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement text_empName;
	
	
	
	public void click_PIM() {
		
		link_PIM.click();
	}
	
	public void enter_ename() throws Exception {
		
		text_empName.sendKeys("99");
		Thread.sleep(2000);
		text_empName.sendKeys(Keys.ARROW_DOWN);
		text_empName.sendKeys(Keys.ENTER);
	}

}
