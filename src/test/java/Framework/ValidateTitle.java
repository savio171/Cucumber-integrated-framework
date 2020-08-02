package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	
	@Test
	public void validateAppTitle() throws IOException
	{
		
		//one is inheritance
		//other is creating objects to that class and invoke methods of it
		
		LandingPage l=new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED C12OUSES");
		log.info("Successfully validated text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
	
}
