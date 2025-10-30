package testCasesOrHRM;

import org.testng.annotations.Test;

import pageObjects_OrangeHRM.PB_002_PIM;
import pageObjects_OrangeHRM.PB_003_addEmployee;
import testBase.testBaseClass2_OHRM;
import utilities.DataProviders;


public class TC_003_addEmployee extends testBaseClass2_OHRM{
	
	@Test(groups = {"sanity"}, dataProvider = "addEmpData", dataProviderClass = DataProviders.class)
	public void verify_addEmplyee(String fname, String mname, String lname, String date, String maritalstatus) throws InterruptedException {
		
		PB_002_PIM pim = new PB_002_PIM(driver);
		pim.click_PIM();
		logger.info("User has clicked on PIM link");
		
		
		PB_003_addEmployee addEmp = new PB_003_addEmployee(driver);
		addEmp.btn_addEmployee();
		addEmp.enterFirstName(fname);
		addEmp.enterMiddleName(mname);
		addEmp.enterLastName(lname);
		addEmp.btn_clickSave();
		Thread.sleep(6000);
		addEmp.enterOtherID(randomNumber());
		addEmp.enterDl(randomAlphaNumaric());
		Thread.sleep(2000);
		addEmp.dateSelection(date);
		Thread.sleep(2000);
		addEmp.select_Nationality();
		Thread.sleep(2000);
		addEmp.select_marital_satus();
	}

}
