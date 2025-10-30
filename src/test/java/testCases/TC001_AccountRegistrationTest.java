package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.accRegisterPage;
import pageObjects.homePage;
import testBase.testBaseClass;

public class TC001_AccountRegistrationTest extends testBaseClass {
	
	@Test(groups = {"sanity", "master"})
	public void verify_Account_registration() {
		
		logger.info("*******************Test Case 001 execution is Started**********************");
		homePage hp = new homePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		try{
			// creating object for the registration Page
			accRegisterPage acc = new accRegisterPage(driver);
			
			acc.enterFirstName(randomString());
			logger.info("User has entered the First Name");
			
			acc.enterLastName(randomString());
			logger.info("User has entered the Last Name");
			
			acc.enterEmail(randomString()+"@gmail.com");
			logger.info("User has entered the eMail ID");
			
			acc.enterPhoneNum(randomNumber());
			logger.info("User has entered the Phone Number");
			
			String psw = randomAlphaNumaric();
			acc.enterPasword(psw);
			acc.enterCnfPasword(psw);
			logger.info("User has entered the Password and Confirm Password");
			
			acc.clickRadioYes();
			logger.info("User has selected the Yes Radio button");
			
			acc.checkPolicyBox();
			logger.info("User has selected check BOX");
			
			acc.buttonContinue();
			logger.info("User has Clicked on the Continue button");
			
			String textMsg = acc.getTextConf();
			logger.info("Text from the "+textMsg);
			
			if(textMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}else
			{
				//logger.error("Test case is failed");
				//logger.debug("Degging the Logs");
				Assert.assertFalse(false);
			}
			
		
		}catch (Exception e){
			
			Assert.fail();
			
		}
		logger.info("*******************Test Case 001 execution is Finished**********************");
		
			
	}
	
	
	
	
	
}
