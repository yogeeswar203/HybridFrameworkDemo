package pageObjects_OrangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.myAccountPages;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void myWait(WebElement el, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	public void clearTextJS(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].value='';", element);
	}
	
	public void enterText(WebElement xpath, String text) {
		try {
			
			myWait(xpath, 10);
			xpath.clear();
			xpath.sendKeys(text);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void clickButton(WebElement element) {
		try {
			myWait(element, 5);
			element.click();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		
	}
	
	public void yearMonthSelection(String year, String month, WebElement txt_year, WebElement txt_mont, WebElement furt_arr, WebElement pastArr)
	{
		while(true)
		{
			String act_year =txt_year.getText();
			String act_month =txt_year.getText();
			if(act_month.equals(month) && act_year.equals(year)) {
				break;
			}
		}
		furt_arr.click();
		//pastArr.click();
		
	}
	
	public void dateSelect(String day, String all_dates)
	{
		List<WebElement> alldate = driver.findElements(By.xpath(all_dates));
		
		for(WebElement e1:alldate)
		{
			String act_date = e1.getText();
			if(act_date.equals("26"))
			{
				e1.click();
			}
		}
	}
	
	public By drp_click = By.xpath("(//div[@class='oxd-select-text-input'])[2]"); 
	public By all_opt = By.xpath("//div[@role='option']//span"); 
	
	public void selectValueFromdropdown(String field)
	{
		driver.findElement(drp_click).click();
		myWait(driver.findElement(all_opt), 0);
		List<WebElement> allOPT = driver.findElements(all_opt);
		boolean opt_found = false;
		
		for(WebElement op:allOPT)
		{
			if(op.getText().trim().equalsIgnoreCase(field))
			{
				op.click();
				opt_found = true;
				break;
			}
		}
		if (!opt_found) {
            System.err.println("Option '" + opt_found + "' not found in the dropdown.");
        }
	}

}
