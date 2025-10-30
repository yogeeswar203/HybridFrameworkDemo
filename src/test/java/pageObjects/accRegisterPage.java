package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accRegisterPage extends BasePage{

	public accRegisterPage(WebDriver driver) {
		super(driver);
		
	}
	
	// Identifying all the elements present in the registration Page
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement text_firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement text_LastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement text_mail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement text_telPhone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement text_password;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement text_cnfPasword;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	WebElement radio_yes;
	
	@FindBy(xpath="(//input[@name='newsletter'])[2]")
	WebElement radio_no;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement check_box;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement button_continue;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement confMsg;
	
	// Creating action methods for the above elements
	
	public void enterFirstName(String fname) {
		text_firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		text_LastName.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		text_mail.sendKeys(email);
	}
	
	public void enterPhoneNum(String number) {
		text_telPhone.sendKeys(number);
	}
	
	
	public void enterPasword(String pasword) {
		text_password.sendKeys(pasword);
	}
	
	public void enterCnfPasword(String pasword) {
		text_cnfPasword.sendKeys(pasword);
	}
	
	public void clickRadioYes() {
		radio_yes.click();
	}
	
	public void checkPolicyBox() {
		check_box.click();
	}
	
	public void buttonContinue() {
		button_continue.click();
	}
	
	public String getTextConf() {
		try {
			return confMsg.getText();
		}catch (Exception e) {
			return e.getMessage();
		}
		
	}
	

}
