package testCasesOrHRM;

import org.testng.annotations.Test;


import pageObjects_OrangeHRM.PB_001_Login_OrangeHRM;
import testBase.testBaseClass;

public class TC_001_login_orangeHRM extends testBaseClass{
	
	
	@Test(groups = "sanity")
	public void loginTestorHRM() {
	logger.info("**********************Test Case 001 Orange HRM is started **********************");
	
	PB_001_Login_OrangeHRM pborm = new PB_001_Login_OrangeHRM(driver);
	
	pborm.eneter_txt_uname(p.getProperty("ohuserName"));
	logger.info("User has entered the user name");
	pborm.enter_txt_pass(p.getProperty("ohpassword"));
	logger.info("User has entered the password");
	pborm.btn_login();
	logger.info("User has clicked on the login button");
	
	logger.info("**********************Test Case 001 Orange HRM is completed **********************");
	
		
	}

}
