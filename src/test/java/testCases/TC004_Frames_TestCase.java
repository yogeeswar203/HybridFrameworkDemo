package testCases;

import org.testng.annotations.Test;

import pageObjects.framesPage;
import testBase.testBaseClass;

public class TC004_Frames_TestCase extends testBaseClass{
	
	@Test(groups = "reg")
	public void verify_Frames() {
		logger.info("*******************Test Case 004 execution is Started**********************");
		framesPage fp = new framesPage(driver);
		fp.wlSwitchFrame();
		logger.info("Driver has successfully switched the Frame");
		
		fp.enter_text_f1();
		logger.info("Driver has Entered the data in the FRAME 1");
		
		fp.switchDefault_frame();
		logger.info("Driver has Switched to Default Frame");
		
		fp.switchFrame2();
		logger.info("Driver has Switched to Frame 2");
		
		fp.enter_text_f2();
		logger.info("Driver has Entered the text in Frame 2 Text Box");
		
		fp.switchDefault_frame();
		logger.info("Driver has Switched to Default Frame");
		
		fp.switchFrame3();
		logger.info("Driver has Switched to Frame 3");
		
		fp.enter_text_f3();
		logger.info("Driver has Entered the text in Frame 2 Text Box");
		
		
		
	}
	
	
}
