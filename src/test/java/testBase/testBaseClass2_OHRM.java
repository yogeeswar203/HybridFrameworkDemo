package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects_OrangeHRM.PB_001_Login_OrangeHRM;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class testBaseClass2_OHRM {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	public Properties prfile;
	
	@Parameters({"os", "browser"})
	@BeforeClass(groups = {"sanity","regression","master","reg"})
	public void setUp(String os, String br) throws IOException, InterruptedException {
		// Loading the Configuration files
		FileReader configFile = new FileReader("./src//test//resources//config.properties"); 
		p = new Properties();
		p.load(configFile);
		
		
		
		// calling the Logger 
		logger = LogManager.getLogger(this.getClass());
		
		switch (br.toLowerCase()) {
			case "chrome": driver = new ChromeDriver();	break;
			case "edge" : driver = new EdgeDriver(); break;
			
			// These browser parameters are taking from the xml file where we have specified the browser name

		default:
			System.out.println("Browser is invalid"); return;
		}
		
		driver.get(p.getProperty("appurlOrangeHRM")); // reading the URL from the properties file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		PB_001_Login_OrangeHRM pborm = new PB_001_Login_OrangeHRM(driver);
		
		pborm.eneter_txt_uname(p.getProperty("ohuserName"));
		logger.info("User has entered the user name");
		pborm.enter_txt_pass(p.getProperty("ohpassword"));
		logger.info("User has entered the password");
		pborm.btn_login();
		logger.info("User has clicked on the login button");
		
		
		/*
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		*/
		
	}
	
	@AfterClass(groups = {"sanity","regression","master","reg"})
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	
	public String randomString() {
			
			@SuppressWarnings("deprecation")
			String generatedString =RandomStringUtils.randomAlphabetic(5);
			
			return generatedString;
		}
		
		public String randomNumber() {
			
			@SuppressWarnings("deprecation")
			String generatednum =RandomStringUtils.randomNumeric(9);
			
			return generatednum;
		}
		
		public String randomAlphaNumaric() {
			
			@SuppressWarnings("deprecation")
			String generatednum =RandomStringUtils.randomNumeric(3);
			@SuppressWarnings("deprecation")
			String generatedString =RandomStringUtils.randomAlphabetic(5);
			 
			
			return (generatedString+"@"+generatednum);
		}
		
		
		public String captureScreenshot(String tname) throws Exception {
			String timeStamp=new SimpleDateFormat("yyyyMMsshhmmss").format(new Date());
		
			TakesScreenshot takesScreenShot = (TakesScreenshot)driver;
			Thread.sleep(1000);
			File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
			String targetFilepath = System.getProperty("user.dir")+"\\screenshots\\" + tname+"_"+timeStamp+".png";
			File targetFile = new File(targetFilepath);
			
			
			sourceFile.renameTo(targetFile);
			
			return targetFilepath;
			

			
		}
	

}
