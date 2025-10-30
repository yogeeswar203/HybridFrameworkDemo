package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myAccountPages;
import testBase.testBaseClass;
import utilities.DataProviders;

public class TC003_loginDDT extends testBaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class, groups = { "regression","master"} )
	public void verify_DDT(String uname, String password, String result) {
	
		logger.info("********* TC 003 is started **************");
		try {
			homePage hp = new homePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			// login page 
			
			loginPage lp = new loginPage(driver);
			lp.enterUsername(uname);
			lp.enterPassword(password);
			lp.buttonClick();
			
			
			//My Account
			myAccountPages ma = new myAccountPages(driver);
			boolean targetPage = ma.isMyAccountDisplayed();
			
			if(result.equalsIgnoreCase("valid"))
			{
				if(targetPage==true)
				{
					ma.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
				
			}else if(result.equalsIgnoreCase("invalid")) {
				if(targetPage==true)
				{
					ma.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
				
			}
			
		}catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		
	}
}
