package testCasesOrHRM;

import org.testng.annotations.Test;

import pageObjects_OrangeHRM.PB_001_Login_OrangeHRM;
import pageObjects_OrangeHRM.PB_002_PIM;
import testBase.testBaseClass;

public class TC_002_EmployeeSearch extends testBaseClass{

	
	@Test(groups = {"sanity"})
	public void test_empSearch() throws Exception {
		
		
		logger.info("**********************Test Case 001 Orange HRM is started **********************");
		
		PB_001_Login_OrangeHRM pborm = new PB_001_Login_OrangeHRM(driver);
		
		pborm.eneter_txt_uname(p.getProperty("ohuserName"));
		logger.info("User has entered the user name");
		pborm.enter_txt_pass(p.getProperty("ohpassword"));
		logger.info("User has entered the password");
		pborm.btn_login();
		logger.info("User has clicked on the login button");
		
		
		
		PB_002_PIM em_search = new PB_002_PIM(driver);
		em_search.click_PIM();
		logger.info("User has clicked on the PIM link");
		em_search.enter_ename();
		logger.info("User is entered the Employee Name");
		
		logger.info("**********************Test Case 001 Orange HRM is completed **********************");
		
	}
}
