package pageObjects_OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PB_003_addEmployee extends BasePage{

	public PB_003_addEmployee(WebDriver driver) {
		super(driver);
		
	}
	

	
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement add_Employee;
	
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement txt_Fname;
	
	@FindBy(xpath="//input[@name='middleName']")
	WebElement txt_Mname;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement txt_Lname;
	
	@FindBy(xpath="(//label[text()='Employee Id']/../following::input)[1]")
	WebElement emp_id;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement btn_save;
	
	// Employee List details
	
	@FindBy(xpath="(//label[text()='Employee Id']/../following::input)[2]")
	WebElement text_otherID;
	
	@FindBy(xpath="(//label[text()='Employee Id']/../following::input)[3]")
	WebElement text_DLNum;
	
	@FindBy(xpath="//div[@role='option']//span[text()='Indian']")
	WebElement sel_indian;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
	WebElement sel_drp_nationality;
	
	@FindBy(xpath="(//div[@class='oxd-date-input'])[1]//input")
	WebElement drp_ledate;
	
	@FindBy(xpath="//li//div[@class='oxd-calendar-selector-month-selected']//p")
	WebElement drp_month;
	
	@FindBy(xpath="//li//div[@class='oxd-calendar-selector-year-selected']//p")
	WebElement drp_year;
	
	@FindBy(xpath="(//div[@class='oxd-date-input-calendar']//button[@type='button'])[2]")
	WebElement drp_dutureArrow;
	
	@FindBy(xpath="//div[@class='oxd-calendar-dates-grid']//div/div")
	WebElement web_alldates;
	
	// Marital status 
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
	WebElement drp_marital_status;
	
	// Blood Type
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[3]")
	WebElement drp_blood_type;
	
	// adding xpath for commit purpose
	@FindBy(xpath="")
	WebElement e1;

	
	
	
	public void enterOtherID(String other_id) {
		enterText(text_otherID, other_id);
	}
	
	public void enterDl(String dl) {
		enterText(text_DLNum, dl);
	}
	
	public void select_Nationality() throws InterruptedException {
		clickButton(sel_drp_nationality);
		Thread.sleep(2000);
		clickButton(sel_indian);
		
	}
	
	public void enterFirstName(String FirstName) {
		enterText(txt_Fname, FirstName);
	}
	
	public void enterMiddleName(String MiddleName) {
		enterText(txt_Mname, MiddleName);
	}
	
	public void enterLastName(String LastName) {
		enterText(txt_Lname, LastName);
	}
	
	public void enterEmpID(String empId) {
		clearTextJS(add_Employee);
		enterText(emp_id, empId);
	}
	
	public void btn_clickSave() {
		clickButton(btn_save);
	}
	
	public void btn_addEmployee() {
		clickButton(add_Employee);
	}
	
	
	public void dateSelection(String date) {
		drp_ledate.click();
		drp_ledate.sendKeys(date);
		drp_ledate.click();
		
		
	}
	
	public void select_marital_satus() {
		selectValueFromdropdown("Single");
	}

	
	
	
	
	
	
	

}
