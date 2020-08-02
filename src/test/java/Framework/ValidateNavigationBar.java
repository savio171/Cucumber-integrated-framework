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
public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateNavigationBar.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateNavigation() throws IOException
	{
		
		
		//one is inheritance
		//other is creating objects to that class and invoke methods of it
		
		LandingPage l=new LandingPage(driver);
		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Successfully validated text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
