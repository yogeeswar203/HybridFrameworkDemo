package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class framesPage extends BasePage{

	public framesPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//frame[@src='frame_1.html']")
	WebElement we_frame_one;
	
	@FindBy(xpath="//input[@name='mytext1']")
	WebElement f1_text_box;
	
	@FindBy(xpath="//frame[@src='frame_2.html']")
	WebElement web_frame2;
	
	@FindBy(xpath="//input[@name='mytext2']")
	WebElement f2_text_box;
	
	@FindBy(xpath="//input[@name='mytext3']")
	WebElement f3_text_box;
	
	@FindBy(xpath="//frame[@src='frame_3.html']")
	WebElement web_frame3;
	
	
	public void switchFrame3() {
		driver.switchTo().frame(web_frame3);
	}
	
	public void enter_text_f3() {
		f3_text_box.sendKeys("Text has been entered in the Text box 3");
	}
	
	public void switchFrame2() {
		driver.switchTo().frame(web_frame2);
	}
	
	
	public void wlSwitchFrame()
	{
		driver.switchTo().frame(we_frame_one);
		
	}

	public void enter_text_f1() {
		f1_text_box.sendKeys("Text Entered");
		
	}
	
	public void enter_text_f2() {
		f2_text_box.sendKeys("Text Entered in Frame 2 Text Box");
		
	}
	
	public void switchDefault_frame() {
		driver.switchTo().defaultContent();
		
	}
	
	
	
	
	public void switchFrame(WebElement frameId)
	{
		driver.switchTo().frame(frameId);
	}
	
	public void switchFrame(int frame_index)
	{
		driver.switchTo().frame(frame_index);
	}
	
	public void switchFrame(String name)
	{
		driver.switchTo().frame(name);
	}
	
	

}
