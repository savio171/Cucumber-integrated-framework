package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider ="getData")
	public void basePageNavigation(String username, String password, String text) 
	{
		
		driver.get(prop.getProperty("url"));
		//one is inheritance
		//other is creating objects to that class and invoke methods of it
		
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin();
		
	
		
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		//System.out.println(text);
		log.info(text);
		lp.submit().click();
		ForgotPassword fp=lp.forgotPassword();
		fp.getEmail().sendKeys("hello");
		fp.sendInstructions().click();
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row
		//column
		Object [][] data=new Object[2][3];
		
		//1st data
		data[0][0]="restricteduser@qa.com";
		data[0][1]="141415";
		data[0][2]="restricted user";
		
		//2n data
		data[1][0]="nonrestricteduser@qa.com";
		data[1][1]="767857";
		data[1][2]="nonrestricted user";
		
		return data;
		
		
	}
	
}
