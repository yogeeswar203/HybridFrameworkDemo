package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myAccountPages;
import testBase.testBaseClass;

public class TC002_LoginTestCase extends testBaseClass{

	@Test(groups = {"sanity","master"})
	public void verify_login() {
		logger.info("*****************TC 002 Execution is started*****************");
		try {
			homePage hp = new homePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("Navigated to the Login Page ");
			
			
			// Taking next Page objects Page
			
			loginPage lp = new loginPage(driver);
			lp.enterUsername(p.getProperty("username"));
			lp.enterPassword(p.getProperty("password"));
			lp.buttonClick();
			logger.info("User has entered the user name and password");
			
			// My Account Page objects
			
			myAccountPages myPag = new myAccountPages(driver);
			boolean target=  myPag.isMyAccountDisplayed();
			logger.info("User has entered Navigated to the My Account Page");
			Assert.assertEquals(target, true);
			
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****************TC 002 Execution is Finished*****************");
		
	}
}
